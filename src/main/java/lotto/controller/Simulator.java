package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class Simulator {
    private InputView inputView;
    private Payment payment;
    private LottoTicket lottoTicket;
    private Lotto lotto;
    private LottoNumber bonusBall;
    private WinningLotto winningLotto;
    private LottoMachine lottoMachine;
    private int lottoCount;
    private List<LottoRank> lottoRanks;
    private LottoResult lottoResult;
    private Map<LottoRank, Integer> winningStatistics;
    private int manualLottoCount;
    private int autoLottoCount;

    public Simulator() {
        inputView = new InputView();
        payment = new Payment();
        lottoTicket = new LottoTicket();
        lottoResult = new LottoResult();
        lottoRanks = new ArrayList<>();
        lottoCount = 0;
        winningStatistics = new HashMap<>();
    }

    public void start() {
        inputMoneyProcess();
        lottoCount = payment.getMoney() / Lotto.PRICE;
        inputManualLottoCountProcess();
        autoLottoCount = lottoCount - manualLottoCount;
        OutputView.inputManualLottoMessage();
        lottoMachine = new LottoMachine(autoLottoCount, manualLottoCount, makeManualLottos(manualLottoCount));
        OutputView.printLottoCountMessage(manualLottoCount, autoLottoCount);
        printLottoTicketProcess(lottoMachine.getLottoTicket());
        inputWinningLottoProcess();
        inputBonusBallProcess();
        OutputView.printWinningStatistics();
        lottoRanks = lottoMachine.getLottoTicket().findLottoRanks(winningLotto);
        winningStatistics = lottoResult.show(lottoRanks);
        printLottoResultProcess(winningStatistics);
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

    private void inputManualLottoCountProcess() {
        OutputView.inputManualLottoCountMessage();
        manualLottoCount = inputView.inputManualLottoCount();
    }

    private List<Lotto> makeManualLottos(int manualLottoCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        for(int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(generateLotto(inputView.inputLottoNumbers()));
        }
        return manualLottos;
    }

    private Lotto generateLotto(List<LottoNumber> lottoNumbers) {
        try {
            return new Lotto(lottoNumbers);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return generateLotto(inputView.inputLottoNumbers());
        }
    }

    private void inputWinningLottoProcess() {
        try {
            OutputView.inputSixDigitNumbersMessage();
            lotto = new Lotto(inputView.inputLottoNumbers());
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

    private void printLottoTicketProcess(LottoTicket lottoTicket) {
        lottoTicket.getLottos().forEach((lotto) -> OutputView.printLottoTicketMessage(
                lotto.getLottoNumbers().get(0).getNumber(),
                lotto.getLottoNumbers().get(1).getNumber(),
                lotto.getLottoNumbers().get(2).getNumber(),
                lotto.getLottoNumbers().get(3).getNumber(),
                lotto.getLottoNumbers().get(4).getNumber(),
                lotto.getLottoNumbers().get(5).getNumber()));
    }

    private void printLottoResultProcess(Map<LottoRank, Integer> winningStatistics) {
        winningStatistics.forEach((rank, count) ->
                OutputView.printResult(rank.getMatchCount(),rank.getMoney(),count));
    }
}
