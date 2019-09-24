package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class ThreeOfAKindScoringRuleTest {
    @ParameterizedTest
    @MethodSource("three_of_a_kind_source")
    void three_of_a_kind_scores_the_sum_of_three_identical_dices(Roll roll, int score) {
        ScoringRule threeOfAKindScoringRule = new ThreeOfAKindScoringRule();
        assertThat(threeOfAKindScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> three_of_a_kind_source() {
        return Stream.of(
                Arguments.of(Roll.of(ONE, TWO, THREE, FIVE, SIX), 0),
                Arguments.of(Roll.of(THREE, THREE, THREE, FOUR, FIVE), 9),
                Arguments.of(Roll.of(THREE, THREE, THREE, THREE, FIVE), 9),
                Arguments.of(Roll.of(THREE, THREE, THREE, THREE, THREE), 9),
                Arguments.of(Roll.of(FIVE, THREE, FIVE, FOUR, FIVE), 15)
        );
    }

}