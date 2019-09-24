package fr.lacombe.yatzy;

public class ThreesScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(3);
    }
}
