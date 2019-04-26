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

public class AssignDeckHandlerTest {
    private AssignDeckHandler handler;
    private Context context = mock(Context.class);
    private Request request = mock(Request.class);
    private Response response = mock(Response.class);
    private Gson gson;

    @Before
    public void setUp() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        handler = new AssignDeckHandler(gson);
        when(context.getRequest()).thenReturn(request);
        when(context.getResponse()).thenReturn(response);
    }

    @Test
    public void returnJsonContentType() {
        when(request.getQueryParams()).thenReturn(deckIdParameter("deck-id", "some-id"));

        handler.handle(context);

        verify(context).header("content-type", "application/json");
    }

    @Test
    public void returnsOk() {
        when(request.getQueryParams()).thenReturn(deckIdParameter("deck-id", "some-id"));

        handler.handle(context);

        verify(response).status(OK);
    }

    @Test
    public void returnsError() {
        when(request.getQueryParams()).thenReturn(deckIdParameter("bad-id", "some-id"));

        handler.handle(context);

        verify(response).status(400);
    }

    @Test
    public void rendersAssignedMessage() {
        when(request.getQueryParams()).thenReturn(deckIdParameter("deck-id", "some-id"));

        handler.handle(context);

        verify(context).render(gson.toJson(new CreateResponse(OK.getCode(), "Deck has been assigned to the game.")));
    }

    @Test
    public void rendersErrorMessage() {
        when(request.getQueryParams()).thenReturn(deckIdParameter("bad-id", "some-id"));

        handler.handle(context);

        verify(context).render(gson.toJson(new CreateResponse(400, "Bad Parameter, missing deck-id.")));
    }

    private ImmutableDelegatingMultiValueMap deckIdParameter(String key, String deckId) {
        return new ImmutableDelegatingMultiValueMap(of(key, ImmutableList.of(deckId)));
    }
}