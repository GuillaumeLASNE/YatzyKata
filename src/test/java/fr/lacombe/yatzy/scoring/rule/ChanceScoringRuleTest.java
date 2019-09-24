package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class ChanceScoringRuleTest {

    @ParameterizedTest
    @MethodSource("chance_source")
    void chance_scores_sum_of_all_dice(Roll roll, int expectedScore) {
        ScoringRule chanceScoringRule = new ChanceScoringRule();

        assertThat(chanceScoringRule.score(roll)).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> chance_source() {
        return Stream.of(
                Arguments.of(Roll.of(TWO, THREE, FOUR, FIVE, ONE), 15),
                Arguments.of(Roll.of(THREE, THREE, FOUR, FIVE, ONE), 16)
        );
    }
}