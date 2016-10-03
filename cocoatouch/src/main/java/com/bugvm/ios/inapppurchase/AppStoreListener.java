package com.bugvm.ios.inapppurchase;

import java.util.List;

import com.bugvm.apple.storekit.SKRequest;
import com.bugvm.apple.foundation.NSError;
import com.bugvm.apple.storekit.SKPaymentTransaction;
import com.bugvm.apple.storekit.SKProduct;

/** Listener for common in-app purchase events. */
public interface AppStoreListener {
    /** Called when the requested products have been received. */
    public void productsReceived(List<SKProduct> products);

    /**
     * Called when the products request has failed.
     * 
     * @param request The original request.
     * @param error Error information.
     */
    public void productsRequestFailed(SKRequest request, NSError error);

    /**
     * Called when the transaction was completed successfully.
     * 
     * @param transaction
     */
    public void transactionCompleted(SKPaymentTransaction transaction);

    /**
     * Called when the transaction has failed.
     * 
     * @param transaction
     * @param error
     */
    public void transactionFailed(SKPaymentTransaction transaction, NSError error);

    /**
     * Called when an already completed transaction has been restored
     * successfully.
     * 
     * @param transaction
     */
    public void transactionRestored(SKPaymentTransaction transaction);

    /**
     * Called when Ask to Buy is activated and the transaction must wait until
     * it has been approved or denied.
     * 
     * @param transaction
     */
    public void transactionDeferred(SKPaymentTransaction transaction);

    /**
     * Called when the transaction restoration process has been completed
     * successfully.
     * 
     * @param transactions
     */
    public void transactionRestoreCompleted(List<SKPaymentTransaction> transactions);

    /**
     * Called when the transactions couldn't been restored.
     * 
     * @param transactions
     * @param error
     */
    public void transactionRestoreFailed(List<SKPaymentTransaction> transactions, NSError error);
}
