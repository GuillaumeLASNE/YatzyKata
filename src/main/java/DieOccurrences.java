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

    private void incrementDieOccurrence(int die) {
        dieOccurrences[die - OFFSET]++;
    }

    private int occurrence(int dieValue) {
        return dieOccurrences[dieValue - OFFSET];
    }
}
