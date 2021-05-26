package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoTicket lottoTicket;
    private final Integer bonusNumber;

    public WinningLotto(LottoTicket lottoTicket, Integer bonusNumber) {
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return lottoTicket.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
