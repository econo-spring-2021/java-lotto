package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;

    private static final int LOTTOE_PRICE = 1000;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket() {
        List<Integer> tempNumbers = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            tempNumbers.add((int) Math.random() * 46);
        }
        numbers = tempNumbers;
    }

    public static int getLottoPrice() {
        return LOTTOE_PRICE;
    }
}
