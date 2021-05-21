package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.UserAccount;
import lotto.domain.UserLottoTicket;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoController {
    private InputView inputView = new InputView();
    private Scanner scanner = new Scanner(System.in);
    private UserAccount userAccount;
    private UserLottoTicket userLottoTicket;
    private WinningLotto winningLotto;

    public void getUserMoney() {
        OutputView.askMoney();
        userAccount = new UserAccount(inputView.getMoney(scanner));
    }

    public void generateUserLottoTicket() {
        long lottoCount = getBuyingTickeyCount();
        OutputView.printBuyingLotteCount(lottoCount);

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            tickets.add(new LottoTicket());
        }
        userLottoTicket = new UserLottoTicket(tickets);
        userLottoTicket.printLottoTickets();
    }

    private long getBuyingTickeyCount() {
        return userAccount.getMoney() / LottoTicket.LOTTO_SELLING_PRICE;
    }

    public void getWinningLotto() {
        OutputView.askWinningLottoNumber();
        LottoTicket ticket = new LottoTicket(inputView.getWinningLottoNumbers(scanner));
        OutputView.askBonusNumber();
        winningLotto = new WinningLotto(ticket, inputView.getBonusBall(scanner));
    }

    public void calculateResult() {
        userLottoTicket.checkLottosResult(winningLotto);
        userAccount.setIncome(userLottoTicket.getTotalPrice());
    }

    public void printLottoResult() {
        OutputView.printLottoResult(userLottoTicket);
        OutputView.printIncomeRate(userAccount.getIncomeRate());
    }
}
