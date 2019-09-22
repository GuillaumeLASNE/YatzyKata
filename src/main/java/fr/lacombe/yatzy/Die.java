package fr.lacombe.yatzy;

import java.util.Objects;

public class Die {
    static final int DIE_FACES_NUMBER = 6;
    private final int value;

    private Die(int value) {
        this.value = value;
    }

    public static Die of(int value) {
        return new Die(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Die die = (Die) o;
        return value == die.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }

    public boolean hasValue(int value) {
        return this.value == value;
    }

    public boolean isPair(Die nextDie) {
        return this.equals(nextDie);
    }
}
