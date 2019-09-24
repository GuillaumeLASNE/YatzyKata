package fr.lacombe.yatzy;

public class SixesScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(6);
    }
}
