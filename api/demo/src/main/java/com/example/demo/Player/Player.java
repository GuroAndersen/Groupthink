package com.example.demo.Player;

import com.example.demo.GameRoom.GameRoom;

import jakarta.persistence.*;

@Entity
@Table
public class Player {

    @Id
    @SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence", allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
    private Long id; // unique identifier for each player, could be generated or based on some input
    private String name; // player's name
    private int score; // player's score
    private String answer; // player's current answer

    @ManyToOne
    @JoinColumn(name = "game_room_id")
    private GameRoom gameRoom;

    public Player() {
    }

    public Player(Long id, String name, int score, String answer) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.answer = answer;
    }

    public Player(String name, int score, String answer) {

        this.name = name;
        this.score = score;
        this.answer = answer;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setGameRoom(GameRoom gameRoom) {
        this.gameRoom = gameRoom;
    }

    public GameRoom getGameRoom() {
        return gameRoom;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", score='" + getScore() + "'" +
                ", answer='" + getAnswer() + "'" +
                "}";
    }

}
