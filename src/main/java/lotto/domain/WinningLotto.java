package lotto.domain;

import java.util.List;

public class WinningLotto extends LottoTicket{

    private final Integer bonusNumber;

    public WinningLotto(List<Integer> lottoNumber, Integer bonusNumber) {
        super(lottoNumber);

        validateNumberRange(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return super.numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
