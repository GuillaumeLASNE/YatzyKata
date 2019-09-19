import java.util.Arrays;

public class Yatzy {

    private static final int DIE_FACES_NUMBER = 6;
    private int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[3] = d4;
        dice[2] = d3;
        dice[4] = d5;
    }

    public int chance() {
        return Arrays.stream(dice).sum();
    }

    public int yatzy() {
        return isYatzy(this.dice) ? 50 : 0;
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
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, DIE_FACES_NUMBER);
        for (int dieValue = DIE_FACES_NUMBER; dieValue >= 1; dieValue--) {
            if (dieOccurrences.isPair(dieValue)) {
                return dieValue * 2;
            }
        }
        return 0;
    }

    public int twoPair() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, DIE_FACES_NUMBER);
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
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, DIE_FACES_NUMBER);
        for (int dieValue = 1; dieValue <= DIE_FACES_NUMBER; dieValue++) {
            if (dieOccurrences.isThreeOfAKind(dieValue)) {
                return dieValue * 3;
            }
        }
        return 0;
    }

    public int fourOfAKind() {
        DieOccurrences dieOccurrences = new DieOccurrences(this.dice, DIE_FACES_NUMBER);
        for (int die = 1; die <= DIE_FACES_NUMBER; die++) {
            if (dieOccurrences.isFourOfAKind(die)) {
                return die * 4;
            }
        }
        return 0;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = dieOccurrences(d1, d2, d3, d4, d5);
        for (int i = 0; i < DIE_FACES_NUMBER; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = dieOccurrences(d1, d2, d3, d4, d5);
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = dieOccurrences(d1, d2, d3, d4, d5);
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = dieOccurrences(d1, d2, d3, d4, d5);
        boolean twoOfAKind = false;
        int twoOfAKindAt = 0;
        boolean threeOfAKind = false;
        int threeOfAKindAt = 0;

        int i;
        for (i = 0; i != DIE_FACES_NUMBER; i++) {
            if (tallies[i] == 2) {
                twoOfAKind = true;
                twoOfAKindAt = i + 1;
            }
        }

        for (i = 0; i != DIE_FACES_NUMBER; i++) {
            if (tallies[i] == 3) {
                threeOfAKind = true;
                threeOfAKindAt = i + 1;
            }
        }

        if (twoOfAKind && threeOfAKind)
            return twoOfAKindAt * 2 + threeOfAKindAt * 3;
        else
            return 0;
    }

    private static int[] dieOccurrences(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[DIE_FACES_NUMBER];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        return tallies;
    }

    private int sumDiceWithSameValueAs(int value, int[] dice) {
        return Arrays.stream(dice)
                .filter(die -> die == value)
                .sum();
    }

    private boolean isYatzy(int[] dice) {
        return Arrays.stream(dice).allMatch(die -> dice[0] == die);
    }
}
