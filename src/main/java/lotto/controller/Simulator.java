package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Payment;
import lotto.view.Constants;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Simulator {
    private InputView inputView;
    private Payment payment;
    private LottoTicket lottoTicket;
    private int lottoCount;

    public Simulator() {
        inputView = new InputView();
        payment = new Payment();
        lottoTicket = new LottoTicket();
        lottoCount = 0;
    }

    public void start() {
        inputMoney();
        lottoCount = payment.getMoney() / Constants.LOTTO_PRICE;
        OutputView.printLottoCountMessage(lottoCount);
        generateAutoLottoTicket(lottoCount);
        OutputView.printLottoTicketMessage(lottoTicket, lottoCount);
    }

    private void inputMoney() {
        try {
            OutputView.inputMoneyMessage();
            payment = new Payment(inputView.inputMoney());
        } catch(Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            inputMoney();
        }
    }

    private void generateAutoLottoTicket(int lottoCount) {
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottoTicket.add(lotto);
        }
    }
}
