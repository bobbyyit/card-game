package com.yit.cardgame.service;

import com.yit.cardgame.foundation.Card;
import com.yit.cardgame.foundation.Cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Dealer {
    public Card[] createDeckOfCards() {
        Card[] cards = new Card[52];
        for (Cards card : Cards.values()) {
            cards[card.getId() - 1] = new Card(card.getId(), card.getValue(), card.getSuit(), card.getNiceName());
        }

        return cards;
    }

    public void shuffleCards(Card[] cards) {
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int randomPosition = random.nextInt(cards.length);
            Card temp = cards[i];
            cards[i] = cards[randomPosition];
            cards[randomPosition] = temp;
        }
    }

    public Stack<Card> prepareToDeal(Card[] cards) {
        Stack<Card> cardStack = new Stack<>();
        for (int i = cards.length - 1; i >= 0; i--) {
            cardStack.push(cards[i]);
        }
        return cardStack;
    }

    public Stack<Card> shuffleCards(Stack<Card> cardStack) {
        Card[] cards = new Card[cardStack.size()];
        for (int i = cardStack.size() - 1; i >= 0; i--) {
            Card card = cardStack.pop();
            cards[i] = card;
        }
        shuffleCards(cards);
        return prepareToDeal(cards);
    }

    public List<Card> dealCards(Stack<Card> deckOfCards, int quantity) {
        List<Card> cards = new ArrayList<>();

        int i = 1;
        while(i <= quantity) {
            cards.add(deckOfCards.pop());
            i++;
        }

        return cards;
    }
}
