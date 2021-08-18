package lotto.controller;


import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTicket;
import lotto.domain.WinnerTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;

public class GameController {
    UserLottoTicket userLottoTicket = new UserLottoTicket();
    WinnerTicket winnerTicket;

    public void lottoPurchase() {
        int lottoCount = 0;
        try {
            lottoCount = InputView.moneyInput();
        } catch (InvalidInputMoneyException e) {
            System.out.println(e.getMessage());
            lottoPurchase();
        }
        if (lottoCount > 0)
            OutputView.numberOfLottoShow(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            userLottoTicket.addLottoTicket();
            OutputView.lottoTicketNumberShow(userLottoTicket.getPurchasedLotto(i));
        }
    }

    public void winningBallInput() {
        try {
            winnerTicket = new WinnerTicket(new LottoTicket(InputView.wonNumberInput()), InputView.bonusBallInput());
        } catch (InvalidInputWonBallsException e) {
            System.out.println(e.getMessage());
            winningBallInput();
        }
    }

    public void lottoResultShow() {
        HashMap<LottoResult, Integer> resultStatistics = new HashMap<>();
//        OutputView.resultShow();
        for (int i = 0; i < userLottoTicket.getPurchasedLotto().size(); i++) {
            LottoResult output = LottoResult.lottoResultShow(winnerTicket, userLottoTicket.getPurchasedLotto().get(i));

        }
    }


}
