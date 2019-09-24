package fr.lacombe.yatzy;

public class TwosScoringRule implements ScoringRule {

    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(2);
    }
}
