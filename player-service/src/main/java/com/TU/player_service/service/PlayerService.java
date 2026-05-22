package com.TU.player_service.service;

import com.TU.player_service.entity.Player;
import com.TU.player_service.repo.PlayerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepo repository;

    public PlayerService(PlayerRepo repository) {
        this.repository = repository;
    }

    public Player addPlayer(Player player) {
        return repository.save(player);
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }

    public Player getPlayer(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Player> getPlayersByTeam(String team) {
        return repository.findByTeam(team);
    }

}
