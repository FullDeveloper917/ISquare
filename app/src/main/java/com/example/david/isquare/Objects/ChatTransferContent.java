package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.SingleChatListAdapter;

/**
 * Created by David on 10/12/2017.
 */

public class ChatTransferContent implements ChatContent {
    private boolean sending;
    private boolean done;

    public boolean isSending() {
        return sending;
    }

    public void setSending(boolean sending) {
        this.sending = sending;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ChatTransferContent(boolean sending, boolean done) {
        this.sending = sending;
        this.done = done;
    }

    @Override
    public int getViewType() {
        return SingleChatListAdapter.RowType.TRANSFER.ordinal();
    }
}
