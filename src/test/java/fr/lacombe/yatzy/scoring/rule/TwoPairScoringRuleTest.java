package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class TwoPairScoringRuleTest {
    @ParameterizedTest
    @MethodSource("two_pair_source")
    void two_pair_scores_the_sum_of_each_pairs(Roll roll, int score) {
        ScoringRule twoPairScoringRule = new TwoPairScoringRule();

        assertThat(twoPairScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> two_pair_source() {
        return Stream.of(
                Arguments.of(Roll.of(ONE, TWO, THREE, FIVE, SIX), 0),
                Arguments.of(Roll.of(THREE, THREE, FIVE, FOUR, FIVE), 16),
                Arguments.of(Roll.of(THREE, THREE, FIVE, FIVE, FIVE), 16)
        );
    }
}