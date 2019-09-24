package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;

import java.util.Optional;

public class FourOfAKindScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        Optional<Integer> fourOfAKind = roll.getFourOfAKind();
        return fourOfAKind.map(fourOfAKindValue -> fourOfAKindValue * 4).orElse(0);
    }
}
