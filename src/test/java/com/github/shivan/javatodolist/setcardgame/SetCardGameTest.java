package com.github.shivan.javatodolist.setcardgame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SetCardGameTest {

    @Test
    void testIsSetWorksAsExpected01() {
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

        Board board = new Board();
        assertFalse(board.isSet(card1, card2, card3));
    }

    @Test
    void testIsSetWorksAsExpected02() {
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

        Board board = new Board();
        assertFalse(board.isSet(card1, card2, card3));
    }

    @Test
    void testIsNotSetWorksAsExpected01() {
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

        Board board = new Board();
        assertFalse(board.isSet(card1, card2, card3));
    }

    @Test
    void testIsNotSetWorksAsExpected02() {
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

        Board board = new Board();
        assertFalse(board.isSet(card1, card2, card3));
    }

    @Test
    void testCreateDeckWorksAsExpected() {
        SetCardGame setCardGame = new SetCardGame();
        ArrayList<Card> deck = setCardGame.deck;

        assertEquals(81, deck.size());

        for (Card currentCard : deck) {
            long numberOfOccurrences = deck.stream().filter(card -> card.equals(currentCard)).count();
            assertEquals(1, numberOfOccurrences);
        }
    }

    @Test
    void testDrawCardWorksAsExpected() {
        SetCardGame setCardGame = new SetCardGame();
        int sizeOfDeckBeforeDrawing = setCardGame.deck.size();

        setCardGame.drawCard();

        int sizeOfDeckAfterDrawing = setCardGame.deck.size();
        assertEquals(sizeOfDeckAfterDrawing, sizeOfDeckBeforeDrawing - 1);
    }

    @Test
    void testShuffleDeckWorksAsExpected() {
        SetCardGame setCardGame = new SetCardGame();
        Card firstCardBeforeShuffling = setCardGame.deck.get(0);

        int sizeBeforeShuffling = setCardGame.deck.size();
        setCardGame.shuffleDeck();
        int sizeAfterShuffling = setCardGame.deck.size();

        Card firstCardAfterShuffling = setCardGame.deck.get(0);

        assertEquals(sizeAfterShuffling, sizeBeforeShuffling);
        assertNotEquals(firstCardBeforeShuffling, firstCardAfterShuffling);
    }

    @Test
    void testDealCards() {
        SetCardGame setCardGame = new SetCardGame();
        setCardGame.dealCards();
        int sizeOfDeck = setCardGame.deck.size();
        int sizeOfBoard = setCardGame.board.cards.size();
        assertEquals(sizeOfBoard, 3);
        assertEquals(sizeOfDeck, 78);
    }

    @Test
    void testGame() {
        SetCardGame setCardGame = new SetCardGame();
        setCardGame.shuffleDeck();

        setCardGame.dealCards();
        setCardGame.dealCards();
        setCardGame.dealCards();
        setCardGame.dealCards();

        assertEquals(setCardGame.board.cards.size(), 12);

        boolean hasSet = setCardGame.board.removeSetIfExists();

        if (hasSet == true) {
            System.out.println("--> Board had a set");
            assertEquals(setCardGame.board.cards.size(), 9);
        } else {
            System.out.println("--> Board had NO set");
            assertEquals(setCardGame.board.cards.size(), 12);
        }

        setCardGame.dealCards();
    }
}
