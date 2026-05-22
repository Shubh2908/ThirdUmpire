package com.TU.score_service.feign;

import com.TU.score_service.dto.matchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MATCH-SERVICE")
public interface MatchClient {

    @GetMapping("/matches/{id}")
    matchDto getMatchById(@PathVariable Long id);

}
