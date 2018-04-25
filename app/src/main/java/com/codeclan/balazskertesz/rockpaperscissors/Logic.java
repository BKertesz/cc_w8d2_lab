package com.codeclan.balazskertesz.rockpaperscissors;

public enum Logic {

    //Enum that stores the hands and their opposites

    ROCK("Scissors","Rock"),
    PAPER("Rock","Paper"),
    SCISSORS("Paper","Scissors");

    private String value;
    private String name;

    Logic(String value,String name){
        this.value = value;
        // Value is the one that beats the hand
        this.name = name;
    }

    public String getValue(){
        return this.value;
        // Get the winner for the given hand
    }

    public String getName() {
        return name;
    }
}
