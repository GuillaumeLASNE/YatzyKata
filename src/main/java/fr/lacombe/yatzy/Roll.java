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
    private static final Roll smallStraight = new Roll(new int[]{1, 2, 3, 4, 5});
    private static final Roll largeStraight = new Roll(new int[]{2, 3, 4, 5, 6});

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

    public Optional<Integer> getFourOfAKind() {
        return IntStream.rangeClosed(DIE_MIN_VALUE, DIE_FACES_NUMBER)
                .filter(this::isFourOfAKind)
                .boxed().findAny();
    }

    public boolean isSmallStraight() {
        return smallStraight.equals(this);
    }

    public boolean isLargeStraight() {
        return largeStraight.equals(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roll)) return false;
        Roll roll = (Roll) o;
        return Arrays.equals(dieOccurrences, roll.dieOccurrences);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dieOccurrences);
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

    private boolean isFourOfAKind(int die) {
        return occurrence(die) >= 4;
    }
}
