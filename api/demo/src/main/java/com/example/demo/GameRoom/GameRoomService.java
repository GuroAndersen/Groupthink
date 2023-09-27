package com.example.demo.GameRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Code.CodeGenerator;
import com.example.demo.Player.Player;

@Service
public class GameRoomService {

    @Autowired
    private GameRoomRepository gameRoomRepository;

    // Method to create a new game room with a unique code
    public GameRoom createGameRoom() {
        String uniqueCode = CodeGenerator.generateCode();
        List<Player> playersList = new ArrayList<>();
        GameRoom gameRoom = new GameRoom(uniqueCode, playersList);
        gameRoom.setCode(CodeGenerator.generateCode());
        gameRoom = gameRoomRepository.save(gameRoom); // After this line, gameRoom's ID is populated
        return gameRoom;
    }

    // Method to find a game room by its unique code
    public GameRoom findByCode(String code) {
        return gameRoomRepository.findByCode(code).orElse(null);
    }

    public GameRoom findById(Long id) {
        return gameRoomRepository.findById(id).orElse(null);
    }

    public GameRoom addPlayerToGameRoom(Long gameRoomId, Player player) {
        GameRoom gameRoom = gameRoomRepository.findById(gameRoomId)
                .orElseThrow(() -> new IllegalStateException("Game room with id " + gameRoomId + "not found!"));

        player.setGameRoom(gameRoom);

        gameRoom.getPlayers().add(player);

        return gameRoomRepository.save(gameRoom);
    }

    public GameRoom deletePlayerFromGameRoom(Long gameRoomId, Long playerId) {
        GameRoom gameRoom = gameRoomRepository.findById(gameRoomId)
                .orElseThrow(() -> new IllegalStateException("Game room with id " + gameRoomId + "not found!"));

        // Find the player to be removed
        Player playerToRemove = gameRoom.getPlayers().stream()
                .filter(player -> player.getId().equals(playerId))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalStateException("Player with id " + playerId + " not found in the game room"));

        gameRoom.getPlayers().remove(playerToRemove);

        playerToRemove.setGameRoom(null);

        return gameRoomRepository.save(gameRoom);
    }
}
