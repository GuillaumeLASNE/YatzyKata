package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class SmallStraightScoringRuleTest {
    @ParameterizedTest
    @MethodSource("small_straight_source")
    void small_straight_scores_15_when_dice_contains_1_2_3_4_and_5(Roll roll, int score) {
        ScoringRule smallStraightScoringRule = new SmallStraightScoringRule();

        assertThat(smallStraightScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> small_straight_source() {
        return Stream.of(
                Arguments.of(Roll.of(ONE, TWO, TWO, FOUR, FIVE), 0),
                Arguments.of(Roll.of(ONE, TWO, THREE, FOUR, FIVE), 15),
                Arguments.of(Roll.of(TWO, THREE, FOUR, FIVE, ONE), 15)
        );
    }
}