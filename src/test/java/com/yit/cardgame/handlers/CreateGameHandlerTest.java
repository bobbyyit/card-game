package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yit.cardgame.response.SimpleResponse;
import org.junit.Before;
import org.junit.Test;
import ratpack.handling.Context;
import ratpack.http.Request;
import ratpack.http.Response;

import static org.mockito.Mockito.*;
import static ratpack.http.Status.OK;

public class CreateGameHandlerTest {
    private CreateGameHandler handler;
    private Context context = mock(Context.class);
    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    private Gson gson;

    @Before
    public void setUp() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        handler = new CreateGameHandler(gson);
        when(context.getRequest()).thenReturn(request);
        when(context.getResponse()).thenReturn(response);
    }

    @Test
    public void returnJsonContentType() {
        handler.handle(context);

        verify(context).header("content-type", "application/json");
    }

    @Test
    public void returnsOk() {
        handler.handle(context);

        verify(response).status(OK);
    }

    @Test
    public void rendersMessage() {
        handler.handle(context);

        verify(context).render(gson.toJson(new SimpleResponse(OK.getCode(), "Game has been created.")));
    }
//    @Test
//    public void createGame() {
//        PowerMockito.mockStatic(GameService.class);
//
//        handler.handle(context);
//
//        PowerMockito.verifyStatic(GameService.class);
//
//    }
}