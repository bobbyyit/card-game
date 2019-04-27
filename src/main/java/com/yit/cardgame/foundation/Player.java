package com.yit.cardgame.foundation;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String id;
    private List<Card> cards;

    public Player(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void addCards(List<Card> cards) {
        if (cards == null) {
            cards = new ArrayList<>();
        }

        cards.addAll(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
