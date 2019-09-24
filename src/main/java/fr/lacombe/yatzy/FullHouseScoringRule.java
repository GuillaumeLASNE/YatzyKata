package fr.lacombe.yatzy;

public class FullHouseScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        if (!roll.isFullHouse()) {
            return 0;
        }

        return roll.sumRollDice();
    }
}
