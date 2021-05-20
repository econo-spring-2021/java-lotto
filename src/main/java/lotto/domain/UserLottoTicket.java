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

        System.out.println(count);
        if (count == 6) ticket.setResult(LottoResult.FIRST);
        if (count == 5 && ticket.hasBonusNumber(winningLotto.getBonusNumber())) ticket.setResult(LottoResult.SECOND);
        if (count == 5) ticket.setResult(LottoResult.THIRD);
        if (count == 4) ticket.setResult(LottoResult.FORTH);
        if (count == 3) ticket.setResult(LottoResult.FIFTH);
    }

    public int getSpecificResultCount(LottoResult result) {
        int count = 0;
        for(LottoTicket ticket : lottoTickets) {
            count += ticket.getOneIfResult(result);
        }

        return count;
    }
}
