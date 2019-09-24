package fr.lacombe.yatzy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DieTest {

    @Test
    void die_value_cannot_be_bellow_1() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Die.valueOf(0));
    }

    @Test
    void die_value_cannot_be_above_6() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Die.valueOf(7));
    }
}