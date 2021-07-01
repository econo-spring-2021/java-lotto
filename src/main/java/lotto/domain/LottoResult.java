package lotto.domain;

public enum LottoResult {
    FIRST(6, 2000000000L), SECOND(7, 30000000L), THIRD(5, 1500000L), FORTH(4, 50000L), FIFTH(3,35000L), NONE(2, 0L);

    private int value;
    private Long price;

    LottoResult(int value, Long price) {
        this.value = value;
        this.price = price;
    }

    public Long getPrice() {
        return price;
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
        if (count == 6) return LottoResult.FIRST;
        return LottoResult.NONE;
    }
}
