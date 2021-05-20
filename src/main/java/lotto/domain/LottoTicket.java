package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<String> numbers;

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

    public List<String> getNumbers() { return numbers; }

    public static int getLottoPrice() {
        return LOTTOE_PRICE;
    }
}
