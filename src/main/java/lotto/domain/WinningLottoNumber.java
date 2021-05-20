package lotto.domain;

public class WinningLottoNumber {
    private final LottoTicket lottoTicket;
    private final int bonusNumber;

    public WinningLottoNumber(LottoTicket lottoTicket, int bonusNumber) {
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }
}
