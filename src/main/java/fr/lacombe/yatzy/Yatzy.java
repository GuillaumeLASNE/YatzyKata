package fr.lacombe.yatzy;

import java.util.Arrays;

public class Yatzy {

    private int[] dice;
    private Roll roll;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[3] = d4;
        dice[2] = d3;
        dice[4] = d5;
        roll = new Roll(dice);
    }

    public int chance() {
        return roll.sumRollDice();
    }

    public int yatzy() {
        if (roll.isYatzy()) return 50;
        else return 0;
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
        for (int dieValue = Roll.DIE_FACES_NUMBER; dieValue >= 1; dieValue--) {
            if (roll.isPair(dieValue)) {
                return dieValue * 2;
            }
        }
        return 0;
    }

    public int twoPair() {
        int score = 0;
        int numberOfPair = 0;

        for (int dieValue = 1; dieValue <= Roll.DIE_FACES_NUMBER; dieValue++) {
            if (roll.isPair(dieValue)) {
                numberOfPair++;
                score += dieValue * 2;
            }
        }

        if (numberOfPair == 2) return score;
        else return 0;
    }

    public int threeOfAKind() {
        for (int dieValue = 1; dieValue <= Roll.DIE_FACES_NUMBER; dieValue++) {
            if (roll.isThreeOfAKind(dieValue)) {
                return dieValue * 3;
            }
        }
        return 0;
    }

    public int fourOfAKind() {
        for (int die = 1; die <= Roll.DIE_FACES_NUMBER; die++) {
            if (roll.isFourOfAKind(die)) {
                return die * 4;
            }
        }
        return 0;
    }

    public int smallStraight() {
        if (roll.isSmallStraight()) return 15;
        else return 0;
    }

    public int largeStraight() {
        if (roll.isLargeStraight()) return 20;
        else return 0;
    }

    public int fullHouse() {
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        int score = 0;
        for (int die = 1; die <= Roll.DIE_FACES_NUMBER; die++) {
            if (roll.isThreeOfAKind(die)) {
                hasThreeOfAKind = true;
                score += die * 3;
            } else if (roll.isPair(die)) {
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
}
