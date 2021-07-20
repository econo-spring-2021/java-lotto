package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    protected final List<Integer> numbers;
    private LottoResult result;

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_LENGTH = 6;
    public static final int LOTTO_SELLING_PRICE = 1000;

    public LottoTicket(List<Integer> numbers) {
        validateNumberCount(numbers);
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
        validateDuplicatedNumber(numbers);

        this.numbers = numbers;
    }

    public LottoTicket() {
        List<Integer> tempNumbers = new ArrayList<>();
        for (Integer i = 1; i <= 45; i++) {
            tempNumbers.add(i);
        }
        Collections.shuffle(tempNumbers);

        numbers = tempNumbers.subList(0, 6);
    }

    protected void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() > LOTTO_NUMBER_LENGTH)
            throw new LottoException("로또 번호의 갯수가 필요한 갯수보다 많습니다.");
        if (numbers.size() < LOTTO_NUMBER_LENGTH)
            throw new LottoException("로또 번호의 갯수가 필요한 갯수보다 적습니다.");
    }

    protected void validateNumberRange(Integer number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)
            throw new LottoException("올바르지 않은 범위의 로또 숫자가 존재합니다.");
    }

    protected void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count())
            throw new LottoException("중복되는 로또 번호가 있습니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoResult getResult() {
        return this.result;
    }


    public void setLottoResult(WinningLotto winningLotto) {
        result = LottoResult.getLottoResult(this, winningLotto);
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
        if (this.result == result) return 1;

        return 0;
    }
}
