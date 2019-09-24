package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class LargeStraightScoringRuleTest {
    @ParameterizedTest
    @MethodSource("large_straight_source")
    void large_straight_scores_20_when_dice_contains_2_3_4_5_and_6(Roll roll, int score) {
        ScoringRule largeStraightScoringRule = new LargeStraightScoringRule();

        assertThat(largeStraightScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> large_straight_source() {
        return Stream.of(
                Arguments.of(Roll.of(ONE, TWO, TWO, FOUR, FIVE), 0),
                Arguments.of(Roll.of(SIX, TWO, THREE, FOUR, FIVE), 20),
                Arguments.of(Roll.of(TWO, THREE, FOUR, FIVE, SIX), 20)
        );
    }
}