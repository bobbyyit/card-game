package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Player;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class PlayerCreationServiceTest {

    private PlayerCreationService service;

    @Before
    public void createService() {
        service = new PlayerCreationService();
    }

    @Test
    public void createsNewPlayer() {
        Player player = service.createNewPlayer();
        assertThat(player.getId(), is(notNullValue()));
    }
}