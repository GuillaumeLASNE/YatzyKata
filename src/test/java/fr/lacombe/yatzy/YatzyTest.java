package fr.lacombe.yatzy;

import fr.lacombe.yatzy.scoring.rule.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class YatzyTest {

    @ParameterizedTest
    @MethodSource("yatzy_source")
    void yatzy_scores_50_if_all_dice_have_the_same_number(Roll roll, int score) {
        ScoringRule yatzyScoringRule = new YatzyScoringRule();
        Yatzy yatzy = new Yatzy(yatzyScoringRule, roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> yatzy_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{4, 4, 4, 4, 4}), 50),
                Arguments.of(new Roll(new int[]{6, 6, 6, 6, 6}), 50)
        );
    }

    @Test
    void yatzy_scores_0_if_at_least_two_dice_have_different_numbers() {
        Roll rollHavingDiceWithDifferentValues = new Roll(new int[]{6, 6, 6, 6, 3});

        Yatzy yatzy = new Yatzy(new YatzyScoringRule(), rollHavingDiceWithDifferentValues);

        assertThat(yatzy.score()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("ones_source")
    void ones_scores_sum_of_dice_at_value_one(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new OnesScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> ones_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{6, 2, 2, 4, 5}), 0),
                Arguments.of(new Roll(new int[]{1, 2, 3, 4, 5}), 1),
                Arguments.of(new Roll(new int[]{1, 2, 1, 4, 5}), 2),
                Arguments.of(new Roll(new int[]{1, 2, 1, 1, 1}), 4)
        );
    }

    @ParameterizedTest
    @MethodSource("twos_source")
    void twos_scores_sum_of_dice_at_value_two(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new TwosScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> twos_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{1, 5, 3, 1, 6}), 0),
                Arguments.of(new Roll(new int[]{1, 2, 3, 2, 6}), 4),
                Arguments.of(new Roll(new int[]{2, 2, 2, 2, 2}), 10)
        );
    }

    @ParameterizedTest
    @MethodSource("threes_source")
    void threes_scores_sum_of_dice_at_value_three(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new ThreesScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> threes_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{1, 2, 4, 2, 4}), 0),
                Arguments.of(new Roll(new int[]{1, 2, 3, 2, 3}), 6),
                Arguments.of(new Roll(new int[]{2, 3, 3, 3, 3}), 12)
        );
    }

    @ParameterizedTest
    @MethodSource("fours_source")
    void fours_scores_sum_of_dice_at_value_four(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new FoursScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> fours_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{5, 5, 5, 5, 5}), 0),
                Arguments.of(new Roll(new int[]{4, 5, 5, 5, 5}), 4),
                Arguments.of(new Roll(new int[]{4, 4, 5, 5, 5}), 8),
                Arguments.of(new Roll(new int[]{4, 4, 4, 5, 5}), 12)
        );
    }

    @ParameterizedTest
    @MethodSource("fives_source")
    void fives_scores_sum_of_dice_at_value_five(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new FivesScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> fives_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{4, 4, 4, 4, 4}), 0),
                Arguments.of(new Roll(new int[]{4, 4, 4, 5, 5}), 10),
                Arguments.of(new Roll(new int[]{4, 4, 5, 5, 5}), 15),
                Arguments.of(new Roll(new int[]{4, 5, 5, 5, 5}), 20)
        );
    }

    @ParameterizedTest
    @MethodSource("sixes_source")
    void sixes_scores_sum_of_dice_at_value_six(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new SixesScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> sixes_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{4, 4, 4, 5, 5}), 0),
                Arguments.of(new Roll(new int[]{4, 4, 6, 5, 5}), 6),
                Arguments.of(new Roll(new int[]{6, 5, 6, 6, 5}), 18)
        );
    }

    @ParameterizedTest
    @MethodSource("one_pair_source")
    void one_pair_scores_the_sum_of_the_highest_matching_pair(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new OnePairScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> one_pair_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{1, 2, 3, 5, 6}), 0),
                Arguments.of(new Roll(new int[]{3, 4, 3, 5, 6}), 6),
                Arguments.of(new Roll(new int[]{5, 3, 3, 3, 5}), 10),
                Arguments.of(new Roll(new int[]{5, 3, 6, 6, 5}), 12)
        );
    }

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
