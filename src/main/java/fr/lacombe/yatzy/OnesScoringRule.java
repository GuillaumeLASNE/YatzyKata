package fr.lacombe.yatzy;

public class OnesScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        return roll.sumDiceHaving(1);
    }
}
