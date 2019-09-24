package fr.lacombe.yatzy;

import java.util.Optional;

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

    public int smallStraight() {
        if (roll.isSmallStraight()) {
            return 15;
        } else {
            return 0;
        }
    }

    public int largeStraight() {
        if (roll.isLargeStraight()) {
            return 20;
        } else {
            return 0;
        }
    }

    public int fourOfAKind() {
        Optional<Integer> fourOfAKind = roll.getFourOfAKind();
        return fourOfAKind.map(fourOfAKindValue -> fourOfAKindValue * 4).orElse(0);
    }

    public int fullHouse() {
        if (!roll.isFullHouse()) {
            return 0;
        }

        return roll.sumRollDice();
    }
}
