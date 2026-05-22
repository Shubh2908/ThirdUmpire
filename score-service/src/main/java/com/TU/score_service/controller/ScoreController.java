package com.TU.score_service.controller;

import com.TU.score_service.dto.ScoreRequestDTO;
import com.TU.score_service.dto.ScoreResponseDTO;
import com.TU.score_service.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService service;

    public ScoreController(ScoreService service) {
        this.service = service;
    }

    @PostMapping("/update")
    public ScoreResponseDTO updateScore(
            @Valid @RequestBody ScoreRequestDTO dto) {

        return service.updateScore(dto);
    }

    @GetMapping("/{matchId}")
    public ScoreResponseDTO getScore(
            @PathVariable Long matchId) {

        return service.getScore(matchId);
    }
}
