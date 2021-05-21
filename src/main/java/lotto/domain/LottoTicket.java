package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<String> numbers;
    private LottoResult result;

    public static final int LOTTO_NUMBER_LENGTH = 6;
    public static final int LOTTO_SELLING_PRICE = 1000;

    public static final Long FIFTH_LOTTO_PRICE = 5000L;
    public static final Long FORTH_LOTTO_PRICE = 50000L;
    public static final Long THIRD_LOTTO_PRICE = 1500000L;
    public static final Long SECOND_LOTTO_PRICE = 30000000L;
    public static final Long FIRST_LOTTO_PRICE = 2000000000L;

    public LottoTicket(List<String> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket() {
        List<String> tempNumbers = new ArrayList<>();
        for(int i = 1; i <= 45; i++) {
            tempNumbers.add(Integer.toString(i));
        }
        Collections.shuffle(tempNumbers);

        numbers = tempNumbers.subList(0, 6);
    }

    public List<String> getNumbers() { return numbers; }

    public void setResult(LottoResult result) {
        this.result = result;
    }

    public LottoResult getResult() {
        return this.result;
    }



    public int getOneIfWinningNumberExists(String winningNumber, String bonusNumber) {
        if (numbers.contains(winningNumber) && numbers.get(numbers.indexOf(winningNumber)) != bonusNumber) return 1;

        return 0;
    }

    public boolean hasBonusNumber(String bonusNumber) {
        if (numbers.contains(bonusNumber)) return true;

        return false;
    }

    public int getOneIfResult(LottoResult result) {
        if(this.result == result) return 1;

        return 0;
    }
}
