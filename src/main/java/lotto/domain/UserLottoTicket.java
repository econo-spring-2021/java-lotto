package lotto.domain;

import lotto.view.OutputView;

import java.util.List;

public class UserLottoTicket {
    private final List<LottoTicket> lottoTickets;

    public UserLottoTicket(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void printLottoTickets() {
        for (LottoTicket ticket : lottoTickets) {
            OutputView.printLottoTicket(ticket);
        }
    }

    public void checkLottosResult(WinningLotto winningLotto) {
        for (LottoTicket ticket : lottoTickets) {
            checkLottoResult(ticket, winningLotto);
        }
    }

    private void checkLottoResult(LottoTicket ticket, WinningLotto winningLotto) {
        int count = 0;
        for (String number : winningLotto.getNumbers()) {
            count += ticket.getOneIfWinningNumberExists(number, winningLotto.getBonusNumber());
        }

        if (count == 5 && ticket.hasBonusNumber(winningLotto.getBonusNumber())) ticket.setResult(LottoResult.SECOND);
        ticket.setResult(LottoResult.values()[count]);
    }
}
