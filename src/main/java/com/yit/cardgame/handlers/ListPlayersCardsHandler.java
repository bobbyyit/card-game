package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.foundation.Player;
import com.yit.cardgame.response.PlayersResponse;
import com.yit.cardgame.service.GameService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.List;

import static ratpack.http.Status.OK;

public class ListPlayersCardsHandler implements Handler {
    private Gson gson;

    public ListPlayersCardsHandler(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");
        List<Player> players = GameService.getGame().listPlayers();
        ctx.getResponse().status(OK);
        ctx.render(gson.toJson(new PlayersResponse(OK.getCode(), players)));
    }
}
