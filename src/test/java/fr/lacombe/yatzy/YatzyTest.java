package fr.lacombe.yatzy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @ParameterizedTest
    @MethodSource("chance_source")
    void chance_scores_sum_of_all_dice(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(roll);

        assertThat(yatzy.chance()).isEqualTo(score);
    }

    private static Stream<Arguments> chance_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{2, 3, 4, 5, 1}), 15),
                Arguments.of(new Roll(new int[]{3, 3, 4, 5, 1}), 16)
        );
    }

    @ParameterizedTest
    @MethodSource("yatzy_source")
    void yatzy_scores_50_if_all_dice_have_the_same_number(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(roll);

        assertThat(yatzy.yatzy()).isEqualTo(score);
    }

    private static Stream<Arguments> yatzy_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{4, 4, 4, 4, 4}), 50),
                Arguments.of(new Roll(new int[]{6, 6, 6, 6, 6}), 50)
        );
    }

    @Test
    void yatzy_scores_0_if_at_least_two_dice_have_different_numbers() {
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    void ones_scores_sum_of_dice_at_value_one() {
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
    }

    @Test
    void twos_scores_sum_of_dice_at_value_two() {
        assertEquals(0, new Yatzy(1, 5, 3, 1, 6).twos());
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
    }

    @Test
    void threes_scores_sum_of_dice_at_value_three() {
        assertEquals(0, new Yatzy(1, 2, 4, 2, 4).threes());
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).threes());
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).threes());
    }

    @Test
    void fours_scores_sum_of_dice_at_value_four() {
        assertEquals(0, new Yatzy(5, 5, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
    }

    @Test
    void fives_scores_sum_of_dice_at_value_five() {
        assertEquals(0, new Yatzy(4, 4, 4, 4, 4).fives());
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    void sixes_scores_sum_of_dice_at_value_six() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    void one_pair_scores_the_sum_of_the_highest_matching_pair() {
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).onePair());
        assertEquals(6, new Yatzy(3, 4, 3, 5, 6).onePair());
        assertEquals(10, new Yatzy(5, 3, 3, 3, 5).onePair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).onePair());
    }

    @Test
    void two_pair_scores_the_sum_of_each_pairs() {
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).twoPair());
        assertEquals(16, new Yatzy(3, 3, 5, 4, 5).twoPair());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).twoPair());
    }

    @Test
    void three_of_a_kind_scores_the_sum_of_three_identical_dices() {
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).threeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).threeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).threeOfAKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 3).threeOfAKind());
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).threeOfAKind());
    }

    @Test
    void four_of_a_kind_scores_the_sum_four_identical_dices() {
        assertEquals(0, new Yatzy(1, 2, 3, 5, 6).fourOfAKind());
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).fourOfAKind());
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).fourOfAKind());
    }

    @Test
    void small_straight_scores_15_when_dice_contains_1_2_3_4_and_5() {
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
        assertEquals(15, new Yatzy(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).smallStraight());
    }

    @Test
    void large_straight_scores_20_when_dice_contains_2_3_4_5_and_6() {
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
        assertEquals(20, new Yatzy(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new Yatzy(2, 3, 4, 5, 6).largeStraight());
    }

    @Test
    void full_house_scores_sum_of_dice_with_a_pair_and_a_three_of_a_kind() {
        assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
        assertEquals(18, new Yatzy(6, 2, 2, 2, 6).fullHouse());
    }
}
