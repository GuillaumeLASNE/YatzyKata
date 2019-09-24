package fr.lacombe.yatzy;

import fr.lacombe.yatzy.scoring.rule.FullHouseScoringRule;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class YatzyTest {
    @ParameterizedTest
    @MethodSource("full_house_source")
    void full_house_scores_sum_of_dice_with_a_pair_and_a_three_of_a_kind(Roll roll, int score) {
        Yatzy yatzy = new Yatzy(new FullHouseScoringRule(), roll);

        assertThat(yatzy.score()).isEqualTo(score);
    }

    private static Stream<Arguments> full_house_source() {
        return Stream.of(
                Arguments.of(new Roll(new int[]{2, 3, 4, 5, 6}), 0),
                Arguments.of(new Roll(new int[]{6, 2, 2, 2, 6}), 18)
        );
    }
}
