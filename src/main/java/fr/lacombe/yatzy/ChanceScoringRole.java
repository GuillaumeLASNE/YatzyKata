package fr.lacombe.yatzy;

public class ChanceScoringRole implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return chance(roll);
    }

    private int chance(Roll roll) {
        return roll.sumRollDice();
    }
}
