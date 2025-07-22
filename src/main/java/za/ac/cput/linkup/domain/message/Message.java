package za.ac.cput.linkup.domain.message;

/* Message.java
Message class
Author: Brezano Liebenberg (230463886)
Date:9 May 2025
*/

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Message {

    @Id
    private long messageId;
    private long senderId;
    private long receiverId;
    private long conversationId;
    private long replyToMessageId;
    private String message;
    private LocalDateTime timestamp;
    private boolean isRead;
    private boolean isDeleted;
    private MessageStatus status;
    private String attachmentUrl;
    private MessageType messageType;

    protected Message(){}

    private Message(Builder builder) {
        this.messageId = builder.messageId;
        this.senderId = builder.senderId;
        this.receiverId = builder.receiverId;
        this.conversationId = builder.conversationId;
        this.replyToMessageId = builder.replyToMessageId;
        this.message = builder.message;
        this.timestamp = builder.timestamp;
        this.isRead = builder.isRead;
        this.isDeleted = builder.isDeleted;
        this.status = builder.status;
        this.attachmentUrl = builder.attachmentUrl;
        this.messageType = builder.messageType;
    }

    public long getMessageId() {
        return messageId;
    }

    public long getSenderId() {
        return senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public long getConversationId() {
        return conversationId;
    }

    public long getReplyToMessageId() {
        return replyToMessageId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return isRead;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", conversationId=" + conversationId +
                ", replyToMessageId=" + replyToMessageId +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", isRead=" + isRead +
                ", isDeleted=" + isDeleted +
                ", status=" + status +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                ", messageType=" + messageType +
                '}';
    }

    public static class Builder{
        private long messageId;
        private long senderId;
        private long receiverId;
        private long conversationId;
        private long replyToMessageId;
        private String message;
        private LocalDateTime timestamp;
        private boolean isRead;
        private boolean isDeleted;
        private MessageStatus status;
        private String attachmentUrl;
        private MessageType messageType;

        public Builder setMessageId(long messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setSenderId(long senderId) {
            this.senderId = senderId;
            return this;
        }

        public Builder setReceiverId(long receiverId) {
            this.receiverId = receiverId;
            return this;
        }

        public Builder setConversationId(long conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        public Builder setReplyToMessageId(long replyToMessageId) {
            this.replyToMessageId = replyToMessageId;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setRead(boolean read) {
            isRead = read;
            return this;
        }

        public Builder setDeleted(boolean deleted) {
            isDeleted = deleted;
            return this;
        }

        public Builder setStatus(MessageStatus status) {
            this.status = status;
            return this;
        }

        public Builder setAttachmentUrl(String attachmentUrl) {
            this.attachmentUrl = attachmentUrl;
            return this;
        }

        public Builder setMessageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder copy(Message message) {
            this.messageId = message.getMessageId();
            this.senderId = message.getSenderId();
            this.receiverId = message.getReceiverId();
            this.conversationId = message.getConversationId();
            this.replyToMessageId = message.getReplyToMessageId();
            this.message = message.getMessage();
            this.timestamp = message.getTimestamp();
            this.isRead = message.isRead();
            this.isDeleted = message.isDeleted();
            this.status = message.getStatus();
            this.attachmentUrl = message.getAttachmentUrl();
            this.messageType = message.getMessageType();
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
