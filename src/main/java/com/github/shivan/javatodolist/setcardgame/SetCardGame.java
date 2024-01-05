package com.github.shivan.javatodolist.setcardgame;

public class SetCardGame {

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
