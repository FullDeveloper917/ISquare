package com.example.david.isquare.Objects;

import com.example.david.isquare.Adapters.SingleChatListAdapter;

/**
 * Created by David on 10/12/2017.
 */

public class ChatTextContent implements ChatContent {
    private boolean sending;
    private String content;

    public boolean isSending() {
        return sending;
    }

    public void setSending(boolean sending) {
        this.sending = sending;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ChatTextContent(boolean sending) {
        this.sending = sending;
    }

    public ChatTextContent(boolean sending, String content) {
        this.sending = sending;
        this.content = content;
    }

    @Override
    public int getViewType() {
        return SingleChatListAdapter.RowType.TEXT.ordinal();
    }
}
