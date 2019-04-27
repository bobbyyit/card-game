package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.foundation.Card;
import com.yit.cardgame.foundation.Deck;
import com.yit.cardgame.response.SimpleResponse;
import com.yit.cardgame.service.Dealer;
import com.yit.cardgame.service.GameService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.util.Map;
import java.util.Stack;

import static ratpack.http.Status.OK;

public class ShuffleDeckHandler implements Handler {
    private Gson gson;
    private Dealer dealer;

    public ShuffleDeckHandler(Gson gson, Dealer dealer) {
        this.gson = gson;
        this.dealer = dealer;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");

        Deck deck = GameService.getGame().getDeck();
        Stack<Card> stack = dealer.shuffleCards(deck.getDeckOfCards());
        deck.setDeckOfCards(stack);

        GameService.getGame().setDeck(deck);

        ctx.getResponse().status(OK);
        ctx.render(gson.toJson(new SimpleResponse(OK.getCode(), "Deck has been shuffled.")));
    }

    private boolean isValidFormat(Map<String, String> parameters) {
        return parameters.containsKey("deck-id");
    }
}
