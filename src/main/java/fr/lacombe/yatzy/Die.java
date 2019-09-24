package fr.lacombe.yatzy;

public enum Die {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    Die(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Die valueOf(int value) {

        if (value < 1 || value > 6) {
            throw new IllegalArgumentException("Die value must be between 1 and 6");
        }

        switch (value) {
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            default:
                return SIX;
        }
    }
}
