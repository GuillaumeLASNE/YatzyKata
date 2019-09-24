package fr.lacombe.yatzy;

public class ChanceScoringRole implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return roll.sumRollDice();
    }
}
