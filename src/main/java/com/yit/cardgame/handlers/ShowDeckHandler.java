package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.foundation.Card;
import com.yit.cardgame.foundation.Deck;
import com.yit.cardgame.service.Dealer;
import com.yit.cardgame.service.GameService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.List;

import static ratpack.http.Status.OK;

public class ShowDeckHandler implements Handler {
    private Gson gson;
    private Dealer dealer;

    public ShowDeckHandler(Gson gson, Dealer dealer) {
        this.gson = gson;
        this.dealer = dealer;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");

        Deck deck = GameService.getGame().getDeck();
        List<Card> cards = dealer.dealCards(deck.getDeckOfCards(), deck.getDeckOfCards().size());

        ctx.getResponse().status(OK);
        ctx.render(gson.toJson(cards));
    }
}
