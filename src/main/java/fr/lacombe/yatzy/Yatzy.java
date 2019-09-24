package fr.lacombe.yatzy;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Yatzy {

    private Roll roll;
    private final ScoringRule scoringRule;

    public Yatzy(Roll roll) {
        this.roll = roll;
        scoringRule = null;
    }

    public Yatzy(Roll roll, ScoringRule scoringRule) {

        this.roll = roll;
        this.scoringRule = scoringRule;
    }

    public int score() {
        return scoringRule.score(roll);
    }

    public int ones() {
        return roll.sumDiceHaving(1);
    }

    public int twos() {
        return roll.sumDiceHaving(2);
    }

    public int threes() {
        return roll.sumDiceHaving(3);
    }

    public int fours() {
        return roll.sumDiceHaving(4);
    }

    public int fives() {
        return roll.sumDiceHaving(5);
    }

    public int sixes() {
        return roll.sumDiceHaving(6);
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

    public int yatzy() {
        if (roll.isYatzy()) {
            return 50;
        } else {
            return 0;
        }
    }

    public int onePair() {
        List<Integer> pairs = roll.getPairs();

        if (pairs.size() < 1) {
            return 0;
        }

        pairs.sort(Collections.reverseOrder());
        return pairs.get(0) * 2;
    }

    public int threeOfAKind() {
        Optional<Integer> threeOfAKind = roll.getThreeOfAKind();
        return threeOfAKind.map(threeOfAKindValue -> threeOfAKindValue * 3).orElse(0);
    }

    public int fourOfAKind() {
        Optional<Integer> fourOfAKind = roll.getFourOfAKind();
        return fourOfAKind.map(fourOfAKindValue -> fourOfAKindValue * 4).orElse(0);
    }

    public int twoPair() {
        List<Integer> pairs = roll.getPairs();
        if (pairs.size() < 2) {
            return 0;
        }

        return pairs.stream()
                .reduce(0, (accumulator, dieValue) -> accumulator + dieValue * 2);
    }

    public int fullHouse() {
        if (!roll.isFullHouse()) {
            return 0;
        }

        return roll.sumRollDice();
    }
}
