package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Deck;

import java.util.UUID;

public class DeckService {
    private static DeckService instance = null;

    private Deck deck;

    private DeckService() {
        deck = new Deck(UUID.randomUUID().toString());
    }

    public static DeckService getOrCreateDeck(){
        if (instance == null) {
            instance = new DeckService();
        }

        return instance;
    }

    public Deck getDeck() {
        return deck;
    }
}