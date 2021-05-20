package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoTicket lottoTicket;
    private final String bonusNumber;

    public WinningLotto(LottoTicket lottoTicket, String bonusNumber) {
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public List<String> getNumbers() {
        return lottoTicket.getNumbers();
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
