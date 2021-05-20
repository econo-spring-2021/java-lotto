package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<String> numbers;
    private LottoResult result;

    private static final int LOTTOE_PRICE = 1000;

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

    public static int getLottoPrice() {
        return LOTTOE_PRICE;
    }

    public List<String> getNumbers() { return numbers; }

    public void setResult(LottoResult result) {
        this.result = result;
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
