package com.yit.cardgame.handlers;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yit.cardgame.response.CreateResponse;
import org.junit.Before;
import org.junit.Test;
import ratpack.handling.Context;
import ratpack.http.Request;
import ratpack.http.Response;
import ratpack.util.internal.ImmutableDelegatingMultiValueMap;

import static com.google.common.collect.ImmutableMap.of;
import static org.mockito.Mockito.*;
import static ratpack.http.Status.OK;

public class RemovePlayerHandlerTest {
    private RemovePlayerHandler handler;
    private Context context = mock(Context.class);
    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    private Gson gson;

    @Before
    public void setUp() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        handler = new RemovePlayerHandler(gson);
        when(context.getRequest()).thenReturn(request);
        when(context.getResponse()).thenReturn(response);
    }

    @Test
    public void returnJsonContentType() {
        when(request.getQueryParams()).thenReturn(playerIdParameter("player-id", "some-id"));

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

        verify(context).render(gson.toJson(new CreateResponse(OK.getCode(), "Game has been deleted.")));
    }

    private ImmutableDelegatingMultiValueMap playerIdParameter(String key, String playerId) {
        return new ImmutableDelegatingMultiValueMap(of(key, ImmutableList.of(playerId)));
    }
}