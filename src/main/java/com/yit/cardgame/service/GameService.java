package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Game;

public class GameService {
    private static GameService single_instance = null;

    private Game game;

    private GameService() {
        game = new Game();
    }

    public static GameService createInstance()
    {
        if (single_instance == null)
            single_instance = new GameService();

        return single_instance;
    }


    public Game getGame() {
        return game;
    }
}