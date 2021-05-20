package lotto.domain;

public class WinningLotto {
    private final LottoTicket lottoTicket;
    private final String bonusNumber;

    public WinningLotto(LottoTicket lottoTicket, String bonusNumber) {
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }
}
