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

    public Player getPlayer(String playerId) {
        return players.stream()
                .filter(player -> playerId.equals(player.getId()))
                .findFirst()
                .orElse(null);
    }

    public List<Player> listPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }
}
