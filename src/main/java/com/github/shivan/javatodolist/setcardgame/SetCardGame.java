package com.github.shivan.javatodolist.setcardgame;

import java.util.ArrayList;
import java.util.Collections;

public class SetCardGame {

    ArrayList<Card> deck = createDeck();
    Board board = new Board();

    private boolean allTheSameOrAllDifferent (int a, int b, int c) {
        if (a==b && b==c) {
            return true;
        } else if (a!=b && b!=c && c!=a) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSet(Card card1, Card card2, Card card3) {
        boolean color = allTheSameOrAllDifferent(card1.color, card2.color, card3.color);
        boolean shape = allTheSameOrAllDifferent(card1.shape, card2.shape, card3.shape);
        boolean number = allTheSameOrAllDifferent(card1.number, card2.number, card3.number);
        boolean shading = allTheSameOrAllDifferent(card1.shading, card2.shading, card3.shading);
        if (color && shape && number && shading) {
            return true;
        }
        else {
            return false;
        }
    }

    private ArrayList<Card> createDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (int color = 1; color <= 3; color++) {
            for (int shape = 1; shape <= 3; shape++) {
                for (int shading = 1; shading <= 3; shading++) {
                    for (int number = 1; number <= 3; number++) {
                        // Create a card with the current property values
                        Card newCard = new Card();
                        newCard.color = color;
                        newCard.shape = shape;
                        newCard.shading = shading;
                        newCard.number = number;
                        deck.add(newCard);
                    }
                }
            }
        }


        return deck;
    }

    public Card drawCard() {
        return deck.remove(0);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void dealCards() {
        for (int cardNumber = 1; cardNumber <= 3; cardNumber++) {
            Card card = drawCard();
            board.boardCards.add(card);
        }

    }
}
