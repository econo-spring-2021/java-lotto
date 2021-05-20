package lotto.controller;

import lotto.domain.UserAccount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    UserAccount userAccount;

    private static final int LOTTOE_PRICE = 1000;

    public void getUserMoney() {
        outputView.askMoney();
        userAccount = new UserAccount(inputView.getMoney());
    }

    public void generateUserLottoTicket() {
        int lotteCount = getBuyingTickeyCount();
        outputView.printBuyingLotteCount(lotteCount);
    }

    private int getBuyingTickeyCount() {
        return userAccount.getMoney() / LOTTOE_PRICE;
    }
}
