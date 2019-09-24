package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class FourOfAKindScoringRuleTest {
    @ParameterizedTest
    @MethodSource("four_of_a_kind_source")
    void four_of_a_kind_scores_the_sum_four_identical_dices(Roll roll, int score) {
        ScoringRule fourOfAKindScoringRule = new FourOfAKindScoringRule();

        assertThat(fourOfAKindScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> four_of_a_kind_source() {
        return Stream.of(
                Arguments.of(Roll.of(ONE, TWO, THREE, FIVE, SIX), 0),
                Arguments.of(Roll.of(THREE, THREE, THREE, THREE, FIVE), 12),
                Arguments.of(Roll.of(FIVE, FIVE, FIVE, FOUR, FIVE), 20)
        );
    }
}