package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.UserAccount;
import lotto.domain.UserLottoTickets;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {
    private UserAccount userAccount;
    private UserLottoTickets userLottoTicket;
    private WinningLotto winningLotto;

    public void getUserMoney() {
        OutputView.askUserMoney();
        userAccount = new UserAccount(InputView.getUserMoney());
    }

    public void getUserLotto() {
        userLottoTicket = new UserLottoTickets();

        int lottoCount = calculateBuyingTickeyCount();
        int manualLottoCount = getManualLottoCount();
        getManualLotto(manualLottoCount);

        int automaticCount = lottoCount - manualLottoCount;
        getAutomaticLotto(automaticCount);

        OutputView.printUserLottoTicket(manualLottoCount, automaticCount, userLottoTicket.getDto());
    }

    public int getManualLottoCount() {
        OutputView.askManualLottoCount();
        return InputView.getManualLottoCount();
    }

    public void getManualLotto(int manualCount) {
        OutputView.askManualLottoNumber();
        for (int i = 0; i < manualCount; i++) {
            userLottoTicket.addLottoTicket(new LottoTicket(InputView.getLotto()));
        }
    }

    public void getAutomaticLotto(int automaticCount) {
        for (int i = 0; i < automaticCount; i++) {
            userLottoTicket.addLottoTicket(new LottoTicket());
        }
    }

    private int calculateBuyingTickeyCount() {
        return (int) (userAccount.getMoney() / LottoTicket.LOTTO_SELLING_PRICE);
    }

    public void getWinningLotto() {
        OutputView.askWinningLottoNumber();
        LottoTicket ticket = new LottoTicket(InputView.getLotto());
        OutputView.askBonusNumber();
        winningLotto = new WinningLotto(ticket, InputView.getBonusBall());
    }

    public void calculateResult() {
        userLottoTicket.setLottosResult(winningLotto);
        userAccount.setIncome(userLottoTicket.getTotalPrice());
    }

    public void printLottoResult() {
        OutputView.printLottoResult(userLottoTicket);
        OutputView.printIncomeRate(userAccount.getIncomeRate());
    }
}
