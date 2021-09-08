package lotto.controller;


import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTicket;
import lotto.domain.WinnerTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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

    public void resultStatisticsInit(LinkedHashMap<LottoResult, Integer> resultStatistics) {
        for(LottoResult result : LottoResult.values())
            resultStatistics.put(result, 0);
    }

    public LinkedHashMap<LottoResult, Integer> lottoResultShow() {
        LinkedHashMap<LottoResult, Integer> resultStatistics = new LinkedHashMap<>();
        resultStatisticsInit(resultStatistics);
        OutputView.resultSignalShow();

        for (int i = 0; i < userLottoTicket.getPurchasedLotto().size(); i++) {
            int lottoOutput = winnerTicket.lottoComparing(userLottoTicket.getPurchasedLotto().get(i));
            LottoResult lottoResult = LottoResult.lottoResultMatch(lottoOutput, userLottoTicket.getPurchasedLotto().get(i).isBonusFlag());
            int num = resultStatistics.get(lottoResult);
            resultStatistics.put(lottoResult, ++num);
        }
        List<Integer> results = new ArrayList<>(resultStatistics.values());
        OutputView.resultShow(results);

        return resultStatistics;
    }

    public int lottoPrizeCalculate(LinkedHashMap<LottoResult,Integer> resultStatistics){
        int money =0;
        for (LottoResult lottoResult : LottoResult.values()) {
            money += lottoResult.getMoney() * resultStatistics.get(lottoResult);
        }
        return money;
    }

    public void lottoBenefitShow(int income){
        int money = userLottoTicket.getPurchasedLotto().size() * 1000;
        double benefit = (double)income / money;
        OutputView.benefitShow(String.format("%.2f", benefit));
    }
}
