package lotto.controller;


import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTicket;
import lotto.domain.WinnerTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    UserLottoTicket userLottoTicket = new UserLottoTicket();
    WinnerTicket winnerTicket;

    public void lottoPurchase(){
        int lottoCount = InputView.moneyInput();
        OutputView.numberOfLottoShow(lottoCount);
        for (int i=0; i<lottoCount; i++){
            userLottoTicket.addLottoTicket();
            OutputView.lottoTicketNumberShow(userLottoTicket.getPurchasedLotto(i));
        }
    }

    public void winningBallInput(){
        winnerTicket = new WinnerTicket(new LottoTicket(InputView.wonNumberInput()),InputView.bonusBallInput());
    }


}
