package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.foundation.Card;
import com.yit.cardgame.response.SimpleResponse;
import com.yit.cardgame.service.Dealer;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.util.MultiValueMap;

import java.util.List;
import java.util.Map;

import static com.yit.cardgame.service.GameService.getGame;
import static java.lang.Integer.parseInt;
import static ratpack.http.Status.OK;

public class DealerHandler implements Handler {
    private Gson gson;
    private Dealer dealer;

    public DealerHandler(Gson gson, Dealer dealer) {
        this.gson = gson;
        this.dealer = dealer;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");
        MultiValueMap<String, String> parameters = ctx.getRequest().getQueryParams();
        if (isValidFormat(parameters)) {
            String playerId = parameters.get("player-id");

            int quantity = parseInt(parameters.get("quantity"));
            List<Card> cards = dealer.dealCards(getGame().getDeck().getDeckOfCards(), quantity);

            getGame().getPlayer(playerId).addCards(cards);

            ctx.getResponse().status(OK);
            ctx.render(gson.toJson(new SimpleResponse(OK.getCode(), String.format("Cards dealt to player %s.", quantity))));


        } else {
            ctx.getResponse().status(400);
            ctx.render(gson.toJson(new SimpleResponse(400, "Bad Parameter, missing player-id/quantity.")));
        }
    }

    private boolean isValidFormat(Map<String, String> parameters) {
        return parameters.containsKey("player-id")
                && parameters.containsKey("quantity");
    }
}
