package com.TU.score_service.consumer;

import com.TU.score_service.event.MatchScoreEvent;
import com.TU.score_service.service.LiveScoreWebSocketService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ScoreConsumer {

    private final LiveScoreWebSocketService webSocketService;

    public ScoreConsumer(LiveScoreWebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @KafkaListener(
            topics = "match-score-topic",
            groupId = "score-group"
    )
    public void consume(MatchScoreEvent event) {

        System.out.println("LIVE SCORE RECEIVED");

        System.out.println("Match ID : " + event.getMatchId());
        System.out.println("Team : " + event.getTeam());
        System.out.println("Runs : " + event.getRuns());
        System.out.println("Wickets : " + event.getWickets());
        System.out.println("Overs : " + event.getOvers());

        // SEND TO WEBSOCKET
        webSocketService.sendLiveUpdate(event);
    }
}