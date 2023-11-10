package com.example.demo.GameRoom;

import java.util.ArrayList;

import com.example.demo.Player.Player;

public class GameRoomDTO {
    private String code;
    private ArrayList<Player> players = new ArrayList<>();

    public GameRoomDTO() {
    }

    public GameRoomDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}