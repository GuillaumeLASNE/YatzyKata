package fr.lacombe.yatzy;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RollTest {

    @Test
    @Parameters({"2, 3, 4, 5, 1, 15", "3, 3, 4, 5, 1, 16"})
    public void chance_scores_sum_of_all_dice(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.chance()).isEqualTo(score);
    }

    @Test
    @Parameters({"4, 4, 4, 4, 4, 50", "6, 6, 6, 6, 6, 50"})
    public void yatzy_scores_50_if_all_dice_have_the_same_number(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.yatzy()).isEqualTo(score);
    }

    @Test
    public void yatzy_scores_0_if_at_least_two_dice_have_different_values() {
        Roll roll = new Roll(6, 6, 6, 6, 3);

        int score = roll.yatzy();

        assertThat(score).isEqualTo(0);
    }

    @Test
    @Parameters({
            "6, 2, 2, 4, 5, 0",
            "1, 2, 3, 4, 5, 1",
            "1, 2, 1, 4, 5, 2",
            "1, 2, 1, 1, 1, 4"
    })
    public void ones_scores_sum_of_dice_at_value_one(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.ones()).isEqualTo(score);
    }

    @Test
    @Parameters({
            "1, 5, 3, 1, 6, 0",
            "1, 2, 3, 2, 6, 4",
            "2, 2, 2, 2, 2, 10"
    })
    public void twos_scores_sum_of_dice_at_value_two(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.twos()).isEqualTo(score);
    }

    @Test
    @Parameters({
            "1, 2, 4, 2, 4, 0",
            "1, 2, 3, 2, 3, 6",
            "2, 3, 3, 3, 3, 12"
    })
    public void threes_scores_sum_of_dice_at_value_three(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.threes()).isEqualTo(score);
    }

    @Test
    @Parameters({
            "5, 5, 5, 5, 5, 0",
            "4, 5, 5, 5, 5, 4",
            "4, 4, 5, 5, 5, 8",
            "4, 4, 4, 5, 5, 12"
    })
    public void fours_scores_sum_of_dice_at_value_four(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.fours()).isEqualTo(score);
    }

    @Test
    @Parameters({
            "4, 4, 4, 4, 4, 0",
            "4, 4, 4, 5, 5, 10",
            "4, 4, 5, 5, 5, 15",
            "4, 5, 5, 5, 5, 20"
    })
    public void fives_scores_sum_of_dice_at_value_five(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.fives()).isEqualTo(score);
    }

    @Test
    @Parameters({
            "4, 4, 4, 5, 5, 0",
            "4, 4, 6, 5, 5, 6",
            "6, 5, 6, 6, 5, 18"
    })
    public void sixes_scores_sum_of_dice_at_value_six(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.sixes()).isEqualTo(score);
    }

    @Test
    @Parameters({
            "1, 2, 3, 5, 6, 0 ",
            "3, 4, 3, 5, 6, 6 ",
            "5, 3, 3, 3, 5, 10",
            "5, 3, 6, 6, 5, 12"
    })
    public void one_pair_scores_the_sum_of_the_highest_matching_pair(int die1, int die2, int die3, int die4, int die5, int score) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        assertThat(roll.onePair()).isEqualTo(score);
    }

    @Test
    public void two_pair_scores_the_sum_of_each_pairs() {
        assertEquals(0 , new Roll(1, 2, 3, 5, 6).twoPair());
        assertEquals(16, new Roll(3, 3, 5, 4, 5).twoPair());
        assertEquals(16, new Roll(3, 3, 5, 5, 5).twoPair());
    }

    @Test
    public void three_of_a_kind_scores_the_sum_of_three_identical_dices() {
        assertEquals(0 , new Roll(1, 2, 3, 5, 6).threeOfAKind());
        assertEquals(9 , new Roll(3, 3, 3, 4, 5).threeOfAKind());
        assertEquals(9 , new Roll(3, 3, 3, 3, 5).threeOfAKind());
        assertEquals(9 , new Roll(3, 3, 3, 3, 3).threeOfAKind());
        assertEquals(15, new Roll(5, 3, 5, 4, 5).threeOfAKind());
    }

    @Test
    public void four_of_a_kind_scores_the_sum_four_identical_dices() {
        assertEquals(0 , new Roll(1, 2, 3, 5, 6).fourOfAKind());
        assertEquals(12, new Roll(3, 3, 3, 3, 5).fourOfAKind());
        assertEquals(20, new Roll(5, 5, 5, 4, 5).fourOfAKind());
    }

    @Test
    public void small_straight_scores_15_when_dice_contains_1_2_3_4_and_5() {
        assertEquals(0 , new Roll(1, 2, 2, 4, 5).smallStraight());
        assertEquals(15, new Roll(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new Roll(2, 3, 4, 5, 1).smallStraight());
    }

    @Test
    public void large_straight_scores_20_when_dice_contains_2_3_4_5_and_6() {
        assertEquals(0 , new Roll(1, 2, 2, 4, 5).largeStraight());
        assertEquals(20, new Roll(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new Roll(2, 3, 4, 5, 6).largeStraight());
    }

    @Test
    public void full_house_scores_sum_of_dice_with_a_pair_and_a_three_of_a_kind() {
        assertEquals(0 , new Roll(2, 3, 4, 5, 6).fullHouse());
        assertEquals(18, new Roll(6, 2, 2, 2, 6).fullHouse());
    }
}
