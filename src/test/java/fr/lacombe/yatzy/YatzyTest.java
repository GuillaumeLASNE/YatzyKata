package fr.lacombe.yatzy;

import fr.lacombe.yatzy.scoring.rule.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class YatzyTest {

    @ParameterizedTest
    @MethodSource("two_pair_source")
    void two_pair_scores_the_sum_of_each_pairs(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new TwoPairScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> two_pair_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{1, 2, 3, 5, 6}), 0),
                Arguments.of(new Roll(new int[]{3, 3, 5, 4, 5}), 16),
                Arguments.of(new Roll(new int[]{3, 3, 5, 5, 5}), 16)
        );
    }

    @ParameterizedTest
    @MethodSource("three_of_a_kind_source")
    void three_of_a_kind_scores_the_sum_of_three_identical_dices(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new ThreeOfAKindScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> three_of_a_kind_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{1, 2, 3, 5, 6}), 0),
                Arguments.of(new Roll(new int[]{3, 3, 3, 4, 5}), 9),
                Arguments.of(new Roll(new int[]{3, 3, 3, 3, 5}), 9),
                Arguments.of(new Roll(new int[]{3, 3, 3, 3, 3}), 9),
                Arguments.of(new Roll(new int[]{5, 3, 5, 4, 5}), 15)
        );
    }

    @ParameterizedTest
    @MethodSource("four_of_a_kind_source")
    void four_of_a_kind_scores_the_sum_four_identical_dices(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new FourOfAKindScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> four_of_a_kind_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{1, 2, 3, 5, 6}), 0),
                Arguments.of(new Roll(new int[]{3, 3, 3, 3, 5}), 12),
                Arguments.of(new Roll(new int[]{5, 5, 5, 4, 5}), 20)
        );
    }

    @ParameterizedTest
    @MethodSource("small_straight_source")
    void small_straight_scores_15_when_dice_contains_1_2_3_4_and_5(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new SmallStraightScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> small_straight_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{1, 2, 2, 4, 5}), 0),
                Arguments.of(new Roll(new int[]{1, 2, 3, 4, 5}), 15),
                Arguments.of(new Roll(new int[]{2, 3, 4, 5, 1}), 15)
        );
    }


    @ParameterizedTest
    @MethodSource("large_straight_source")
    void large_straight_scores_20_when_dice_contains_2_3_4_5_and_6(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new LargeStraightScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> large_straight_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{1, 2, 2, 4, 5}), 0),
                Arguments.of(new Roll(new int[]{6, 2, 3, 4, 5}), 20),
                Arguments.of(new Roll(new int[]{2, 3, 4, 5, 6}), 20)
        );
    }

    @ParameterizedTest
    @MethodSource("full_house_source")
    void full_house_scores_sum_of_dice_with_a_pair_and_a_three_of_a_kind(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new FullHouseScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> full_house_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{2, 3, 4, 5, 6}), 0),
                Arguments.of(new Roll(new int[]{6, 2, 2, 2, 6}), 18)
        );
    }
}
