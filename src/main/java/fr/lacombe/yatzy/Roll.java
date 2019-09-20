package fr.lacombe.yatzy;

import java.util.Arrays;

public class Roll {

    private static final int ROLL_SIZE = 5;
    private final int[] dice;
    private final Die[] roll;


    public Roll(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[ROLL_SIZE];
        dice[0] = d1;
        dice[1] = d2;
        dice[3] = d4;
        dice[2] = d3;
        dice[4] = d5;
        roll = new Die[ROLL_SIZE];
        roll[0] = Die.of(d1);
        roll[1] = Die.of(d2);
        roll[3] = Die.of(d4);
        roll[2] = Die.of(d3);
        roll[4] = Die.of(d5);
    }

    public int chance() {
        return Arrays.stream(roll).map(Die::getValue).reduce(0, Integer::sum);
    }

    public int yatzy() {
        return isYatzy(roll) ? 50 : 0;
    }

    public int ones() {
        return sumDiceWithSameValueAs(1, this.dice);
    }

    public int twos() {
        return sumDiceWithSameValueAs(2, this.dice);
    }

    public int threes() {
        return sumDiceWithSameValueAs(3, this.dice);
    }

    public int fours() {
        return sumDiceWithSameValueAs(4, this.dice);
    }

    public int fives() {
        return sumDiceWithSameValueAs(5, this.dice);
    }

    public int sixes() {
        return sumDiceWithSameValueAs(6, this.dice);
    }

    public int onePair() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, Die.DIE_FACES_NUMBER);
        for (int dieValue = Die.DIE_FACES_NUMBER; dieValue >= 1; dieValue--) {
            if (dieOccurrences.isPair(dieValue)) {
                return dieValue * 2;
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

    private int sumDiceWithSameValueAs(int value, int[] dice) {
        return Arrays.stream(dice)
                .filter(die -> die == value)
                .sum();
    }

    private boolean isYatzy(Die[] roll) {
        return Arrays.stream(roll).allMatch(die -> roll[0].equals(die));
    }
}
