package com.TU.score_service.service;

import com.TU.score_service.dto.ScoreUpdateDTO;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScoreUpdatePublisher {

    private final SimpMessagingTemplate messagingTemplate;

    public ScoreUpdatePublisher(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendLiveUpdate(ScoreUpdateDTO dto) {

        System.out.println("LIVE UPDATE SEND");

        messagingTemplate.convertAndSend(
                "/topic/match/" + dto.getMatchId(),
                dto
        );
    }
}