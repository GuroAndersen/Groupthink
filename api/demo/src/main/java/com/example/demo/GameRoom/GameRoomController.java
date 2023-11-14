package com.example.demo.GameRoom;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Player.Player;
import com.example.demo.Player.PlayerService;
import com.example.demo.Player.PlayersDTO;

@CrossOrigin(origins = "http://localhost:3000") // React default port
@RestController
@RequestMapping(path = "api/v1/gameroom")
public class GameRoomController {

    private final GameRoomService gameRoomService;
    private final PlayerService playerService;

    @Autowired
    public GameRoomController(GameRoomService gameRoomService, PlayerService playerService) {
        this.gameRoomService = gameRoomService;
        this.playerService = playerService;
    }

    // Endpoint to create a new game room and return its code
    @PostMapping("/gameRoom")
    public ResponseEntity<GameRoomDTO> createGameRoom() {
        GameRoom gameRoom = gameRoomService.createGameRoom();
        GameRoomDTO dto = new GameRoomDTO();
        dto.setCode(gameRoom.getCode());
        return ResponseEntity.ok(dto);
    }

    public class GameRoomMapper {
        public static GameRoomDTO convertToDTO(GameRoom gameRoom) {
            GameRoomDTO dto = new GameRoomDTO(gameRoom.getCode());
            ArrayList<PlayersDTO> playersDTOs = new ArrayList<>();
            for (Player player : gameRoom.getPlayers()) {
                playersDTOs.add(PlayerMapper.convertToDTO(player));
            }
            dto.setPlayers(playersDTOs);
            return dto;
        }
    }

    public class PlayerMapper {
        public static PlayersDTO convertToDTO(Player player) {
            PlayersDTO dto = new PlayersDTO(player.getId(), player.getName(), player.getScore(), player.getAnswer());
            return dto;
        }
    }

    // Endpoint for players to join game via game code
    @PostMapping("/join")
    public ResponseEntity<?> joinGameRoom(@RequestBody JoinRequest joinRequest) {

        GameRoom gameRoom = gameRoomService.findByCode(joinRequest.getCode());
        if (gameRoom == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game room not found");
        }

        // Check if a player with the same name already exists in the game room
        boolean isNameTaken = gameRoom.getPlayers().stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(joinRequest.getPlayerDetails().getPlayerName()));

        if ((isNameTaken)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Name taken");
        }
        try {
            Player player = new Player(joinRequest.getPlayerDetails().getPlayerName(), 0, null);
            playerService.addNewPlayer(player);
            gameRoom = gameRoomService.addPlayerToGameRoom(gameRoom.getId(), player);
            GameRoomDTO dto = GameRoomMapper.convertToDTO(gameRoom);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/gameRoom/code/{code}")
    public ResponseEntity<GameRoomDTO> getGameRoomByCode(@PathVariable String code) {
        GameRoom gameRoom = gameRoomService.findByCode(code);
        if (gameRoom == null) {
            return ResponseEntity.notFound().build();
        }
        // Add any other necessary details to the DTO
        return ResponseEntity.ok(GameRoomMapper.convertToDTO(gameRoom));
    }

    @GetMapping("/gameRoom/id/{id}")
    public ResponseEntity<GameRoomDTO> getGameRoomById(@PathVariable Long id) {
        GameRoom gameRoom = gameRoomService.findById(id);
        if (gameRoom == null) {
            return ResponseEntity.notFound().build();
        }
        // Add any other necessary details to the DTO
        return ResponseEntity.ok(GameRoomMapper.convertToDTO(gameRoom));
    }
}
