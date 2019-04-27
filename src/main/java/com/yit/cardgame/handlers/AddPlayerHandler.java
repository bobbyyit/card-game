package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.foundation.Player;
import com.yit.cardgame.response.SimpleResponse;
import com.yit.cardgame.service.GameService;
import com.yit.cardgame.service.PlayerCreationService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static com.yit.cardgame.service.GameService.isGameCreated;
import static java.lang.String.format;
import static ratpack.http.Status.OK;

public class AddPlayerHandler implements Handler {
    private Gson gson;
    private PlayerCreationService playerCreationService;

    public AddPlayerHandler(Gson gson, PlayerCreationService playerCreationService) {
        this.gson = gson;
        this.playerCreationService = playerCreationService;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");
        if (isGameCreated()) {
            Player newPlayer = playerCreationService.createNewPlayer();
            GameService.getGame().addPlayer(newPlayer);

            ctx.getResponse().status(OK);
            ctx.render(gson.toJson(new SimpleResponse(OK.getCode(), format("Player %s has been added to the game.", newPlayer.getId()))));
        } else {
            ctx.getResponse().status(400);
            ctx.render(gson.toJson(new SimpleResponse(400, "Game has not been created, please create a game and try again.")));
        }
    }
}
