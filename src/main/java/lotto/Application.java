package lotto;

import lotto.view.InputView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        int lottoMoney = InputView.moneyInput();
        int lottoTickets = InputView.ticketsNumberView(lottoMoney);
    }
}
