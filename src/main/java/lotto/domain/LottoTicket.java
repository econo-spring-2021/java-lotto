package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;
    private LottoResult result;

    public static final int LOTTO_NUMBER_LENGTH = 6;
    public static final int LOTTO_SELLING_PRICE = 1000;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket() {
        List<Integer> tempNumbers = new ArrayList<>();
        for(Integer i = 1; i <= 45; i++) {
            tempNumbers.add(i);
        }
        Collections.shuffle(tempNumbers);

        numbers = tempNumbers.subList(0, 6);
    }

    public List<Integer> getNumbers() { return numbers; }

    public void setLottoResult(WinningLotto winningLotto) {
        result = LottoResult.getLottoResult(this, winningLotto);
    }

    public LottoResult getResult() {
        return this.result;
    }

    public int getOneIfWinningNumberExists(Integer winningNumber, Integer bonusNumber) {
        if (numbers.contains(winningNumber) && numbers.get(numbers.indexOf(winningNumber)) != bonusNumber) return 1;

        return 0;
    }

    public boolean hasBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) return true;

        return false;
    }

    public int getOneIfResult(LottoResult result) {
        if(this.result == result) return 1;

        return 0;
    }
}
