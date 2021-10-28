package lotto.controller;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GameController {
    UserLottoTicket userLottoTicket = new UserLottoTicket();
    WinnerTicket winnerTicket;

    public void lottoPurchase() {
        int lottoCount = 0, autoLottoCount = 0, manualLottoCount = 0;
        try {
            lottoCount = InputView.moneyInput();
        } catch (InvalidInputMoneyException e) {
            System.out.println(e.getMessage());
            lottoPurchase();
        }
        manualLottoCount = InputView.manualLottoCountsInput();
        if (manualLottoCount > 0) {
            manualLottoPurchase(manualLottoCount);
        }
        autoLottoCount = lottoCount - manualLottoCount;
        for (int i = 0; i < autoLottoCount; i++) {
            userLottoTicket.addAutoLottoTicket();
        }
        purchaseLottoShow(manualLottoCount, autoLottoCount);
    }

    public LottoTicket manualLottoGenerate() {
        LottoTicket lottoTicket = null;
        try {
            lottoTicket = new LottoTicket(InputView.lottoNumberInput());
        } catch (InvalidInputLottoBallsException e) {
            System.out.println(e.getMessage());
            manualLottoGenerate();
        }
        return lottoTicket;
    }

    public void manualLottoPurchase(int manualLottoCount) {
        InputView.manualLottoInputMessageShow();
        for (int i = 0; i < manualLottoCount; i++) {
            userLottoTicket.addManualLottoTicket(manualLottoGenerate());
        }
    }

    public void purchaseLottoShow(int manualLottoCount, int AutoLottoCount) {
        int totalLottoCount = userLottoTicket.getPurchasedLotto().size();
        OutputView.numberOfLottoShow(manualLottoCount, AutoLottoCount);
        for (int i = 0; i < totalLottoCount; i++) {
            OutputView.lottoTicketNumberShow(userLottoTicket.getPurchasedLotto(i));
        }
    }

    public void winningBallInput() {
        try {
            InputView.wonLottoInputMessageShow();
            winnerTicket = new WinnerTicket(new LottoTicket(InputView.lottoNumberInput()), InputView.bonusBallInput());
        } catch (InvalidInputLottoBallsException e) {
            System.out.println(e.getMessage());
            winningBallInput();
        }
    }

    public void resultStatisticsInit(LinkedHashMap<LottoResult, Integer> resultStatistics) {
        for (LottoResult result : LottoResult.values())
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

    public int lottoPrizeCalculate(LinkedHashMap<LottoResult, Integer> resultStatistics) {
        int money = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            money += lottoResult.getMoney() * resultStatistics.get(lottoResult);
        }
        return money;
    }

    public void lottoBenefitShow(int income) {
        int money = userLottoTicket.getPurchasedLotto().size() * 1000;
        double benefit = (double) income / money;
        OutputView.benefitShow(String.format("%.2f", benefit));
    }
}