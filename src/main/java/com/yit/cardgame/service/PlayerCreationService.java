package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Player;

import static java.util.UUID.randomUUID;

public class PlayerCreationService {

    public Player createNewPlayer() {
        return new Player(randomUUID().toString());
    }
}
