package za.ac.cput.linkup.factory;

/* MessageFactory Test.java
Author: Brezano Liebenberg (230463886)
Date:9 May 2025
*/

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.linkup.domain.message.Message;
import za.ac.cput.linkup.domain.message.MessageStatus;
import za.ac.cput.linkup.domain.message.MessageType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MessageFactoryTest {
    public static Message message1 = MessageFactory.createMessage( 1002345678L, 2003456789L,2003456789L
            ,3004567890L,1002345678L,"Hi, are we still on for the meeting tomorrow?",
            LocalDateTime.now(),true,false, MessageStatus.DELIVERED
            ,"https://event.com/uploads/image98765.png", MessageType.IMAGE);

    @Test
    @Order(1)
    public void createMessage(){
        assertNotNull(message1);
        System.out.println(message1.toString());
    }

    @Test
    @Order(2)
    public void createMessageToFail(){
        fail();

        assertNotNull(message1);
        System.out.println(message1.toString());
    }
}