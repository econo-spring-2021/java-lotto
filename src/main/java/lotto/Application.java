package lotto;

import lotto.controller.Lotto;
import lotto.domain.LottoTicket;
import lotto.view.InputView;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        int lottoMoney = InputView.moneyInput();
        int lottoTicketsNumber = InputView.ticketsNumberView(lottoMoney);
        ArrayList<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i=0;i<lottoTicketsNumber;i++){
            lottoTickets.add(new LottoTicket(Lotto.setLottoNumbers(Lotto.setOriginalLottoNumbers())));
            InputView.lottoNumbersView(lottoTickets.get(i).getLottoNumbers());
        }

    }
}
