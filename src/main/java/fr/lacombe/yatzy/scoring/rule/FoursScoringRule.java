package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;

public class FoursScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(4);
    }
}
