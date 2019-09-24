package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class YatzyScoringRuleTest {

    @ParameterizedTest
    @MethodSource("yatzy_source")
    void yatzy_scores_50_if_all_dice_have_the_same_number(Roll roll, int score) {
        ScoringRule yatzyScoringRule = new YatzyScoringRule();

        assertThat(yatzyScoringRule.score(roll)).isEqualTo(score);
    }

    private static Stream<Arguments> yatzy_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{4, 4, 4, 4, 4}), 50),
                Arguments.of(new Roll(new int[]{6, 6, 6, 6, 6}), 50)
        );
    }


}