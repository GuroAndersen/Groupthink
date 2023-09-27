package com.example.demo.GameRoom;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Player.Player;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class GameRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameRoomId;
    private String code;

    @OneToMany(mappedBy = "gameRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    public GameRoom() {
    }

    public GameRoom(String code, List<Player> players) {

        this.code = code;
        this.players = players;
    }

    public GameRoom(Long id, String code, List<Player> players) {
        this.gameRoomId = id;
        this.code = code;
        this.players = players;
    }

    public Long getId() {
        return this.gameRoomId;
    }

    public void setId(Long id) {
        this.gameRoomId = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
