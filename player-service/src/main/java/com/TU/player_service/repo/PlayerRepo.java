package com.TU.player_service.repo;

import com.TU.player_service.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Long> {

    List<Player> findByTeam(String team);

}
