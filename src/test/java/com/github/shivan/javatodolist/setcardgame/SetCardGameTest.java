package com.github.shivan.javatodolist.setcardgame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SetCardGameTest {

    @Test
    void testIsSetWorksAsExpected01() {
        SetCardGame setCardGame = new SetCardGame();

        Card card1 = new Card();
        card1.number = 1;
        card1.color = 1;
        card1.shape = 1;
        card1.shading = 1;

        Card card2 = new Card();
        card2.number = 2;
        card2.color = 2;
        card2.shape = 2;
        card2.shading = 2;

        Card card3 = new Card();
        card3.number = 3;
        card3.color = 3;
        card3.shape = 3;
        card3.shading = 3;

        assertTrue(setCardGame.isSet(card1, card2, card3));
    }

    @Test
    void testIsSetWorksAsExpected02() {
        SetCardGame setCardGame = new SetCardGame();

        Card card1 = new Card();
        card1.number = 1;
        card1.color = 2;
        card1.shape = 1;
        card1.shading = 1;

        Card card2 = new Card();
        card2.number = 1;
        card2.color = 1;
        card2.shape = 1;
        card2.shading = 1;

        Card card3 = new Card();
        card3.number = 1;
        card3.color = 3;
        card3.shape = 1;
        card3.shading = 1;

        assertTrue(setCardGame.isSet(card1, card2, card3));
    }

    @Test
    void testIsNotSetWorksAsExpected01() {
        SetCardGame setCardGame = new SetCardGame();

        Card card1 = new Card();
        card1.number = 1;
        card1.color = 1;
        card1.shape = 1;
        card1.shading = 1;

        Card card2 = new Card();
        card2.number = 2;
        card2.color = 2;
        card2.shape = 2;
        card2.shading = 2;

        Card card3 = new Card();
        card3.number = 3;
        card3.color = 3;
        card3.shape = 3;
        card3.shading = 1;

        assertFalse(setCardGame.isSet(card1, card2, card3));
    }

    @Test
    void testIsNotSetWorksAsExpected02() {
        SetCardGame setCardGame = new SetCardGame();

        Card card1 = new Card();
        card1.number = 1;
        card1.color = 1;
        card1.shape = 1;
        card1.shading = 1;

        Card card2 = new Card();
        card2.number = 2;
        card2.color = 2;
        card2.shape = 2;
        card2.shading = 2;

        Card card3 = new Card();
        card3.number = 1;
        card3.color = 3;
        card3.shape = 3;
        card3.shading = 3;

        assertFalse(setCardGame.isSet(card1, card2, card3));
    }

    @Test
    void testCreateDeckWorksAsExpected() {
        SetCardGame setCardGame = new SetCardGame();
        ArrayList<Card> deck = setCardGame.createDeck();

        assertEquals(81, deck.size());

        for (Card currentCard : deck) {
            long numberOfOccurrences = deck.stream().filter(card -> card.equals(currentCard)).count();
            assertEquals(1, numberOfOccurrences);
        }
    }

    @Test
    void testDrawCardWorksAsExpected() {
        SetCardGame setCardGame = new SetCardGame();
        ArrayList<Card> deck = setCardGame.createDeck();
        int sizeOfDeckBeforeDrawing = deck.size();

        setCardGame.drawCard(deck);

        int sizeOfDeckAfterDrawing = deck.size();
        assertEquals(sizeOfDeckAfterDrawing, sizeOfDeckBeforeDrawing - 1);
    }

    @Test
    void testShuffleDeckWorksAsExpected() {
        SetCardGame setCardGame = new SetCardGame();
        ArrayList<Card> deck = setCardGame.createDeck();
        Card firstCardBeforeShuffling = deck.get(0);

        int sizeBeforeShuffling = deck.size();
        setCardGame.shuffleDeck(deck);
        int sizeAfterShuffling = deck.size();

        Card firstCardAfterShuffling = deck.get(0);

        assertEquals(sizeAfterShuffling, sizeBeforeShuffling);
        assertNotEquals(firstCardBeforeShuffling, firstCardAfterShuffling);
    }
}
