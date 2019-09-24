package fr.lacombe.yatzy;

import java.util.List;

public class TwoPairScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        List<Integer> pairs = roll.getPairs();
        if (pairs.size() < 2) {
            return 0;
        }

        return pairs.stream()
                .reduce(0, (accumulator, dieValue) -> accumulator + dieValue * 2);
    }
}
