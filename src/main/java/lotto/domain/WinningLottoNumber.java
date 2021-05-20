package lotto.domain;

public class WinningLottoNumber {
    private final LottoTicket lottoTicket;
    private final String bonusNumber;

    public WinningLottoNumber(LottoTicket lottoTicket, String bonusNumber) {
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }
}
