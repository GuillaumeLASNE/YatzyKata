package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;

public class TwosScoringRule implements ScoringRule {

    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(2);
    }
}
