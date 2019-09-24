package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SixesScoringRuleTest {
    @ParameterizedTest
    @MethodSource("sixes_source")
    void sixes_scores_sum_of_dice_at_value_six(Roll roll, int score) {
        ScoringRule sixesScoringRule = new SixesScoringRule();
        assertThat(sixesScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> sixes_source() {
        return Stream.of(
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        0
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(4),
                                Die.valueOf(4),
                                Die.valueOf(6),
                                Die.valueOf(5),
                                Die.valueOf(5)
                        ),
                        6
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(6),
                                Die.valueOf(5),
                                Die.valueOf(6),
                                Die.valueOf(6),
                                Die.valueOf(5)
                        ),
                        18
                )
        );
    }


}