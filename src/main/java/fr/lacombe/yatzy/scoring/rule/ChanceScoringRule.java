package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;

public class ChanceScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return roll.sumRollDice();
    }
}
