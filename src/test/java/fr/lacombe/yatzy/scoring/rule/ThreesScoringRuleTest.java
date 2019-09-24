package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ThreesScoringRuleTest {
    @ParameterizedTest
    @MethodSource("threes_source")
    void threes_scores_sum_of_dice_at_value_three(Roll roll, int score) {
        ScoringRule threesScoringRule = new ThreesScoringRule();
        assertThat(threesScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> threes_source() {
        return Stream.of(
                Arguments.of(
                        Roll.of(
                                Die.valueOf(1),
                                Die.valueOf(2),
                                Die.valueOf(4),
                                Die.valueOf(2),
                                Die.valueOf(4)
                        ),
                        0
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(1),
                                Die.valueOf(2),
                                Die.valueOf(3),
                                Die.valueOf(2),
                                Die.valueOf(3)
                        ),
                        6
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(2),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3)
                        ),
                        12
                )
        );
    }
}