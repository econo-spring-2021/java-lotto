package lotto;

import lotto.controller.InputException;
import lotto.controller.Lotto;
import lotto.domain.Calculation;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        int lottoMoney = InputView.moneyInput();
        lottoMoney = InputException.catchLottoMoneyException(lottoMoney);

        int manualTickets = InputView.manualTicketsInput();
        manualTickets = InputException.catchManualTicketsException(lottoMoney, manualTickets);

        ArrayList<LottoTicket> lottoTickets = new ArrayList<>();
        InputView.manualNumbersInputView();
        for (int i = 0; i < manualTickets; i++) {
            String manualNumbers = InputView.manualNumbersInput();
            manualNumbers = InputException.catchManualNumbersException(manualNumbers);
            lottoTickets.add(i, new LottoTicket(InputView.setNumbers(manualNumbers)));
        }

        int automaticTickets = Lotto.getAutomaticTickets(lottoMoney, manualTickets);
        InputView.ticketsCountView(manualTickets, automaticTickets);
        for (int i = manualTickets; i <= automaticTickets; i++) {
            lottoTickets.add(i, new LottoTicket(Lotto.setLottoNumbers(Lotto.setOriginalLottoNumbers())));
        }
        InputView.lottoTicketsNumbersView(lottoTickets);

        ArrayList<Integer> winNumber = InputView.setNumbers(InputException.catchWinningNumberException(InputView.winningNumberInput()));
        WinningNumber winningNumber = new WinningNumber(winNumber, InputException.catchBonusBallException(winNumber, InputView.bonusBallView()));

        OutputView.winningStatisticsView();
        Lotto.checkLottoTicketsMatchCount(lottoTickets, winningNumber);
        Calculation calculation = new Calculation();
        calculation.initResults();
        Lotto.calculateMatchResults(lottoTickets, calculation);

        OutputView.winningResultsView(calculation.getResults());
        OutputView.finalBenefitPercentView(calculation.getBenefitPercent(lottoMoney));
    }
}
