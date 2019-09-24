package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;

import java.util.Collections;
import java.util.List;

public class OnePairScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        List<Integer> pairs = roll.getPairs();

        if (pairs.size() < 1) {
            return 0;
        }

        pairs.sort(Collections.reverseOrder());
        return pairs.get(0) * 2;
    }
}
