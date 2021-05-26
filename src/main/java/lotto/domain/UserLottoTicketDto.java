package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoTicketDto {
    private final List<LottoTicket> lottoTickets;

    public UserLottoTicketDto(List<LottoTicket> originUserLottoTickets) {
        lottoTickets = new ArrayList<>();
        Collections.copy(lottoTickets, originUserLottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
