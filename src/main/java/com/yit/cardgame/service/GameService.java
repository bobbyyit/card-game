package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Game;

public class GameService {
    private static GameService instance = null;

    private Game game;

    private GameService() {
        game = new Game();
    }

    public static GameService createGame(){
        if (instance == null) {
            instance = new GameService();
        }

        return instance;
    }

    public static GameService deleteGame() {
        instance = null;
        return instance;
    }


    public Game getGame() {
        return game;
    }
}