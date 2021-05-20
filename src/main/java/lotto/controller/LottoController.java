package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.UserAccount;
import lotto.domain.UserLottoTicket;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    UserAccount userAccount;
    UserLottoTicket userLottoTicket;
    WinningLotto winningLotto;

    public void getUserMoney() {
        OutputView.askMoney();
        userAccount = new UserAccount(inputView.getMoney());
    }

    public void generateUserLottoTicket() {
        int lottoCount = getBuyingTickeyCount();
        OutputView.printBuyingLotteCount(lottoCount);

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            tickets.add(new LottoTicket());
        }
        userLottoTicket = new UserLottoTicket(tickets);
        userLottoTicket.printLottoTickets();
    }

    private int getBuyingTickeyCount() {
        return userAccount.getMoney() / LottoTicket.getLottoPrice();
    }

    public void getWinningLotto() {
        LottoTicket ticket = new LottoTicket(inputView.getWinningLottoNumber());
        winningLotto = new WinningLotto(ticket, inputView.getBonusBall());
    }
}
