package com.yit.cardgame.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yit.cardgame.response.SimpleResponse;
import com.yit.cardgame.service.GameService;
import com.yit.cardgame.service.PlayerCreationService;
import org.junit.Before;
import org.junit.Test;
import ratpack.handling.Context;
import ratpack.http.Request;
import ratpack.http.Response;

import static com.yit.cardgame.service.GameService.createGame;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static ratpack.http.Status.OK;

public class AddPlayerHandlerTest {

    private AddPlayerHandler handler;
    private Context context = mock(Context.class);
    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    private Gson gson;

    @Before
    public void setUp() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        handler = new AddPlayerHandler(gson, new PlayerCreationService());
        when(context.getRequest()).thenReturn(request);
        when(context.getResponse()).thenReturn(response);
        createGame();
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

        verify(context).render(gson.toJson(new SimpleResponse(OK.getCode(), anyString())));
    }

//    @Test
    public void rendersErrorMessage() {
        GameService.deleteGame();

        handler.handle(context);

        verify(context).render(gson.toJson(new SimpleResponse(OK.getCode(), anyString())));
    }
}