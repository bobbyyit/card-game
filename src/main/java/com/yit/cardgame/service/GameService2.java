package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Game;

public class GameService2 {
    private static GameService2 single_instance = null;

    private Game game;

    private GameService2() {
        game = new Game();
    }

    // static method to create instance of GameService2 class
    public static GameService2 createInstance()
    {
        if (single_instance == null)
            single_instance = new GameService2();

        return single_instance;
    }


    public Game getGame() {
        return game;
    }
}