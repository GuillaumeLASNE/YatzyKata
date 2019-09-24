package fr.lacombe.yatzy.scoring.rule;

import fr.lacombe.yatzy.Roll;

public interface ScoringRule {
    public int score(Roll roll);
}
