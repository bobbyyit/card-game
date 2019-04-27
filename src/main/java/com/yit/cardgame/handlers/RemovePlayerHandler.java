package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.yit.cardgame.response.CreateResponse;
import com.yit.cardgame.service.GameService;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.util.MultiValueMap;

import java.util.Map;

import static java.lang.String.format;
import static ratpack.http.Status.OK;

public class RemovePlayerHandler implements Handler {
    private Gson gson;

    public RemovePlayerHandler(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void handle(Context ctx) {
        ctx.header("content-type", "application/json");
        MultiValueMap<String, String> parameters = ctx.getRequest().getQueryParams();
        if (isValidFormat(parameters)) {
            String playerId = parameters.get("player-id");
            GameService.getGame().removePlayer(playerId);

            ctx.getResponse().status(OK);
            ctx.render(gson.toJson(new CreateResponse(OK.getCode(), format("Player %s has been removed from the game.", playerId))));
        } else {
            ctx.getResponse().status(400);
            ctx.render(gson.toJson(new CreateResponse(400, "Bad Parameters.")));
        }
    }
    private boolean isValidFormat(Map<String, String> parameters) {
        return parameters.containsKey("player-id");
    }

}
