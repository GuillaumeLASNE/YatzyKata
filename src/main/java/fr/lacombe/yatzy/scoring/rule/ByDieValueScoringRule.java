package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Die;
import fr.lacombe.yatzy.Roll;

public class ByDieValueScoringRule implements ScoringRule {
    private final Die die;

    public ByDieValueScoringRule(Die die) {
        this.die = die;
    }

    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(die.getValue());
    }
}
