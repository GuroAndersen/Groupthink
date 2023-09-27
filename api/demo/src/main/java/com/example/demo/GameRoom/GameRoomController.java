package com.example.demo.GameRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Player.Player;

@CrossOrigin(origins = "http://localhost:3000") // React default port
@RestController
@RequestMapping(path = "api/v1/gameroom")
public class GameRoomController {

    private final GameRoomService gameRoomService;

    @Autowired
    public GameRoomController(GameRoomService gameRoomService) {
        this.gameRoomService = gameRoomService;
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
            GameRoomDTO dto = new GameRoomDTO();
            dto.setCode(gameRoom.getCode());
            return dto;
        }
    }

    // Endpoint for players to join game via game code
    @PostMapping("/join")
    public ResponseEntity<?> joinGameRoom(@RequestBody JoinRequest JoinRequest) {
        try {
            GameRoom gameRoom = gameRoomService.addPlayerToGameRoom(null, null);
            GameRoomDTO dto = GameRoomMapper.convertToDTO(gameRoom);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/gameRoom/code/{code}")
    public ResponseEntity<GameRoomDTO> getGameRoomByCode(@PathVariable String code) {
        GameRoom gameRoom = gameRoomService.findByCode(code);
        if (gameRoom == null) {
            return ResponseEntity.notFound().build();
        }
        GameRoomDTO dto = new GameRoomDTO();
        dto.setCode(gameRoom.getCode());
        // Add any other necessary details to the DTO
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/gameRoom/id/{id}")
    public ResponseEntity<GameRoomDTO> getGameRoomById(@PathVariable Long id) {
        GameRoom gameRoom = gameRoomService.findById(id);
        if (gameRoom == null) {
            return ResponseEntity.notFound().build();
        }
        GameRoomDTO dto = new GameRoomDTO();
        dto.setCode(gameRoom.getCode());
        // Add any other necessary details to the DTO
        return ResponseEntity.ok(dto);
    }
}
