package com.TU.score_service.service;

import com.TU.score_service.event.MatchScoreEvent;
import com.TU.score_service.kafka.ScoreProducer;
import com.TU.score_service.dto.*;
import com.TU.score_service.entity.Score;
import com.TU.score_service.exception.ResourceNotFoundException;
import com.TU.score_service.feign.MatchClient;
import com.TU.score_service.repo.ScoreRepo;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private final ScoreRepo repository;
    private final MatchClient matchClient;
    private final ScoreUpdatePublisher publisher;
    private final ScoreProducer scoreProducer;

    public ScoreService(ScoreRepo repository,
                        MatchClient matchClient, ScoreUpdatePublisher publisher, ScoreProducer scoreProducer) {
        this.repository = repository;
        this.matchClient = matchClient;
        this.publisher = publisher;
        this.scoreProducer = scoreProducer;
    }

    public ScoreResponseDTO updateScore(ScoreRequestDTO dto) {

        matchDto match = matchClient.getMatchById(dto.getMatchId());

        if (match == null) {
            throw new ResourceNotFoundException("Match not found");
        }

        Score score = new Score();

        score.setMatchId(dto.getMatchId());
        score.setRuns(dto.getRuns());
        score.setWickets(dto.getWickets());
        score.setOvers(dto.getOvers());
        score.setBattingTeam(dto.getBattingTeam());
        score.setBowlingTeam(dto.getBowlingTeam());

        Score saved = repository.save(score);

        MatchScoreEvent event = new MatchScoreEvent(
                saved.getMatchId(),
                saved.getBattingTeam(),
                saved.getRuns(),
                saved.getWickets(),
                saved.getOvers()
        );


        ScoreUpdateDTO updateDTO = new ScoreUpdateDTO(
                saved.getMatchId(),
                saved.getRuns(),
                saved.getWickets(),
                saved.getOvers()
        );

        publisher.sendLiveUpdate(updateDTO);

        return new ScoreResponseDTO(
                saved.getId(),
                saved.getMatchId(),
                saved.getRuns(),
                saved.getWickets(),
                saved.getOvers(),
                saved.getBattingTeam(),
                saved.getBowlingTeam()
        );
    }

    public ScoreResponseDTO getScore(Long matchId) {

        Score score = repository.findByMatchId(matchId);

        if (score == null) {
            throw new ResourceNotFoundException("Score not found");
        }

        return new ScoreResponseDTO(
                score.getId(),
                score.getMatchId(),
                score.getRuns(),
                score.getWickets(),
                score.getOvers(),
                score.getBattingTeam(),
                score.getBowlingTeam()
        );
    }
}
