package com.TU.score_service.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class LiveScoreWebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public LiveScoreWebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendLiveUpdate(Object score) {
        messagingTemplate.convertAndSend("/topic/live-score", score);
    }
}
