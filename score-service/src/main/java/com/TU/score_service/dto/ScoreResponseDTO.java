package com.TU.score_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreResponseDTO {

    private Long id;
    private Long matchId;
    private int runs;
    private int wickets;
    private float overs;
    private String battingTeam;
    private String bowlingTeam;

}
