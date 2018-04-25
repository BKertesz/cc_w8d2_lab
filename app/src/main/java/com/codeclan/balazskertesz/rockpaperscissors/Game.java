package com.codeclan.balazskertesz.rockpaperscissors;

import java.util.Random;

public class Game {

    private String player;
    private String computer;
    private int wins;
    private int lose;
    private int draws;

    public Game() {
        this.player = "";
        this.computer = "";
        wins = 0;
        lose = 0;
        draws = 0;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getWins() {
        return wins;
    }

    public int getLose() {
        return lose;
    }

    public int getDraws() {
        return draws;
    }

    public String getPlayer() {
        return player;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void randomComputerHand() {
        Random rand = new Random();
        int number = rand.nextInt(Logic.values().length);
        computer = Logic.values()[number].getValue();
    }

    public String compareHands() {
        if (Logic.valueOf(player.toUpperCase()).getValue() == computer) {
            wins ++;
            return "Player wins!";
        } else if (player.equals(computer)) {
            draws ++;
            return "It's a draw!";
        } else {
            lose ++;
            return "Computer wins!";
        }
    }

    public String handsPlayedText(){
        return "You played: "+player+"\n"+"AI played: "+computer+"\n"+compareHands();
    }

    public String displayScore(){
        return "Score: W: "+wins+" L: "+lose+" D:"+draws;
    }
}
