package com.yit.cardgame.foundation;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Deck deck;
    private List<Player> players;

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void addPlayer(Player player) {
        if (players == null) {
            players = new ArrayList<>();
        }

        players.add(player);
    }

    public void removePlayer(String playerId) {
        players.stream()
                .filter(player -> player.getId().equals(playerId))
                .findFirst()
                .ifPresent(player -> players.remove(player));
    }
}
