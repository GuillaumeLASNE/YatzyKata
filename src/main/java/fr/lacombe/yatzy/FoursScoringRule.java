package fr.lacombe.yatzy;

public class FoursScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(4);
    }
}
