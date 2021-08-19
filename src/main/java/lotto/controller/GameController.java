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

    public static int lottoComparing(WinnerTicket winnerTicket, LottoTicket lottoTicket) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (winnerTicket.getLottoTicket().getLottoNumbers().get(i) == lottoTicket.getLottoNumbers().get(j))
                    lottoTicket.lottoWinIncrease();
            }
        }
        for (int i = 0; i < 6; i++) {
            if (lottoTicket.getLottoNumbers().get(i) == winnerTicket.getBonusBall()) {
                lottoTicket.lottoBonusCoincedence();
                break;
            }
        }
        return lottoTicket.getWinCount();
    }


    public int lottoResultShow() {
        LinkedHashMap<LottoResult, Integer> resultStatistics = new LinkedHashMap<>();
        resultStatistics.put(LottoResult.THREE_WIN, 0);
        resultStatistics.put(LottoResult.FOUR_WIN, 0);
        resultStatistics.put(LottoResult.FIVE_WIN, 0);
        resultStatistics.put(LottoResult.FIVE_BONUS_WIN, 0);
        resultStatistics.put(LottoResult.SIX_WIN, 0);
        resultStatistics.put(LottoResult.LOSE, 0);

        OutputView.resultSignalShow();
        for (int i = 0; i < userLottoTicket.getPurchasedLotto().size(); i++) {
            int lottoOutput = lottoComparing(winnerTicket, userLottoTicket.getPurchasedLotto().get(i));
            LottoResult lottoResult = LottoResult.lottoResultMatch(lottoOutput, userLottoTicket.getPurchasedLotto().get(i).isBonusFlag());
            int num = resultStatistics.get(lottoResult);
            resultStatistics.put(lottoResult, ++num);
        }
        List<Integer> results = new ArrayList<>(resultStatistics.values());
        OutputView.resultShow(results);

        int money =0;
        for (LottoResult lottoResult : LottoResult.values()) {
            money += lottoResult.getMoney() * resultStatistics.get(lottoResult);
        }
        return money;
    }


    public double lottoBenefitShow(int income){
        int money = userLottoTicket.getPurchasedLotto().size() * 1000;
        double benefit = (double)income / money;
        OutputView.benefitShow(String.format("%.2f", benefit));

        return benefit;
    }


}
