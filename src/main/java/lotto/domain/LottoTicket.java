package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<String> numbers;
    private LottoResult result;

    public static final int LOTTO_SELLING_PRICE = 1000;
    public static final int FIFTH_LOTTO_PRICE = 5000;
    public static final int FORTH_LOTTO_PRICE = 50000;
    public static final int THIRD_LOTTO_PRICE = 1500000;
    public static final int SECOND_LOTTO_PRICE = 30000000;
    public static final int FIRST_LOTTO_PRICE = 2000000000;

    public LottoTicket(List<String> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket() {
        List<String> tempNumbers = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            tempNumbers.add(Integer.toString((int) (Math.random() * 46)));
        }
        numbers = tempNumbers;
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
