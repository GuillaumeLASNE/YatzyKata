package fr.lacombe.yatzy;

public class SmallStraightScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        if (roll.isSmallStraight()) {
            return 15;
        } else {
            return 0;
        }
    }
}
