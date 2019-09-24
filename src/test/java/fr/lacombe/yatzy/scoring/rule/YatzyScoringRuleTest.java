package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class YatzyScoringRuleTest {

    @ParameterizedTest
    @MethodSource("yatzy_source")
    void yatzy_scores_50_if_all_dice_have_the_same_number(Roll roll, int score) {
        ScoringRule yatzyScoringRule = new YatzyScoringRule();

        assertThat(yatzyScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> yatzy_source() {
        return Stream.of(
                Arguments.of(Roll.of(FOUR, FOUR, FOUR, FOUR, FOUR), 50),
                Arguments.of(Roll.of(SIX, SIX, SIX, SIX, SIX), 50)
        );
    }

    @Test
    void yatzy_scores_0_if_at_least_two_dice_have_different_values() {
        Roll roll = Roll.of(SIX, SIX, SIX, SIX, THREE);
        YatzyScoringRule yatzyScoringRule = new YatzyScoringRule();

        assertThat(yatzyScoringRule.score(roll)).isEqualTo(0);
    }
}