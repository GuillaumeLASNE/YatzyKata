package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class ByDieValueScoringRuleTest {
    @ParameterizedTest
    @MethodSource("ones_source")
    void ones_scores_sum_of_dice_at_value_one(Roll roll, int expectedScore) {
        ScoringRule oneScoringRule = new ByDieValueScoringRule(ONE);

        assertThat(oneScoringRule.score(roll)).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> ones_source() {
        return Stream.of(
                Arguments.of(Roll.of(SIX, TWO, TWO, FOUR, FIVE), 0),
                Arguments.of(Roll.of(ONE, TWO, THREE, FOUR, FIVE), 1),
                Arguments.of(Roll.of(ONE, TWO, ONE, FOUR, FIVE), 2),
                Arguments.of(Roll.of(ONE, TWO, ONE, ONE, ONE), 4)
        );
    }

    @ParameterizedTest
    @MethodSource("twos_source")
    void twos_scores_sum_of_dice_at_value_two(Roll roll, int score) {
        ScoringRule twosScoringRule = new ByDieValueScoringRule(TWO);
        assertThat(twosScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> twos_source() {
        return Stream.of(
                Arguments.of(Roll.of(ONE, FIVE, THREE, ONE, SIX), 0),
                Arguments.of(Roll.of(ONE, TWO, THREE, TWO, SIX), 4),
                Arguments.of(Roll.of(TWO, TWO, TWO, TWO, TWO), 10)
        );
    }

    @ParameterizedTest
    @MethodSource("threes_source")
    void threes_scores_sum_of_dice_at_value_three(Roll roll, int score) {
        ScoringRule threesScoringRule = new ByDieValueScoringRule(THREE);
        assertThat(threesScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> threes_source() {
        return Stream.of(
                Arguments.of(Roll.of(ONE, TWO, FOUR, TWO, FOUR), 0),
                Arguments.of(Roll.of(ONE, TWO, THREE, TWO, THREE), 6),
                Arguments.of(Roll.of(TWO, THREE, THREE, THREE, THREE), 12)
        );
    }

    @ParameterizedTest
    @MethodSource("fours_source")
    void fours_scores_sum_of_dice_at_value_four(Roll roll, int score) {
        ScoringRule foursScoringRule = new ByDieValueScoringRule(FOUR);
        assertThat(foursScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> fours_source() {
        return Stream.of(
                Arguments.of(Roll.of(FIVE, FIVE, FIVE, FIVE, FIVE), 0),
                Arguments.of(Roll.of(FOUR, FIVE, FIVE, FIVE, FIVE), 4),
                Arguments.of(Roll.of(FOUR, FOUR, FIVE, FIVE, FIVE), 8),
                Arguments.of(Roll.of(FOUR, FOUR, FOUR, FIVE, FIVE), 12)
        );
    }

    @ParameterizedTest
    @MethodSource("fives_source")
    void fives_scores_sum_of_dice_at_value_five(Roll roll, int score) {
        ScoringRule fivesScoringRule = new ByDieValueScoringRule(FIVE);
        assertThat(fivesScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> fives_source() {
        return Stream.of(
                Arguments.of(Roll.of(FOUR, FOUR, FOUR, FOUR, FOUR), 0),
                Arguments.of(Roll.of(FOUR, FOUR, FOUR, FIVE, FIVE), 10),
                Arguments.of(Roll.of(FOUR, FOUR, FIVE, FIVE, FIVE), 15),
                Arguments.of(Roll.of(FOUR, FIVE, FIVE, FIVE, FIVE), 20)
        );
    }

    @ParameterizedTest
    @MethodSource("sixes_source")
    void sixes_scores_sum_of_dice_at_value_six(Roll roll, int score) {
        ScoringRule sixesScoringRule = new ByDieValueScoringRule(SIX);
        assertThat(sixesScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> sixes_source() {
        return Stream.of(
                Arguments.of(Roll.of(FOUR, FOUR, FOUR, FIVE, FIVE), 0),
                Arguments.of(Roll.of(FOUR, FOUR, SIX, FIVE, FIVE), 6),
                Arguments.of(Roll.of(SIX, FIVE, SIX, SIX, FIVE), 18)
        );
    }
}