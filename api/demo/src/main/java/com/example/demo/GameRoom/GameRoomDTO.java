package com.example.demo.GameRoom;

import java.util.ArrayList;

import com.example.demo.Player.PlayersDTO;

public class GameRoomDTO {
    private String code;
    private ArrayList<PlayersDTO> players = new ArrayList<>();

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

    public void setPlayers(ArrayList<PlayersDTO> players) {
        this.players = players;
    }

    public ArrayList<PlayersDTO> getPlayers() {
        return this.players;
    }
}