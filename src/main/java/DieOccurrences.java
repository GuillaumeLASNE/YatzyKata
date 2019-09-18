import java.util.Arrays;

public class DieOccurrences {

    private static final int OFFSET = 1;
    private final int[] dieOccurrences;

    public DieOccurrences(int[] dice, int dieFacesNumber) {
        this.dieOccurrences = new int[dieFacesNumber];
        Arrays.stream(dice).forEach(this::incrementDieOccurrence);
    }

    private void incrementDieOccurrence(int die) {
        dieOccurrences[die - OFFSET]++;
    }

    public int get(int dieValue) {
        return dieOccurrences[dieValue - OFFSET];
    }

}
