package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoTicketsDto {
    private List<LottoTicket> lottoTickets;

    public UserLottoTicketsDto(List<LottoTicket> originUserLottoTickets) {
        lottoTickets = new ArrayList<>(originUserLottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
