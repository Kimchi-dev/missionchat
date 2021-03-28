package me.chatapp.missionchat.consumer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chatapp.missionchat.constants.KafkaConstants;
import me.chatapp.missionchat.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Message message){
        log.info("sending via kafka listener..");
        template.convertAndSend("/topic/group",message);
    }
}
