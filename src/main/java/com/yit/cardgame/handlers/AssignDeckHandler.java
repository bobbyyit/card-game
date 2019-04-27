package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.foundation.Deck;
import com.yit.cardgame.response.SimpleResponse;
import com.yit.cardgame.service.Dealer;
import com.yit.cardgame.service.DeckService;
import com.yit.cardgame.service.GameService;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.util.MultiValueMap;

import java.util.Map;

import static com.yit.cardgame.service.DeckService.getOrCreateDeck;
import static ratpack.http.Status.OK;

public class AssignDeckHandler implements Handler {
    private Gson gson;
    private Dealer dealer;

    public AssignDeckHandler(Gson gson, Dealer dealer) {
        this.gson = gson;
        this.dealer = dealer;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");
        MultiValueMap<String, String> parameters = ctx.getRequest().getQueryParams();
        if (isValidFormat(parameters)) {

            Deck deck = getOrCreateDeck().getDeck();
            DeckService.addDeckOfCards(dealer.shuffleCards(dealer.prepareToDeal(dealer.createDeckOfCards())));

            if (deck.getId().equals(parameters.get("deck-id"))) {
                GameService.getGame().setDeck(deck);
                ctx.getResponse().status(OK);
                ctx.render(gson.toJson(new SimpleResponse(OK.getCode(), "Deck has been assigned to the game.")));
            } else {
                ctx.getResponse().status(400);
                ctx.render(gson.toJson(new SimpleResponse(400, "Bad Parameter, cannot find deck.")));
            }
        } else {
            ctx.getResponse().status(400);
            ctx.render(gson.toJson(new SimpleResponse(400, "Bad Parameter, missing deck-id.")));
        }
    }

    private boolean isValidFormat(Map<String, String> parameters) {
        return parameters.containsKey("deck-id");
    }
}
