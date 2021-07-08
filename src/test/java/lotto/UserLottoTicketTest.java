package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UserLottoTicketTest {
    private UserLottoTickets userLottoTicket;

    @Test
    @DisplayName("당첨된 로또 티켓이 올바르게 유저 티켓의 촐 액수로 합계되는지")
    void test_getTotalPrice() {

        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));

        userLottoTicket = new UserLottoTickets();
        userLottoTicket.addLottoTicket(lottoTicket1);
        userLottoTicket.addLottoTicket(lottoTicket2);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 6);
        userLottoTicket.setLottosResult(winningLotto);

        Assertions.assertEquals(LottoResult.FIRST.getPrice() + LottoResult.SECOND.getPrice(), userLottoTicket.getTotalPrice());
    }
}
