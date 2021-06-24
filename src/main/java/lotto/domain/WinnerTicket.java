package lotto.domain;

public class WinnerTicket {
    LottoTicket lottoTicket;
    int bonusBall;

    public WinnerTicket(LottoTicket lottoTicket, int bonusBall) {
        this.lottoTicket = lottoTicket;
        this.bonusBall = bonusBall;
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
