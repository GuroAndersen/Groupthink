package com.example.demo.GameRoom;

import com.example.demo.Player.PlayerDetails;

public class JoinRequest {
    private String code;
    private PlayerDetails playerDetails;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PlayerDetails getPlayerDetails() {
        return this.playerDetails;
    }

    public void setPlayerDetails(PlayerDetails playerDetails) {
        this.playerDetails = playerDetails;
    }

}
