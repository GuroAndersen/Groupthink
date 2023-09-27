package com.example.demo.Player;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerByName = playerRepository.findPlayerByName(player.getName());

        if (playerByName.isPresent()) {
            throw new IllegalStateException("Name taken");
        }
        playerRepository.save(player);
    }

    public void deletePlayer(Long studentId) {
        boolean exists = playerRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("player with id" + studentId + "does not exist");
        }
        playerRepository.deleteById(studentId);
    }

    @Transactional
    public void updatePlayer(Long playerId, String name, int score) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("player with id" + playerId + " does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(player.getName(), name)) {
            player.setName(name);
        }
    }
}
