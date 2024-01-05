package com.github.shivan.javatodolist.setcardgame;

import java.util.Objects;

public class Card {
    int number;
    int color;
    int shape;
    int shading;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number && color == card.color && shape == card.shape && shading == card.shading;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, color, shape, shading);
    }
}
