package fr.lacombe.yatzy;

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
