import java.util.Arrays;

public class Yatzy {

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[3] = d4;
        dice[2] = d3;
        dice[4] = d5;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        int total = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    public static int yatzy(int... dice) {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die - 1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return sumSameDiceValues(1, d1, d2, d3, d4, d5);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return sumSameDiceValues(2, d1, d2, d3, d4, d5);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return sumSameDiceValues(3, d1, d2, d3, d4, d5);
    }

    private static int sumSameDiceValues(int value, int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == value) sum += value;
        if (d2 == value) sum += value;
        if (d3 == value) sum += value;
        if (d4 == value) sum += value;
        if (d5 == value) sum += value;
        return sum;
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

    private int sumDiceWithSameValueAs(int value, int[] dice) {
        return Arrays.stream(dice)
                .filter(die -> die == value)
                .sum();
    }

    public static int onePair(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = dieOccurrences(d1, d2, d3, d4, d5);
        int at;
        for (at = 0; at != 6; at++)
            if (tallies[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    public static int twoPair(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = dieOccurrences(d1, d2, d3, d4, d5);
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (tallies[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = dieOccurrences(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = dieOccurrences(d1, d2, d3, d4, d5);
        for (int i = 0; i < 6; i++)
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
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }

    private static int[] dieOccurrences(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies = new int[6];
        tallies[d1 - 1]++;
        tallies[d2 - 1]++;
        tallies[d3 - 1]++;
        tallies[d4 - 1]++;
        tallies[d5 - 1]++;
        return tallies;
    }
}
