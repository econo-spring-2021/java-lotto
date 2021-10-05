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
    private List<LottoNumber> lottoNumbers;
    private WinningLotto winningLotto;
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
        inputManualLottoProcess(manualLottoCount);
        generateAutoLottoTicket(autoLottoCount);
        OutputView.printLottoCountMessage(manualLottoCount, autoLottoCount);
        printLottoTicketProcess(lottoTicket);
        inputWinningLottoProcess();
        inputBonusBallProcess();
        OutputView.printWinningStatistics();
        lottoRanks = lottoTicket.findLottoRanks(winningLotto);
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

    private void inputManualLottoProcess(int manualLottoCount) {
        OutputView.inputManualLottoMessage();
        for(int i = 0; i < manualLottoCount; i++) {
            lottoTicket.add(generateLotto(inputView.inputLottoNumbers()));
        }
    }

    private Lotto generateLotto(List<LottoNumber> lottoNumbers) {
        try {
            return new Lotto(lottoNumbers);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return generateLotto(inputView.inputLottoNumbers());
        }
    }

    private void generateAutoLottoTicket(int lottoCount) {
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(generateAutoLottoNumbers());
            lottoTicket.add(lotto);
        }
    }

    private List<LottoNumber> generateAutoLottoNumbers() {
        List<LottoNumber> lottoNumberRange = new ArrayList<LottoNumber>();
        for (int i = LottoNumber.MINIMUM_VALUE; i <= LottoNumber.MAXIMUM_VALUE; i++) {
            lottoNumberRange.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumberRange);
        lottoNumbers = lottoNumberRange.subList(0, 6);
        return lottoNumbers;
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
