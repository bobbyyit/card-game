package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.foundation.Card;
import com.yit.cardgame.response.SimpleResponse;
import com.yit.cardgame.service.Dealer;
import com.yit.cardgame.service.DeckService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.Stack;

import static ratpack.http.Status.OK;

public class DeckHandler implements Handler {
    private Gson gson;
    private Dealer dealer;

    public DeckHandler(Gson gson, Dealer dealer) {
        this.gson = gson;
        this.dealer = dealer;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");
        DeckService deck = DeckService.getOrCreateDeck();
        Stack<Card> stack = dealer.shuffleCards(dealer.prepareToDeal(dealer.createDeckOfCards()));
        deck.getDeck().setDeckOfCards(stack);
        if (deck != null) {
            ctx.getResponse().status(OK);
            ctx.render(gson.toJson(new SimpleResponse(deck.getDeck().getId(), OK.getCode(), "Deck has been created.")));
        } else {
            ctx.getResponse().status(400);
            ctx.render(gson.toJson(new SimpleResponse(400, "Could not create deck.")));
        }
    }
}
