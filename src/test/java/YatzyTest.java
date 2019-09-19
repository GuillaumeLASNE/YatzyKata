import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class YatzyTest {

    @Test
    @Parameters({"2, 3, 4, 5, 1, 15", "3, 3, 4, 5, 1, 16"})
    public void chance_scores_sum_of_all_dice(int d1, int d2, int d3, int d4, int d5, int score) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);

        assertThat(yatzy.chance()).isEqualTo(score);
    }

    @Test
    @Parameters({"4, 4, 4, 4, 4, 50", "6, 6, 6, 6, 6, 50"})
    public void yatzy_scores_50_if_all_dice_have_the_same_number(int d1, int d2, int d3, int d4, int d5, int score) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);

        assertThat(yatzy.yatzy()).isEqualTo(score);
    }

    @Test
    public void yatzy_scores_0_if_at_least_two_dice_have_different_numbers() {
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    public void ones_scores_sum_of_dice_at_value_one() {
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void twos_scores_sum_of_dice_at_value_two() {
        assertEquals(0, new Yatzy(1, 5, 3, 1, 6).twos());
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
    }

    @Test
    public void threes_scores_sum_of_dice_at_value_three() {
        assertEquals(0, new Yatzy(1, 2, 4, 2, 4).threes());
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).threes());
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).threes());
    }

    @Test
    public void fours_scores_sum_of_dice_at_value_four() {
        assertEquals(0, new Yatzy(5, 5, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
    }

    @Test
    public void fives_scores_sum_of_dice_at_value_five() {
        assertEquals(0, new Yatzy(4, 4, 4, 4, 4).fives());
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixes_scores_sum_of_dice_at_value_six() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void one_pair_scores_the_sum_of_the_highest_matching_pair() {
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).onePair());
        assertEquals(6, new Yatzy(3, 4, 3, 5, 6).onePair());
        assertEquals(10, new Yatzy(5, 3, 3, 3, 5).onePair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).onePair());
    }

    @Test
    public void two_pair_scores_the_sum_of_each_pairs() {
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).twoPair());
        assertEquals(16, new Yatzy(3, 3, 5, 4, 5).twoPair());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).twoPair());
    }

    @Test
    public void three_of_a_kind_scores_the_sum_of_three_identical_dices() {
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).threeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).threeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).threeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 3).threeOfAKind());
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).threeOfAKind());
    }

    @Test
    public void four_of_a_kind_scores_the_sum_four_identical_dices() {
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).fourOfAKind());
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).fourOfAKind());
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).fourOfAKind());
    }

    @Test
    public void small_straight_scores_15_when_dice_contains_1_2_3_4_and_5() {
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
        assertEquals(15, new Yatzy(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).smallStraight());
    }

    @Test
    public void large_straight_scores_20_when_dice_contains_2_3_4_5_and_6() {
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
        assertEquals(20, new Yatzy(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new Yatzy(2, 3, 4, 5, 6).largeStraight());
    }

    @Test
    public void full_house_scores_sum_of_dice_with_a_pair_and_a_three_of_a_kind() {
        assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
        assertEquals(18, new Yatzy(6, 2, 2, 2, 6).fullHouse());
    }
}
