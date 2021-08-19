package lotto.domain;

public enum LottoResult {
    THREE_WIN(3, 5000), FOUR_WIN(4, 50000), FIVE_WIN(5, 1500000), FIVE_BONUS_WIN(5, 30000000),
    SIX_WIN(6, 2000000000), LOSE(0, 0);

    private int count;
    private int money;

    LottoResult(int count, int money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }


    public static LottoResult lottoResultMatch(int coincedenceCount, boolean bonusBallFlag) {
        for (LottoResult result : LottoResult.values()) {
            if (coincedenceCount == 5 && bonusBallFlag)
                return LottoResult.FIVE_BONUS_WIN;
            if (coincedenceCount == result.getCount())
                return result;
        }
        return LottoResult.LOSE;
    }
}
