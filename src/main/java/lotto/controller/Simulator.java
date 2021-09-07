package lotto.controller;

import lotto.domain.*;
import lotto.view.Constants;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulator {
    private InputView inputView;
    private Payment payment;
    private LottoTicket lottoTicket;
    private Lotto lotto;
    private LottoNumber bonusBall;
    private WinningLotto winningLotto;
    private int lottoCount;
    private List<LottoRank> lottoRanks;
    private LottoResult lottoResult;

    public Simulator() {
        inputView = new InputView();
        payment = new Payment();
        lottoTicket = new LottoTicket();
        lottoResult = new LottoResult();
        lottoRanks = new ArrayList<>();
        lottoCount = 0;
    }

    public void start() {
        inputMoneyProcess();
        lottoCount = payment.getMoney() / Constants.LOTTO_PRICE;
        OutputView.printLottoCountMessage(lottoCount);
        generateAutoLottoTicket(lottoCount);
        OutputView.printLottoTicketMessage(lottoTicket, lottoCount);
        inputWinningLottoProcess();
        inputBonusBallProcess();
        OutputView.printWinningStatistics();
        lottoRanks = lottoTicket.findLottoRanks(winningLotto);
        OutputView.printResult(lottoResult.show(lottoRanks));
        OutputView.printEarningRate(lottoResult.calculateTotalEarningRate(payment));
    }

    private void inputMoneyProcess() {
        try {
            OutputView.inputMoneyMessage();
            payment = new Payment(inputView.inputMoney());
        } catch(Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            inputMoneyProcess();
        }
    }

    private void generateAutoLottoTicket(int lottoCount) {
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottoTicket.add(lotto);
        }
    }

    private void inputWinningLottoProcess() {
        try {
            OutputView.inputSixDigitNumbersMessage();
            lotto = new Lotto(inputView.inputWinningLottoNumbers());
        } catch(Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            inputWinningLottoProcess();
        }
    }

    private void inputBonusBallProcess() {
        try {
            OutputView.inputBonusNumberMessage();
            bonusBall = new LottoNumber(inputView.inputBonusBallNumber());
            winningLotto = new WinningLotto(lotto.getLottoNumbers(), bonusBall);
        } catch(Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            inputBonusBallProcess();
        }
    }
}
