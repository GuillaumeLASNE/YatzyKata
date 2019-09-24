package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;

public class LargeStraightScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        if (roll.isLargeStraight()) {
            return 20;
        } else {
            return 0;
        }
    }
}
