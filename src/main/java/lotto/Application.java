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
import java.util.HashMap;

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
        for (int i = 0; i < automaticTickets; i++) {
            lottoTickets.add(i, new LottoTicket(Lotto.setLottoNumbers(Lotto.setOriginalLottoNumbers())));
            InputView.lottoNumbersView(lottoTickets.get(i).getLottoNumbers());
        }

        WinningNumber winningNumber = new WinningNumber(InputView.setNumbers(InputException.catchWinningNumberException(InputView.winningNumberInput())));
        int bonusBall = InputException.catchBonusBallException(winningNumber.getWinningNumbers(), InputView.bonusBallView());
        winningNumber.setBonusBall(bonusBall);

        OutputView.winningStatisticsView();
        Lotto.checkLottoTicketsMatchCount(lottoTickets, winningNumber);
        Calculation calculation = new Calculation();
        calculation.initResults();
        Lotto.calculateMatchResults(lottoTickets, calculation);

        OutputView.winningResultsView(calculation.getResults());
        OutputView.finalBenefitPercentView(calculation.getBenefitPercent(lottoMoney));
    }
}
