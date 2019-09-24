package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;

public class SmallStraightScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        if (roll.isSmallStraight()) {
            return 15;
        } else {
            return 0;
        }
    }
}
