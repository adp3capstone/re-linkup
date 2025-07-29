package za.ac.cput.linkup.domain;
/*Chat.java
Chat model class
Author: Anita Lottering 222141395
Date:8th May 2025*/
import java.time.LocalDateTime;

public class Chat {
    private int chatId;
    private int fromUserAId;
    private int toUserBId;
    private int userMatchId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int lastMessageId;
    private String lastMessageContent;

    protected Chat() {

    }

    private Chat(Builder builder) {
        this.chatId = builder.chatId;
        this.fromUserAId = builder.fromUserAId;
        this.toUserBId = builder.toUserBId;
        this.userMatchId = builder.userMatchId;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.lastMessageId = builder.lastMessageId;
        this.lastMessageContent = builder.lastMessageContent;

    }

    public int getChatId() {
        return chatId;
    }

    public int getFromUserAId() {
        return fromUserAId;
    }

    public int getToUserBId() {
        return toUserBId;
    }

    public int getUserMatchId() {
        return userMatchId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public int getLastMessageId() {
        return lastMessageId;
    }

    public String getLastMessageContent() {
        return lastMessageContent;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "chatId=" + chatId +
                ", fromUserAId=" + fromUserAId +
                ", toUserBId=" + toUserBId +
                ", userMatchId=" + userMatchId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", lastMessageId=" + lastMessageId +
                ", lastMessageContent=" + lastMessageContent +
                '}';
    }

    public static class Builder {
        private int chatId;
        private int fromUserAId;
        private int toUserBId;
        private int userMatchId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private int lastMessageId;
        private String lastMessageContent;

        public Builder setToUserBId(int toUserBId) {
            this.toUserBId = toUserBId;
            return this;
        }

        public Builder setUserAId(int fromUserAId) {
            this.fromUserAId = fromUserAId;
            return this;
        }

        public Builder setChatId(int chatId) {
            this.chatId = chatId;
            return this;
        }

        public Builder setUserMatchId(int userMatchId) {
            this.userMatchId = userMatchId;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder setLastMessageId(int lastMessageId) {
            this.lastMessageId = lastMessageId;
            return this;
        }

        public Builder setLastMessageContent(String lastMessageContent) {
            this.lastMessageContent = lastMessageContent;
            return this;
        }

        public Builder copy(Chat chat) {
            this.chatId = chat.getChatId();
            this.fromUserAId = chat.getFromUserAId();
            this.toUserBId = chat.getToUserBId();
            this.userMatchId = chat.getUserMatchId();
            this.createdAt = chat.getCreatedAt();
            this.updatedAt = chat.getUpdatedAt();
            this.lastMessageId = chat.getLastMessageId();
            this.lastMessageContent = chat.getLastMessageContent();
            return this;
        }

        public Chat build() {
            return new Chat(this);

        }
    }

}

