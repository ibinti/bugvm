package com.bugvm.ios.inapppurchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bugvm.apple.foundation.NSBundle;
import com.bugvm.apple.foundation.NSURL;
import com.bugvm.apple.storekit.SKPaymentQueue;
import com.bugvm.apple.storekit.SKProductsRequest;
import com.bugvm.apple.storekit.SKProductsResponse;
import com.bugvm.apple.storekit.SKRequest;
import com.bugvm.apple.foundation.Foundation;
import com.bugvm.apple.foundation.NSData;
import com.bugvm.apple.foundation.NSError;
import com.bugvm.apple.storekit.SKPayment;
import com.bugvm.apple.storekit.SKPaymentTransaction;
import com.bugvm.apple.storekit.SKProduct;
import com.bugvm.apple.storekit.SKProductsRequestDelegateAdapter;
import com.bugvm.apple.storekit.SKReceiptRefreshRequest;
import com.bugvm.apple.storekit.SKRequestDelegateAdapter;

/** An easy to use in-app purchase system for iOS. */
public class AppStoreManager {
    public static String TAG = "[AppStoreManager] ";

    private final com.bugvm.ios.inapppurchase.AppStoreListener listener;
    private SKProductsRequest productsRequest;
    private final CustomTransactionObserver paymentObserver;
    private boolean requestingProducts;
    private boolean restoringProducts;

    private boolean autoFinishTransactions = true;

    private final List<SKPaymentTransaction> restoredTransactions = new ArrayList<SKPaymentTransaction>();

    /**
     * Create a new instance of the InAppPurchaseManager.
     *
     * @param listener The listener interface for common callbacks.
     */
    public AppStoreManager(com.bugvm.ios.inapppurchase.AppStoreListener listener) {
        paymentObserver = new CustomTransactionObserver(this);
        this.listener = listener;

        SKPaymentQueue.getDefaultQueue().addTransactionObserver(paymentObserver);
    }

    /** Verify that the iTunes account can make purchases for this application. */
    public boolean canMakePayments() {
        return SKPaymentQueue.canMakePayments();
    }

    /** Call this when you no longer want to use the InAppPurchaseManager. */
    public void unregisterObserver() {
        SKPaymentQueue.getDefaultQueue().removeTransactionObserver(paymentObserver);
    }

    /**
     * Request the product information for the specified product identifiers.
     * Calls {@link com.bugvm.ios.inapppurchase.AppStoreListener#productsReceived(SKProduct[])} on success
     * or {@link com.bugvm.ios.inapppurchase.AppStoreListener#productsRequestFailed(SKRequest, NSError)} on
     * fail.
     *
     * @param productIds The identifiers of the products you want to query.
     */
    public void requestProducts(String... productIds) {
        requestProducts(new HashSet<>(Arrays.asList(productIds)));
    }

    /**
     * Request the product information for the specified product identifiers.
     * Calls {@link com.bugvm.ios.inapppurchase.AppStoreListener#productsReceived(SKProduct[])} on success
     * or {@link com.bugvm.ios.inapppurchase.AppStoreListener#productsRequestFailed(SKRequest, NSError)} on
     * fail.
     *
     * @param productIds The identifiers of the products you want to query.
     */
    public void requestProduct(List<String> productIds) {
        requestProducts(new HashSet<>(productIds));
    }

    /**
     * Request the product information for the specified product identifiers.
     * Calls {@link com.bugvm.ios.inapppurchase.AppStoreListener#productsReceived(SKProduct[])} on success
     * or {@link com.bugvm.ios.inapppurchase.AppStoreListener#productsRequestFailed(SKRequest, NSError)} on
     * fail.
     *
     * @param productIds The identifiers of the products you want to query.
     */
    public void requestProducts(Set<String> productIds) {
        if (requestingProducts) {
            System.out.println(TAG + "Already requesting products!");
            return;
        }
        requestingProducts = true;
        System.out.println(TAG + "Requesting product data...");

        productsRequest = new SKProductsRequest(productIds);
        productsRequest.setDelegate(new RequestDelegate());
        productsRequest.start();
    }

    /**
     * Purchase the specified product. Should be preceded by a call to
     * {@link #canMakePayments()} to check if the user can buy.
     *
     * @param product The product to buy.
     */
    public void purchaseProduct(SKProduct product) {
        if (product == null) {
            throw new NullPointerException("product");
        }

        System.out.println(TAG + "Purchasing product '" + product.getLocalizedTitle() + "'...");
        SKPayment payment = new SKPayment(product);
        SKPaymentQueue.getDefaultQueue().addPayment(payment);
    }

    /** Restore any transactions that occurred for this Apple ID. */
    public void restoreTransactions() {
        if (restoringProducts) {
            System.out.println(TAG + "Already restoring products!");
            return;
        }
        restoringProducts = true;
        System.out.println(TAG + "Restoring products...");

        SKPaymentQueue.getDefaultQueue().restoreCompletedTransactions();
    }

