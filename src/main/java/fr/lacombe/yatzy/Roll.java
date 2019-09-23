package fr.lacombe.yatzy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Roll {

    public static final int DIE_MIN_VALUE = 1;
    public static final int DIE_FACES_NUMBER = 6;

    private static final int OFFSET = 1;
    private final int[] dieOccurrences;

    public Roll(int[] dice) {
        this.dieOccurrences = new int[DIE_FACES_NUMBER];
        Arrays.stream(dice).forEach(this::incrementDieOccurrence);
    }

    public List<Integer> getPairs() {
        return IntStream.rangeClosed(DIE_MIN_VALUE, DIE_FACES_NUMBER)
                .filter(this::isPair)
                .boxed().collect(Collectors.toList());
    }

    public Optional<Integer> getThreeOfAKind() {
        return IntStream.rangeClosed(DIE_MIN_VALUE, DIE_FACES_NUMBER)
                .filter(this::isThreeOfAKind)
                .boxed().findAny();
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

    public boolean isYatzy() {
        return Arrays.stream(dieOccurrences).anyMatch(occurrence -> occurrence == 5);
    }

    public boolean isFullHouse() {
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        for (int dievalue = DIE_MIN_VALUE; dievalue <= DIE_FACES_NUMBER; dievalue++) {
            if (isThreeOfAKind(dievalue)) {
                hasThreeOfAKind = true;
            } else if (isPair(dievalue)) {
                hasPair = true;
            }
        }
        return hasThreeOfAKind && hasPair;
    }

    public int sumDiceHaving(int value) {
        return value * occurrence(value);
    }

    public int sumRollDice() {
        return IntStream.rangeClosed(DIE_MIN_VALUE, DIE_FACES_NUMBER)
                .map(this::sumDiceHaving)
                .sum();
    }

    private void incrementDieOccurrence(int die) {
        dieOccurrences[die - OFFSET]++;
    }

    private int occurrence(int dieValue) {
        return dieOccurrences[dieValue - OFFSET];
    }

    private boolean isPair(int dieValue) {
        return occurrence(dieValue) >= 2;
    }

    private boolean isThreeOfAKind(int dieValue) {
        return occurrence(dieValue) >= 3;
    }
}
