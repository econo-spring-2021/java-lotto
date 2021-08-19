package lotto.domain;

public class WinnerTicket {
    private LottoTicket lottoTicket;
    private int bonusBall;

    public WinnerTicket(LottoTicket lottoTicket, int bonusBall) {
        this.lottoTicket = lottoTicket;
        this.bonusBall = bonusBall;
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
