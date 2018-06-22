package com.example.david.isquare.Objects;

/**
 * Created by David on 10/12/2017.
 */

public class Withdrawal {
    private boolean processed;

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Withdrawal(boolean processed) {
        this.processed = processed;
    }
}
