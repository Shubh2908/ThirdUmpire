package com.TU.score_service.kafka;

import com.TU.score_service.event.MatchScoreEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScoreProducer {

    private final KafkaTemplate<String, MatchScoreEvent> kafkaTemplate;

    public ScoreProducer(KafkaTemplate<String, MatchScoreEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishScore(MatchScoreEvent event) {

        kafkaTemplate.send("match-score-topic", event);

        System.out.println("Score Event Published Successfully");
    }
}
