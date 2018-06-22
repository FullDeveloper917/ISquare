package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.SingleChatListAdapter;

/**
 * Created by David on 10/12/2017.
 */

public class ChatLocationContent implements ChatContent {
    private boolean sending;

    public boolean isSending() {
        return sending;
    }

    public void setSending(boolean sending) {
        this.sending = sending;
    }

    public ChatLocationContent(boolean sending) {
        this.sending = sending;
    }

    @Override
    public int getViewType() {
        return SingleChatListAdapter.RowType.LOCATION.ordinal();
    }
}
