package fr.lacombe.yatzy;

import java.util.Arrays;

public class DieOccurrences {

    private static final int OFFSET = 1;
    private final int[] dieOccurrences;

    public DieOccurrences(int[] dice, int dieFacesNumber) {
        this.dieOccurrences = new int[dieFacesNumber];
        Arrays.stream(dice).forEach(this::incrementDieOccurrence);
    }

    boolean isPair(int dieValue) {
        return occurrence(dieValue) >= 2;
    }

    public boolean isThreeOfAKind(int dieValue) {
        return occurrence(dieValue) >= 3;
    }

    public boolean isFourOfAKind(int die) {
        return occurrence(die) >= 4;
    }

    public boolean isSmallStraight() {
        return dieOccurrences[0] == 1 &&
                dieOccurrences[1] == 1 &&
                dieOccurrences[2] == 1 &&
                dieOccurrences[3] == 1 &&
                dieOccurrences[4] == 1;
    }

    public boolean isLargeStraight() {
        return dieOccurrences[1] == 1 &&
                dieOccurrences[2] == 1 &&
                dieOccurrences[3] == 1 &&
                dieOccurrences[4] == 1 &&
                dieOccurrences[5] == 1;
    }

    private void incrementDieOccurrence(int die) {
        dieOccurrences[die - OFFSET]++;
    }

    private int occurrence(int dieValue) {
        return dieOccurrences[dieValue - OFFSET];
    }
}
