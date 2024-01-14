package com.github.shivan.javatodolist.setcardgame;

import java.util.ArrayList;
import java.util.Collections;

public class SetCardGame {

    ArrayList<Card> deck = createDeck();
    Board board = new Board();

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
            board.cards.add(card);
        }
    }
}
