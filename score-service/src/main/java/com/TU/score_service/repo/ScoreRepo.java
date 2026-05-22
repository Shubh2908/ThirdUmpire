package com.TU.score_service.repo;

import com.TU.score_service.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepo extends JpaRepository<Score, Long> {

    Score findByMatchId(Long matchId);

}