    /**
     * Returns {@code true} if products are already being requested, else
     * {@code false}.
     **/
    public boolean isRequestingProducts() {
        return requestingProducts;
    }

    private class RequestDelegate extends SKProductsRequestDelegateAdapter {
        @Override
        public void didReceiveResponse(SKProductsRequest request, SKProductsResponse response) {
            System.out.println(TAG + "Products successfully received!");
            requestingProducts = false;

            List<SKProduct> products = response.getProducts();

            for (SKProduct product : products) {
                System.out.println(TAG + "productsReceived: " +product.getProductIdentifier().toString());
            }

            listener.productsReceived(products);
        }

        @Override
        public void didFail(SKRequest request, NSError error) {
            System.out.println(TAG + "Products request failed! Error: "
                    + (error != null ? error.toString() : "unknown"));
            requestingProducts = false;

            listener.productsRequestFailed(request, error);
        }
    }

    protected void transactionCompleted(SKPaymentTransaction transaction) {
        System.out
                .println(TAG + "Completed transaction '" + transaction.getTransactionIdentifier() + "' successfully!");
        if (autoFinishTransactions) {
            SKPaymentQueue.getDefaultQueue().finishTransaction(transaction);
        }

        listener.transactionCompleted(transaction);
    }

    protected void transactionDeferred(SKPaymentTransaction transaction) {
        System.out.println(TAG + "Transaction '" + transaction.getTransactionIdentifier()
                + "' deferred! Waiting for other transaction states...");

        listener.transactionDeferred(transaction);
    }

    protected void transactionFailed(SKPaymentTransaction transaction) {
        System.out.println(TAG + "Transaction '" + transaction.getTransactionIdentifier() + "' failed! Error: "
                + (transaction.getError() != null ? transaction.getError().toString() : "unknown"));
        if (autoFinishTransactions) {
            SKPaymentQueue.getDefaultQueue().finishTransaction(transaction);
        }

        listener.transactionFailed(transaction, transaction.getError());
    }

    protected void transactionRestored(SKPaymentTransaction transaction) {
        System.out.println(TAG + "Restored transaction '" + transaction.getTransactionIdentifier() + "' successfully!");
        if (autoFinishTransactions) {
            SKPaymentQueue.getDefaultQueue().finishTransaction(transaction);
        }
        restoredTransactions.add(transaction);

        listener.transactionRestored(transaction);
    }

    protected void restoreCompleted(SKPaymentQueue queue) {
        System.out.println(TAG + "Transactions successfully restored!");
        restoringProducts = false;

        listener.transactionRestoreCompleted(new ArrayList<SKPaymentTransaction>(restoredTransactions));
        restoredTransactions.clear();
    }

    protected void restoreFailed(SKPaymentQueue queue, NSError error) {
        System.out.println(TAG + "Restoring transactions failed with error " + error.description());
        restoringProducts = false;

        listener.transactionRestoreFailed(queue.getTransactions(), error);
        restoredTransactions.clear();
    }

    public void setAutoFinishTransactions(boolean autoFinish) {
        this.autoFinishTransactions = autoFinish;
    }

    public void finishTransaction(SKPaymentTransaction transaction) {
        SKPaymentQueue.getDefaultQueue().finishTransaction(transaction);
    }

    public void requestAppStoreReceipt(AppStoreReceiptRequestListener listener) {
        requestAppStoreReceipt(null, listener);
    }

    @SuppressWarnings("deprecation")
    public void requestAppStoreReceipt(SKPaymentTransaction transaction, final AppStoreReceiptRequestListener listener) {
        NSData receipt = null;
        int version = Foundation.getMajorSystemVersion();

        if (version >= 7) {
            NSURL receiptURL = NSBundle.getMainBundle().getAppStoreReceiptURL();
            receipt = NSData.read(receiptURL);
            if (receipt == null) {
                final SKReceiptRefreshRequest request = new SKReceiptRefreshRequest();
                request.setDelegate(new SKRequestDelegateAdapter() {
                    @Override
                    public void didFinish(SKRequest r) {
                        if (r.equals(request)) {
                            NSURL receiptURL = NSBundle.getMainBundle().getAppStoreReceiptURL();
                            NSData receipt = NSData.read(receiptURL);
                            listener.onSuccess(receipt);
                        } else {
                            listener.onFail();
                        }
                    }

                    @Override
                    public void didFail(SKRequest request, NSError error) {
                        listener.onFail();
                    }
                });
                request.start();
                return;
            }
        } else if (transaction != null) {
            receipt = transaction.getTransactionReceipt();
        }

        if (receipt != null) {

            listener.onSuccess(receipt);

        } else {
            listener.onFail();
        }
    }

    public interface AppStoreReceiptRequestListener {
        public void onSuccess(NSData receipt);

        public void onFail();
    }
}
