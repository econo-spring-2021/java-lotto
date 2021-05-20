package lotto.domain;

import java.util.List;

public class BuyingLottoTicket {
    private final List<LottoTicket> lottoTickets;

    public BuyingLottoTicket(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
}
