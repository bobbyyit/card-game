package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.response.CreateResponse;
import com.yit.cardgame.service.GameService2;
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

        if (GameService2.createInstance() != null) {
            ctx.getResponse().status(OK);
            ctx.render(gson.toJson(new CreateResponse(OK.getCode(), "Game has been created.")));
        } else {
            ctx.getResponse().status(400);
            ctx.render("fuck off");
        }
    }
}