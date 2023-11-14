package com.example.demo.Player;

public class PlayersDTO {
    private Long id; // unique identifier for each player, could be generated or based on some input
    private String name; // player's name
    private int score; // player's score
    private String answer; // player's current answer

    public PlayersDTO() {
    }

    public PlayersDTO(Long id, String name, int score, String answer) {
        this.id = id;
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

}
