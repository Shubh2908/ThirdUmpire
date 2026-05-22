package com.TU.match_service.service;

import com.TU.match_service.entity.Match;
import com.TU.match_service.repo.MatchRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepo repository;

    public MatchService(MatchRepo repository) {
        this.repository = repository;
    }

    public Match createMatch(Match match) {
        return repository.save(match);
    }

    public List<Match> getAllMatches() {
        return repository.findAll();
    }

    public Match getMatch(Long id) {
        return repository.findById(id).orElse(null);
    }

}
