package com.TU.match_service.controller;

import com.TU.match_service.entity.Match;
import com.TU.match_service.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Match createMatch(@RequestBody Match match) {
        return service.createMatch(match);
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return service.getAllMatches();
    }

    @GetMapping("/{id}")
    public Match getMatch(@PathVariable Long id) {
        return service.getMatch(id);
    }

}
