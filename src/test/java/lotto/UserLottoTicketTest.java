package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UserLottoTicketTest {
    private UserLottoTickets userLottoTicket;

    @Test
    void test_getTotalPrice() {

        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));

        userLottoTicket = new UserLottoTickets();
        userLottoTicket.addLottoTicket(lottoTicket1);
        userLottoTicket.addLottoTicket(lottoTicket2);
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7)), 6);
        userLottoTicket.setLottosResult(winningLotto);

        Assertions.assertEquals(LottoResult.FIRST_LOTTO_PRICE + LottoResult.SECOND_LOTTO_PRICE, userLottoTicket.getTotalPrice());
    }
}
