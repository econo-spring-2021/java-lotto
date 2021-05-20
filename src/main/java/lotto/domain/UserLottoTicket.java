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

        if (count == 3) ticket.setResult(LottoResult.FIFTH);
        if (count == 4) ticket.setResult(LottoResult.FORTH);
        if (count == 5) ticket.setResult(LottoResult.THIRD);
        if (count == 5 && ticket.hasBonusNumber(winningLotto.getBonusNumber())) ticket.setResult(LottoResult.SECOND);
        if (count == 6) ticket.setResult(LottoResult.FIRST);
    }

    public Long getTotalPrice() {
        Long total = 0L;
        for (LottoTicket ticket : lottoTickets) {
            total += getLottoPrice(ticket);
        }

        return total;
    }

    private int getLottoPrice(LottoTicket ticket) {
        if (ticket.getResult() == LottoResult.FIFTH) return LottoTicket.FIFTH_LOTTO_PRICE;
        if (ticket.getResult() == LottoResult.FORTH) return LottoTicket.FORTH_LOTTO_PRICE;
        if (ticket.getResult() == LottoResult.THIRD) return LottoTicket.THIRD_LOTTO_PRICE;
        if (ticket.getResult() == LottoResult.SECOND) return LottoTicket.SECOND_LOTTO_PRICE;
        if (ticket.getResult() == LottoResult.FIRST) return LottoTicket.FIRST_LOTTO_PRICE;
        return 0;
    }

    public int getSpecificResultCount(LottoResult result) {
        int count = 0;
        for(LottoTicket ticket : lottoTickets) {
            count += ticket.getOneIfResult(result);
        }

        return count;
    }
}
