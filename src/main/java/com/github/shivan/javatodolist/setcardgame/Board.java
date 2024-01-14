package com.github.shivan.javatodolist.setcardgame;

import java.util.ArrayList;

public class Board {
    ArrayList<Card> cards = new ArrayList<>();

    public boolean removeSetIfExists () {
        for (int c1 = 0; c1 <= cards.size()-3; c1++) {
            for (int c2 = c1+1; c2 <= cards.size()-2; c2++) {
                for (int c3 = c2+1; c3 <= cards.size()-1; c3++) {
                    Card card1 = cards.get(c1);
                    Card card2 = cards.get(c2);
                    Card card3 = cards.get(c3);

                    boolean foundSet = isSet(card1, card2, card3);
                    if (foundSet) {
                        cards.remove(card1);
                        cards.remove(card2);
                        cards.remove(card3);
                        return true;
                    }
                }

            }
        }

        return false;
    }

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
}
