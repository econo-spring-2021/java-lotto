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
}
