package fr.lacombe.yatzy;

public class FivesScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(5);
    }
}
