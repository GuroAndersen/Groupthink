package com.example.demo.GameRoom;

import java.util.ArrayList;

import com.example.demo.Player.Player;

public class GameRoomDTO {
    private String code;
    private ArrayList<Player> players;

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

}