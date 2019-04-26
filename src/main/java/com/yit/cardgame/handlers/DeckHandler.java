package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.response.CreateResponse;
import com.yit.cardgame.service.DeckService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.http.Status.OK;

public class DeckHandler implements Handler {
    private Gson gson;

    public DeckHandler(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");
        DeckService deck = DeckService.getOrCreateDeck();
        if (deck != null) {
            ctx.getResponse().status(OK);
            ctx.render(gson.toJson(new CreateResponse(deck.getDeck().getId(), OK.getCode(), "Deck has been created.")));
        } else {
            ctx.getResponse().status(400);
            ctx.render(gson.toJson(new CreateResponse(400, "Could not create deck.")));
        }
    }
}
