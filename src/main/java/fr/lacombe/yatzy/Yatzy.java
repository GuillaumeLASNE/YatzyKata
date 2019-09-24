package fr.lacombe.yatzy;

public class Yatzy {

    private final ScoringRule scoringRule;
    private Roll roll;

    public Yatzy(Roll roll) {
        this.roll = roll;
        scoringRule = null;
    }

    public Yatzy(ScoringRule scoringRule, Roll roll) {
        this.scoringRule = scoringRule;
        this.roll = roll;
    }

    public int score() {
        return scoringRule.score(roll);
    }

    public int largeStraight() {
        if (roll.isLargeStraight()) {
            return 20;
        } else {
            return 0;
        }
    }

    public int fullHouse() {
        if (!roll.isFullHouse()) {
            return 0;
        }

        return roll.sumRollDice();
    }
}
