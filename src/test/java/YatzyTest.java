import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    @Test
    public void yatzy_scores_50() {
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
    }

    @Test
    public void ones() {
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void twos() {
        assertEquals(0, Yatzy.twos(1, 5, 3, 1, 6));
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void threes() {
        assertEquals(0, Yatzy.threes(1, 2, 4, 2, 4));
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void fours() {
        assertEquals(0, new Yatzy(5, 5, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
    }

    @Test
    public void fives() {
        assertEquals(0, new Yatzy(4, 4, 4, 4, 4).fives());
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixes() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(0, Yatzy.onePair(1, 2, 3, 5, 6));
        assertEquals(6, Yatzy.onePair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.onePair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.onePair(5, 3, 6, 6, 5));
    }

    @Test
    public void two_pair() {
        assertEquals(0, Yatzy.twoPair(1, 2, 3, 5, 6));
        assertEquals(16, Yatzy.twoPair(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.twoPair(3, 3, 5, 5, 5));
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(0, Yatzy.threeOfAKind(1, 2, 3, 5, 6));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 3));
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
    }

    @Test
    public void four_of_a_kind() {
        assertEquals(0, Yatzy.fourOfAKind(1, 2, 3, 5, 6));
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5));
    }

    @Test
    public void small_straight() {
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
    }

    @Test
    public void large_straight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void full_house() {
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
    }
}
