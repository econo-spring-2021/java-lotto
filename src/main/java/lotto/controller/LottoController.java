package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.UserAccount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    UserAccount userAccount;

    public void getUserMoney() {
        outputView.askMoney();
        userAccount = new UserAccount(inputView.getMoney());
    }

    public void generateUserLottoTicket() {
        int lottoCount = getBuyingTickeyCount();
        outputView.printBuyingLotteCount(lottoCount);

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            tickets.add(new LottoTicket());
        }
    }

    private int getBuyingTickeyCount() {
        return userAccount.getMoney() / LottoTicket.getLottoPrice();
    }
}
