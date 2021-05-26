package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTicket;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UserLottoTicketTest {
    private UserLottoTicket userLottoTicket;

    @Test
    void test_getTotalPrice() {

        List<LottoTicket> lottoTickets = new ArrayList<>();
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTickets.add(lottoTicket1);

        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
        lottoTickets.add(lottoTicket2);

        userLottoTicket = new UserLottoTicket(lottoTickets);
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7)), 6);
        userLottoTicket.setLottosResult(winningLotto);

        Assertions.assertEquals(LottoResult.FIRST_LOTTO_PRICE + LottoResult.SECOND_LOTTO_PRICE, userLottoTicket.getTotalPrice());
    }
}
