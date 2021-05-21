package lotto;

import lotto.controller.Lotto;
import lotto.domain.Calculation;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) throws IOException {
        int lottoMoney = InputView.moneyInput();
        int lottoTicketsNumber = InputView.ticketsNumberView(lottoMoney);
        ArrayList<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketsNumber; i++) {
            lottoTickets.add(i, new LottoTicket(Lotto.setLottoNumbers(Lotto.setOriginalLottoNumbers())));
            InputView.lottoNumbersView(lottoTickets.get(i).getLottoNumbers());
        }

        WinningNumber winningNumbers = new WinningNumber(InputView.winningNumberInput());
        winningNumbers.setBonusBall(InputView.bonusBallView(winningNumbers.getWinningNumbers()));

        OutputView.winningStatisticsView();
        Lotto.checkLottoTicketsMatchCount(lottoTickets, winningNumbers);

        Calculation calculation = new Calculation();
        calculation.initResults();
        Lotto.calculateMatchResults(lottoTickets, calculation);

        OutputView.winningResultsView(calculation.getResults());
        OutputView.finalBenefitPercentView(calculation.getBenefitPercent(lottoMoney));
    }
}
