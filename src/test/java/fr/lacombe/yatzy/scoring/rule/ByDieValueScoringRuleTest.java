package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ByDieValueScoringRuleTest {
    @ParameterizedTest
    @MethodSource("ones_source")
    void ones_scores_sum_of_dice_at_value_one(Roll roll, int expectedScore) {
        ScoringRule oneScoringRule = new ByDieValueScoringRule(Die.ONE);

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

    @ParameterizedTest
    @MethodSource("twos_source")
    void twos_scores_sum_of_dice_at_value_two(Roll roll, int score) {
        ScoringRule twosScoringRule = new ByDieValueScoringRule(Die.TWO);
        assertThat(twosScoringRule.score(roll)).isEqualTo(score);
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

    @ParameterizedTest
    @MethodSource("threes_source")
    void threes_scores_sum_of_dice_at_value_three(Roll roll, int score) {
        ScoringRule threesScoringRule = new ByDieValueScoringRule(Die.THREE);
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

    @ParameterizedTest
    @MethodSource("fours_source")
    void fours_scores_sum_of_dice_at_value_four(Roll roll, int score) {
        ScoringRule foursScoringRule = new ByDieValueScoringRule(Die.FOUR);
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

    @ParameterizedTest
    @MethodSource("fives_source")
    void fives_scores_sum_of_dice_at_value_five(Roll roll, int score) {
        ScoringRule fivesScoringRule = new ByDieValueScoringRule(Die.FIVE);
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

    @ParameterizedTest
    @MethodSource("sixes_source")
    void sixes_scores_sum_of_dice_at_value_six(Roll roll, int score) {
        ScoringRule sixesScoringRule = new ByDieValueScoringRule(Die.SIX);
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