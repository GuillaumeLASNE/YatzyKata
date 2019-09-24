package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
                Arguments.of(
                        Roll.of(
                                Die.valueOf(1),
                                Die.valueOf(2),
                                Die.valueOf(3),
                                Die.valueOf(5),
                                Die.valueOf(6)
                        ),
                        0
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(4),
                                Die.valueOf(5)
                        ),
                        9
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(5)
                        ),
                        9
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3)
                        ),
                        9
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(5),
                                Die.valueOf(3),
                                Die.valueOf(5),
                                Die.valueOf(4),
                                Die.valueOf(5)
                        ),
                        15
                )
        );
    }

}