package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FoursScoringRuleTest {
    @ParameterizedTest
    @MethodSource("fours_source")
    void fours_scores_sum_of_dice_at_value_four(Roll roll, int score) {
        ScoringRule foursScoringRule = new FoursScoringRule();
        assertThat(foursScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> fours_source() {
        return Stream.of(
                Arguments.of(
                        Roll.of(
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        0
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        4
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(5),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        8
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        12
                )
        );
    }


}