package fr.lacombe.yatzy;

import java.util.Optional;

public class ThreeOfAKindScoringRule implements ScoringRule {
    @Override
    public int score(Roll roll) {
        Optional<Integer> threeOfAKind = roll.getThreeOfAKind();
        return threeOfAKind.map(threeOfAKindValue -> threeOfAKindValue * 3).orElse(0);
    }
}
