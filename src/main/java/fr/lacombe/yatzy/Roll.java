package fr.lacombe.yatzy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Roll {

    private static final int ROLL_SIZE = 5;
    private final int[] dice;
    private final Die[] roll;

    public Roll(int die1, int die2, int die3, int die4, int die5) {
        dice = new int[ROLL_SIZE];
        dice[0] = die1;
        dice[1] = die2;
        dice[3] = die4;
        dice[2] = die3;
        dice[4] = die5;
        roll = new Die[ROLL_SIZE];
        List<Integer> diceByDecreasingValues = Arrays.asList(die1, die2, die3, die4, die5);
        diceByDecreasingValues.sort(Collections.reverseOrder());
        for (int i = 0; i < roll.length; i++) {
            roll[i] = Die.of(diceByDecreasingValues.get(i));
        }
    }

    public int chance() {
        return Arrays.stream(roll)
                .map(Die::getValue)
                .reduce(0, Integer::sum);
    }

    public int yatzy() {
        return this.isYatzy() ? 50 : 0;
    }

    public int ones() {
        return sumDiceHaving(1);
    }

    public int twos() {
        return sumDiceHaving(2);
    }

    public int threes() {
        return sumDiceHaving(3);
    }

    public int fours() {
        return sumDiceHaving(4);
    }

    public int fives() {
        return sumDiceHaving(5);
    }

    public int sixes() {
        return sumDiceHaving(6);
    }

    public int onePair() {
        for (int i = 0; i < roll.length - 1; i++) {
            Die currentDie = roll[i];
            Die nextDie = roll[i + 1];
            if (currentDie.isPair(nextDie)) {
                return currentDie.getValue() * 2;
            }
        }
        return 0;
    }

    public int twoPair() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, Die.DIE_FACES_NUMBER);
        int score = 0;
        int numberOfPair = 0;

        for (int dieValue = 1; dieValue <= Die.DIE_FACES_NUMBER; dieValue++) {
            if (dieOccurrences.isPair(dieValue)) {
                numberOfPair++;
                score += dieValue * 2;
            }
        }

        if (numberOfPair == 2) return score;
        else return 0;
    }

    public int threeOfAKind() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, Die.DIE_FACES_NUMBER);
        for (int dieValue = 1; dieValue <= Die.DIE_FACES_NUMBER; dieValue++) {
            if (dieOccurrences.isThreeOfAKind(dieValue)) {
                return dieValue * 3;
            }
        }
        return 0;
    }

    public int fourOfAKind() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, Die.DIE_FACES_NUMBER);
        for (int die = 1; die <= Die.DIE_FACES_NUMBER; die++) {
            if (dieOccurrences.isFourOfAKind(die)) {
                return die * 4;
            }
        }
        return 0;
    }

    public int smallStraight() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, Die.DIE_FACES_NUMBER);
        if (dieOccurrences.isSmallStraight())
            return 15;
        return 0;
    }

    public int largeStraight() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, Die.DIE_FACES_NUMBER);
        if (dieOccurrences.isLargeStraight())
            return 20;
        return 0;
    }

    public int fullHouse() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, Die.DIE_FACES_NUMBER);
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        int score = 0;
        for (int die = 1; die <= Die.DIE_FACES_NUMBER; die++) {
            if (dieOccurrences.isThreeOfAKind(die)) {
                hasThreeOfAKind = true;
                score += die * 3;
            } else if (dieOccurrences.isPair(die)) {
                hasPair = true;
                score += die * 2;
            }
        }
        if (hasPair && hasThreeOfAKind) return score;
        else return 0;
    }

    private int sumDiceHaving(int value) {
        return Arrays.stream(roll)
                .filter(die -> die.hasValue(value))
                .map(Die::getValue)
                .reduce(0, Integer::sum);
    }

    private boolean isYatzy() {
        Die firstDie = roll[0];
        return Arrays.stream(roll).allMatch(firstDie::equals);
    }
}
