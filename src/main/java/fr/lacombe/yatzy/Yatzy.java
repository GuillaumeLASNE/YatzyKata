package fr.lacombe.yatzy;

import fr.lacombe.yatzy.scoring.rule.ScoringRule;

public class Yatzy {

    private final ScoringRule scoringRule;
    private Roll roll;

    public Yatzy(ScoringRule scoringRule, Roll roll) {
        this.scoringRule = scoringRule;
        this.roll = roll;
    }

    public int score() {
        return scoringRule.score(roll);
    }
}
