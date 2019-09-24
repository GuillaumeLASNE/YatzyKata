package fr.lacombe.yatzy;

public class YatzyScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return yatzy(roll);
    }

    private int yatzy(Roll roll) {
        if (roll.isYatzy()) {
            return 50;
        } else {
            return 0;
        }
    }
}
