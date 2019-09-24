package fr.lacombe.yatzy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Roll {

    private static final int LOWEST_DIE_FACE = 1;
    private static final int HIGHEST_DIE_FACE = 6;

    private static final int OFFSET = 1;

    private static final Roll SMALL_STRAIGHT = new Roll(new int[]{1, 2, 3, 4, 5});
    private static final Roll LARGE_STRAIGHT = new Roll(new int[]{2, 3, 4, 5, 6});

    private final int[] dieOccurrences;

    public Roll(int[] dice) {
        this.dieOccurrences = new int[HIGHEST_DIE_FACE];
        Arrays.stream(dice).forEach(this::incrementDieOccurrence);
    }

    public List<Integer> getPairs() {
        return IntStream.rangeClosed(LOWEST_DIE_FACE, HIGHEST_DIE_FACE)
                .filter(this::isPair)
                .boxed().collect(Collectors.toList());
    }

    public Optional<Integer> getThreeOfAKind() {
        return IntStream.rangeClosed(LOWEST_DIE_FACE, HIGHEST_DIE_FACE)
                .filter(this::isThreeOfAKind)
                .boxed().findAny();
    }

    public Optional<Integer> getFourOfAKind() {
        return IntStream.rangeClosed(LOWEST_DIE_FACE, HIGHEST_DIE_FACE)
                .filter(this::isFourOfAKind)
                .boxed().findAny();
    }

    public boolean isSmallStraight() {
        return SMALL_STRAIGHT.equals(this);
    }

    public boolean isLargeStraight() {
        return LARGE_STRAIGHT.equals(this);
    }

    public boolean isYatzy() {
        return Arrays.stream(dieOccurrences).anyMatch(occurrence -> occurrence == 5);
    }

    public boolean isFullHouse() {
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        for (int dieValue = LOWEST_DIE_FACE; dieValue <= HIGHEST_DIE_FACE; dieValue++) {
            if (isThreeOfAKind(dieValue)) {
                hasThreeOfAKind = true;
            } else if (isPair(dieValue)) {
                hasPair = true;
            }
        }
        return hasThreeOfAKind && hasPair;
    }

    public int sumDiceHaving(int value) {
        return value * occurrence(value);
    }

    public int sumRollDice() {
        return IntStream.rangeClosed(LOWEST_DIE_FACE, HIGHEST_DIE_FACE)
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

    @Override
    public String toString() {
        return "Roll{" +
                "dieOccurrences=" + Arrays.toString(dieOccurrences) +
                '}';
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
