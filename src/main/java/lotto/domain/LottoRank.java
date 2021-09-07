package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    RANK_NO(0,0),
    RANK_FIVE(3, 5000),
    RANK_FOUR(4, 50000),
    RANK_THREE(5, 1500000),
    RANK_TWO(5, 30000000),
    RANK_ONE(6, 2000000000);

    private final Integer matchCount;
    private final Integer money;

    private LottoRank(Integer matchCount, Integer money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoRank of(Integer matchCount, boolean bonusMatch) {
        if(matchCount == 5 && bonusMatch) {
            return RANK_TWO;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(RANK_NO);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }
}
