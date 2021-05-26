package lotto.domain;

public enum LottoResult {
    FIRST(6), SECOND(7), THIRD(5), FORTH(4), FIFTH(3);

    public static final Long FIFTH_LOTTO_PRICE = 5000L;
    public static final Long FORTH_LOTTO_PRICE = 50000L;
    public static final Long THIRD_LOTTO_PRICE = 1500000L;
    public static final Long SECOND_LOTTO_PRICE = 30000000L;
    public static final Long FIRST_LOTTO_PRICE = 2000000000L;

    private int value;

    LottoResult(int value) {
        this.value = value;
    }

    public static LottoResult getLottoResult(LottoTicket ticket, WinningLotto winningLotto) {
        int count = 0;
        for (Integer number : winningLotto.getNumbers()) {
            count += ticket.getOneIfWinningNumberExists(number, winningLotto.getBonusNumber());
        }

        if (count == 3) return LottoResult.FIFTH;
        if (count == 4) return LottoResult.FORTH;
        if (count == 5 && ticket.hasBonusNumber(winningLotto.getBonusNumber())) return LottoResult.SECOND;
        if (count == 5) return LottoResult.THIRD;
        return LottoResult.FIRST;
    }
}
