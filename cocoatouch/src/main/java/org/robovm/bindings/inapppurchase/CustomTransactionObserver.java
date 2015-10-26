package org.robovm.bindings.inapppurchase;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.storekit.SKPaymentQueue;
import org.robovm.apple.storekit.SKPaymentTransaction;
import org.robovm.apple.storekit.SKPaymentTransactionObserverAdapter;

public class CustomTransactionObserver extends SKPaymentTransactionObserverAdapter {
    private final AppStoreManager manager;

    public CustomTransactionObserver(AppStoreManager manager) {
        this.manager = manager;
    }

    @Override
    public void updatedTransactions(SKPaymentQueue queue, NSArray<SKPaymentTransaction> transactions) {
        for (SKPaymentTransaction transaction : transactions) {
            switch (transaction.getTransactionState()) {
            case Purchased:
                manager.transactionCompleted(transaction);
                break;
            case Failed:
                manager.transactionFailed(transaction);
                break;
            case Restored:
                manager.transactionRestored(transaction);
                break;
            case Deferred:
                manager.transactionDeferred(transaction);
                break;
            default:
                break;
            }
        }
    }

    @Override
    public void restoreCompletedTransactionsFinished(SKPaymentQueue queue) {
        manager.restoreCompleted(queue);
    }

    @Override
    public void restoreCompletedTransactionsFailed(SKPaymentQueue queue, NSError error) {
        manager.restoreFailed(queue, error);
    }

}
