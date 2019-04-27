package com.yit.cardgame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yit.cardgame.handlers.*;
import com.yit.cardgame.service.Dealer;
import com.yit.cardgame.service.PlayerCreationService;
import ratpack.server.ServerConfig;

import static java.net.InetAddress.getByName;
import static ratpack.server.BaseDir.find;
import static ratpack.server.RatpackServer.start;

public class CardGame {
    public static void main(String[] args) throws Exception {
        start(spec -> spec
                .serverConfig(ServerConfig.embedded().port(8888)
                        .address(getByName("0.0.0.0"))
                        .baseDir(find()))
                .handlers(chain -> {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    Dealer dealer = new Dealer();
                    chain
                            .get("", ctx -> {
                                ctx.render("You're up and running");
                            })
                            .get("game/create", new CreateGameHandler(gson))
                            .get("game/delete", new DeleteGameHandler(gson))
                            .get("game/player/add", new AddPlayerHandler(gson, new PlayerCreationService()))
                            .get("game/player/remove", new RemovePlayerHandler(gson))
                            .get("game/players", new ListPlayersHandler(gson))
                            .get("deck/create", new DeckHandler(gson))
                            .get("deck/assign", new AssignDeckHandler(gson, new Dealer()))
                            .get("deck/shuffle", new ShuffleDeckHandler(gson, new Dealer()))
                            .get("deal/", new DealerHandler(gson, dealer))
                    ;
                })
        );
    }
}
