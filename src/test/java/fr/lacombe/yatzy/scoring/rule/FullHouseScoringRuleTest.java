package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.lacombe.yatzy.Die.*;
import static org.assertj.core.api.Assertions.assertThat;

class FullHouseScoringRuleTest {
    @ParameterizedTest
    @MethodSource("full_house_source")
    void full_house_scores_sum_of_dice_with_a_pair_and_a_three_of_a_kind(Roll roll, int score) {
        ScoringRule fullHouseScoringRule = new FullHouseScoringRule();
        assertThat(fullHouseScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> full_house_source() {
        return Stream.of(
                Arguments.of(Roll.of(TWO, THREE, FOUR, FIVE, FIVE), 0),
                Arguments.of(Roll.of(SIX, TWO, TWO, TWO, SIX), 18)
        );
    }
}