package com.bugvm.bindings.inapppurchase;

import com.bugvm.apple.storekit.SKPaymentQueue;
import com.bugvm.apple.foundation.NSArray;
import com.bugvm.apple.foundation.NSError;
import com.bugvm.apple.storekit.SKPaymentTransaction;
import com.bugvm.apple.storekit.SKPaymentTransactionObserverAdapter;

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
