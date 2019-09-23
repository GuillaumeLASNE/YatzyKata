package fr.lacombe.yatzy;

public class Yatzy {

    private Roll roll;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        int[] dice = new int[5];
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
        return roll.sumDiceHaving(1);
    }

    public int twos() {
        return roll.sumDiceHaving(2);
    }

    public int threes() {
        return roll.sumDiceHaving(3);
    }

    public int fours() {
        return roll.sumDiceHaving(4);
    }

    public int fives() {
        return roll.sumDiceHaving(5);
    }

    public int sixes() {
        return roll.sumDiceHaving(6);
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
        for (int dieValue = 1; dieValue <= Roll.DIE_FACES_NUMBER; dieValue++) {
            if (roll.isFourOfAKind(dieValue)) {
                return dieValue * 4;
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
        if (roll.isFullHouse()) return roll.sumRollDice();
        else return 0;
    }

}
