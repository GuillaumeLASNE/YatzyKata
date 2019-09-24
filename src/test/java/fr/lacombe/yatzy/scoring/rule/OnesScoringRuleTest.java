package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OnesScoringRuleTest {
    @ParameterizedTest
    @MethodSource("ones_source")
    void ones_scores_sum_of_dice_at_value_one(Roll roll, int expectedScore) {
        OnesScoringRule oneScoringRule = new OnesScoringRule();

        assertThat(oneScoringRule.score(roll)).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> ones_source() {
        return Stream.of(
                Arguments.of(
                        Roll.of(
                                Die.valueOf(6),
                                Die.valueOf(2),
                                Die.valueOf(2),
                                Die.valueOf(4),
                                Die.valueOf(5)
                        ),
                        0),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(1),
                                Die.valueOf(2),
                                Die.valueOf(3),
                                Die.valueOf(4),
                                Die.valueOf(5)
                        ),
                        1
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(1),
                                Die.valueOf(2),
                                Die.valueOf(1),
                                Die.valueOf(4),
                                Die.valueOf(5)
                        ),
                        2
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(1),
                                Die.valueOf(2),
                                Die.valueOf(1),
                                Die.valueOf(1),
                                Die.valueOf(1)
                        ),
                        4
                )
        );
    }


}