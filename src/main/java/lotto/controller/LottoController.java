package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoController {
    private UserAccount userAccount;
    private UserLottoTickets userLottoTicket;
    private WinningLotto winningLotto;

    public void getUserMoney() {
        OutputView.askUserMoney();
        try {
            userAccount = new UserAccount(InputView.getUserMoney());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);

            getUserMoney();
        }
    }

    public void getUserLotto() {
        userLottoTicket = new UserLottoTickets();

        int lottoCount = calculateBuyingTickeyCount();
        int manualLottoCount = getManualLottoCount();
        for (int i = 0; i < manualLottoCount; i++) {
            getManualLotto();
        }

        int automaticCount = lottoCount - manualLottoCount;
        getAutomaticLotto(automaticCount);

        OutputView.printUserLottoTicket(manualLottoCount, automaticCount, userLottoTicket.getDto());
    }

    private int getManualLottoCount() {
        OutputView.askManualLottoCount();

        return InputView.getManualLottoCount();
        // 음수인지를 파악해야하는 간단하 예외파악을 적용해야 하지만, view나 controller에서 확인하기에는
        // domain의 속성이 노출되는 것 같습니다. 그렇다고 굳이 domain에 필요하지 않는 필드를 domain에 저장하여서
        // domain에서 예외를 파악하는 것도 이상한 것 같은데 어떻게 해야 할까요?
    }

    private void getManualLotto() {
        OutputView.askManualLottoNumber();

        try {
            userLottoTicket.addLottoTicket(new LottoTicket(InputView.getLotto()));
        } catch (LottoException e) {
            OutputView.printExceptionMessage(e);

            getManualLotto();
        }
    }

    private void getAutomaticLotto(int automaticCount) {
        for (int i = 0; i < automaticCount; i++) {
            userLottoTicket.addLottoTicket(new LottoTicket());
        }
    }

    private int calculateBuyingTickeyCount() {
        return (int) (userAccount.getMoney() / LottoTicket.LOTTO_SELLING_PRICE);
    }

    public void getWinningLotto() {
        try {
            OutputView.askWinningLottoNumber();
            List<Integer> lottoNumber = InputView.getLotto();
                    
            OutputView.askBonusNumber();
            int bonusNumber = InputView.getBonusNumber();

            winningLotto = new WinningLotto(lottoNumber, bonusNumber);
        } catch (LottoException e) {
            OutputView.printExceptionMessage(e);

            getWinningLotto();
        }
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
