package lotto.domain;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 3_000_000),
    FIRST(6, 2_000_000_000),
    NOTHING(0,0);

    public int getMoney() {
        return money;
    }

    private final int match;
    private final int money;

    public int getMatch() {
        return match;
    }

    Rank(int match, int money) {
        this.match = match;
        this.money = money;
    }

}
