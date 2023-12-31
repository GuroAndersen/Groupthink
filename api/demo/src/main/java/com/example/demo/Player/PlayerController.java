package com.example.demo.Player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.GameRoom.GameRoomController.PlayerMapper;

@CrossOrigin(origins = "http://localhost:3000") // React default port
@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/getPlayers")
    public ResponseEntity<List<PlayersDTO>> getPlayers() {
        List<Player> players = playerService.getPlayers();
        List<PlayersDTO> playersDTOs = new ArrayList<>();
        for (Player player : players) {
            playersDTOs.add(PlayerMapper.convertToDTO(player));
        }
        return ResponseEntity.ok(playersDTOs);
    }

    @PostMapping
    public ResponseEntity<Void> registerNewPlayer(@RequestBody Player player) {
        playerService.addNewPlayer(player);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("playerId") Long studentId) {
        playerService.deletePlayer(studentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{playerId}")
    public ResponseEntity<Void> updatePlayer(
            @PathVariable("playerId") Long playerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int score) {
        playerService.updatePlayer(playerId, name, score);
        return ResponseEntity.ok().build();
    }

}
