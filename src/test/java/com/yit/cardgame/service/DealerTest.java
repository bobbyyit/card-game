package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class DealerTest {

    private Dealer dealer;


    @Before
    public void setUp() {
        dealer = new Dealer();
    }

    @Test
    public void createAnUnShuffledDeckOfCards() {
        Card[] cards = dealer.createDeckOfCards();

        assertThat(cards, is(notNullValue()));
        assertThat(cards[0].getId(), is(1));
        assertThat(cards[51].getId(), is(52));
    }

    @Test
    public void canShuffleCard() {
        Card[] cards = dealer.createDeckOfCards();
        dealer.shuffleCards(cards);

        assertThat(cards[0].getId(), not(equalTo(1)));
        assertThat(cards[51].getId(), not(equalTo(52)));
    }

    @Test
    public void canPrepareToDealCard() {
        Card[] cards = dealer.createDeckOfCards();

        Stack<Card> stackOfCards = dealer.prepareToDeal(cards);

        assertThat(stackOfCards.pop().getId(), is(1));
    }

    @Test
    public void canReShuffleCards() {
        Card[] cards = dealer.createDeckOfCards();
        Stack<Card> stackOfCards = dealer.prepareToDeal(cards);

        dealer.shuffleCards(stackOfCards);

        assertThat(stackOfCards.pop().getId(), not(equalTo(cards[51].getId())));
    }

    @Test
    public void canDealCards() {
        Stack<Card> stack = new Stack<>();
        stack.push(new Card(1, 1, "some-suit", "nice-name"));
        stack.push(new Card(2, 2, "some-suit", "nice-name"));
        stack.push(new Card(3, 3, "some-suit", "nice-name"));

        List<Card> cards = dealer.dealCards(stack, 3);

        assertThat(cards, hasItems(
                new Card(3, 3, "some-suit", "nice-name"),
                new Card(2, 2, "some-suit", "nice-name"),
                new Card(1, 1, "some-suit", "nice-name")));
    }
}