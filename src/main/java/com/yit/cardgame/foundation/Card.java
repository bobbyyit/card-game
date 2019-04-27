package com.yit.cardgame.foundation;

public class Card {
    private final int id;
    private final int value;
    private final String suit;
    private final String niceName;

    public Card(int id, int value, String suit, String niceName) {
        this.id = id;
        this.value = value;
        this.suit = suit;
        this.niceName = niceName;
    }

    public int getId() {
        return id;
    }
}
