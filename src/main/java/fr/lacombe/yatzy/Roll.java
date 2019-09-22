package fr.lacombe.yatzy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Roll {

    private static final int DIE_FACES_NUMBER = 6;
    private int[] roll;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        roll = new int[5];
        roll[0] = d1;
        roll[1] = d2;
        roll[3] = d4;
        roll[2] = d3;
        roll[4] = d5;
    }

    public int chance() {
        return Arrays.stream(roll).sum();
    }

    public int yatzy() {
        return this.isYatzy() ? 50 : 0;
    }

    public int ones() {
        return sumDiceWithSameValueAs(1, this.roll);
    }

    public int twos() {
        return sumDiceWithSameValueAs(2, this.roll);
    }

    public int threes() {
        return sumDiceWithSameValueAs(3, this.roll);
    }

    public int fours() {
        return sumDiceWithSameValueAs(4, this.roll);
    }

    public int fives() {
        return sumDiceWithSameValueAs(5, this.roll);
    }

    public int sixes() {
        return sumDiceWithSameValueAs(6, this.roll);
    }

    public int onePair() {
        List<Integer> decreasingOrderRoll = getDiceByDecreasingOrder();
        int offsetForPair = 1;

        for (int i = 0; i < decreasingOrderRoll.size() - offsetForPair; i++) {
            int currentDie = decreasingOrderRoll.get(i);
            int nextDie = decreasingOrderRoll.get(i + offsetForPair);

            if (currentDie == nextDie) {
                return currentDie + nextDie;
            }
        }
        return 0;
    }

    public int twoPair() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.roll, DIE_FACES_NUMBER);
        int score = 0;
        int numberOfPair = 0;

        for (int dieValue = 1; dieValue <= DIE_FACES_NUMBER; dieValue++) {
            if (dieOccurrences.isPair(dieValue)) {
                numberOfPair++;
                score += dieValue * 2;
            }
        }

        if (numberOfPair == 2) return score;
        else return 0;
    }

    public int threeOfAKind() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.roll, DIE_FACES_NUMBER);
        for (int dieValue = 1; dieValue <= DIE_FACES_NUMBER; dieValue++) {
            if (dieOccurrences.isThreeOfAKind(dieValue)) {
                return dieValue * 3;
            }
        }
        return 0;
    }

    public int fourOfAKind() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.roll, DIE_FACES_NUMBER);
        for (int die = 1; die <= DIE_FACES_NUMBER; die++) {
            if (dieOccurrences.isFourOfAKind(die)) {
                return die * 4;
            }
        }
        return 0;
    }

    public int smallStraight() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.roll, DIE_FACES_NUMBER);
        if (dieOccurrences.isSmallStraight())
            return 15;
        return 0;
    }

    public int largeStraight() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.roll, DIE_FACES_NUMBER);
        if (dieOccurrences.isLargeStraight())
            return 20;
        return 0;
    }

    public int fullHouse() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.roll, DIE_FACES_NUMBER);
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        int score = 0;
        for (int die = 1; die <= DIE_FACES_NUMBER; die++) {
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

    private boolean isYatzy() {
        return Arrays.stream(roll).allMatch(die -> roll[0] == die);
    }

    private List<Integer> getDiceByDecreasingOrder() {
        return Arrays.stream(roll)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }
}
