package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwosScoringRuleTest {
    @ParameterizedTest
    @MethodSource("twos_source")
    void twos_scores_sum_of_dice_at_value_two(Roll roll, int score) {
        assertThat(new TwosScoringRule().score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> twos_source() {
        return Stream.of(
                Arguments.of(
                        Roll.of(
                                Die.valueOf(1),
                                Die.valueOf(5),
                                Die.valueOf(3),
                                Die.valueOf(1),
                                Die.valueOf(6)
                        ),
                        0
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(1),
                                Die.valueOf(2),
                                Die.valueOf(3),
                                Die.valueOf(2),
                                Die.valueOf(6)
                        ),
                        4
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(2),
                                Die.valueOf(2),
                                Die.valueOf(2),
                                Die.valueOf(2),
                                Die.valueOf(2)
                        ),
                        10
                )
        );
    }
}