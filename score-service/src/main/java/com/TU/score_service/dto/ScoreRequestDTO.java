package com.TU.score_service.dto;

import lombok.Data;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class ScoreRequestDTO {

    @NotNull
    private Long matchId;

    @Min(0)
    private int runs;

    @Min(0)
    private int wickets;

    @DecimalMin("0.0")
    private float overs;

    @NotBlank
    private String battingTeam;

    @NotBlank
    private String bowlingTeam;

}
