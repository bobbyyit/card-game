package com.yit.cardgame.response;

import com.yit.cardgame.foundation.Player;

import java.util.List;

public class PlayersResponse {
    private int code;
    private List<Player> players;

    public PlayersResponse(int code, List<Player> players) {
        this.code = code;
        this.players = players;
    }
}
