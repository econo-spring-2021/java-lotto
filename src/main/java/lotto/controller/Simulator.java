package lotto.controller;

import lotto.domain.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Simulator {
    InputView inputView;
    Payment payment;

    public Simulator() {
        inputView = new InputView();
    }

    public void start() {
        inputMoney();
    }

    private void inputMoney() {
        try {
            OutputView.inputMoneyMessage();
            payment = new Payment(inputView.inputMoney());
        } catch(Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            inputMoney();
        }
    }
}
