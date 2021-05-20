package lotto.controller;

import lotto.domain.UserAccount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    UserAccount userAccount;

    public void getUserMoney() {
        outputView.askMoney();
        userAccount = new UserAccount(inputView.getMoney());
    }
}
