package com.yit.cardgame.foundation;

import java.util.Stack;

public class Deck {
    private String id;
    private Stack<Card> deckOfCards;


    public Deck(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDeckOfCards(Stack<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public Stack<Card> getDeckOfCards() {
        return deckOfCards;
    }
}
