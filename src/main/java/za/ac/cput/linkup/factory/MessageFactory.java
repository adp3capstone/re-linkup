package za.ac.cput.linkup.factory;
/* MessageFactory.java
Author: Brezano Liebenberg (230463886)
Date:9 May 2025
*/

import za.ac.cput.linkup.domain.message.Message;
import za.ac.cput.linkup.domain.message.MessageStatus;
import za.ac.cput.linkup.domain.message.MessageType;
import za.ac.cput.linkup.util.Helper;

import java.time.LocalDateTime;

public class MessageFactory {
    public static Message createMessage(long messageId, long senderId, long receiverId, long conversationId,
     long replyToMessageId, String message, LocalDateTime timestamp, boolean isRead, boolean isDeleted,
     MessageStatus status, String attachmentUrl, MessageType messageType){
        if(!Helper.isValidLong(messageId) || !Helper.isValidLong(senderId) || !Helper.isValidLong(receiverId) ||
        !Helper.isValidLong(conversationId) || !Helper.isValidLong(replyToMessageId) || Helper.isStringNullOrEmpty(message) ||
        Helper.isDateNull(timestamp) || !Helper.isTrue(isRead) || Helper.isTrue(isDeleted) || Helper.isObjectNull(status) ||
        Helper.isStringNullOrEmpty(attachmentUrl) || Helper.isObjectNull(messageType)){
            return null;
        }

        return new Message.Builder()
                .setMessageId(messageId)
                .setSenderId(senderId)
                .setReceiverId(receiverId)
                .setConversationId(conversationId)
                .setReplyToMessageId(replyToMessageId)
                .setMessage(message)
                .setTimestamp(timestamp)
                .setRead(isRead)
                .setDeleted(isDeleted)
                .setStatus(status)
                .setAttachmentUrl(attachmentUrl)
                .setMessageType(messageType)
                .build();
    }
}
