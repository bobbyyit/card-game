package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Card;
import com.yit.cardgame.foundation.Deck;

import java.util.Stack;

import static java.util.UUID.randomUUID;

public class DeckService {
    private static DeckService instance = null;

    private Deck deck;

    private DeckService() {
        deck = new Deck(randomUUID().toString());
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

    public void addDeckOfCards(Stack<Card> cardStack) {
        deck.setDeckOfCards(cardStack);
    }
}