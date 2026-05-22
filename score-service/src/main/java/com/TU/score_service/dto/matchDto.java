package com.TU.score_service.dto;

import lombok.Data;

@Data
public class matchDto {

    private Long id;

    private String teamA;

    private String teamB;

    private String venue;

    private String status;
}
