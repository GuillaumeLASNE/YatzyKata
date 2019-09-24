package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OnePairScoringRuleTest {
    @ParameterizedTest
    @MethodSource("one_pair_source")
    void one_pair_scores_the_sum_of_the_highest_matching_pair(Roll roll, int score) {
        ScoringRule onePairScoringRule = new OnePairScoringRule();
        assertThat(onePairScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> one_pair_source() {
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
                                Die.valueOf(4),
                                Die.valueOf(3),
                                Die.valueOf(5),
                                Die.valueOf(6)
                        ),
                        6
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(5),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(3),
                                Die.valueOf(5)
                        ),
                        10
                ),
                Arguments.of(
                        Roll.of(
                                Die.valueOf(5),
                                Die.valueOf(3),
                                Die.valueOf(6),
                                Die.valueOf(6),
                                Die.valueOf(5)
                        ),
                        12
                )
        );
    }


}