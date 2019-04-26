package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Deck;

public class DeckService {
    private static DeckService instance = null;

    private Deck deck;

    private DeckService() {
        deck = new Deck(2134);
    }

    public static DeckService createDeck(){
        if (instance == null) {
            instance = new DeckService();
        }

        return instance;
    }

    public Deck getDeck() {
        return deck;
    }
}