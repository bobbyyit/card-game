package com.yit.cardgame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yit.cardgame.handlers.CreateGameHandler;
import com.yit.cardgame.handlers.DeckHandler;
import com.yit.cardgame.handlers.DeleteGameHandler;
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
                    chain
                            .get("", ctx -> {
                                ctx.render("You're up and running");
                            })
                            .get("game/create", new CreateGameHandler(gson))
                            .get("game/delete", new DeleteGameHandler(gson))
                            .get("deck/create", new DeckHandler(gson))
                    ;
                })
        );
    }
}
