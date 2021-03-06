package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.response.SimpleResponse;
import com.yit.cardgame.service.GameService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.http.Status.OK;

public class CreateGameHandler implements Handler {
    private Gson gson;

    public CreateGameHandler(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");
        if (GameService.createGame() != null) {
            ctx.getResponse().status(OK);
            ctx.render(gson.toJson(new SimpleResponse(OK.getCode(), "Game has been created.")));
        } else {
            ctx.getResponse().status(400);
            ctx.render(gson.toJson(new SimpleResponse(400, "Could not create game.")));
        }
    }
}
