package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FivesScoringRuleTest {
    @ParameterizedTest
    @MethodSource("fives_source")
    void fives_scores_sum_of_dice_at_value_five(Roll roll, int score) {
        ScoringRule fivesScoringRule = new FivesScoringRule();
        assertThat(fivesScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> fives_source() {
        return Stream.of(
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(4)
                        ),
                        0
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        10
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        15
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        20
                )
        );
    }
}