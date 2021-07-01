package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoTicketTest {

    private LottoTicket ticket;

    @BeforeEach
    void initLottoTicket() {
        ticket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("티켓이 주어진 번호를 가지고 있는 경우, 1을 반환하는지")
    void test_getOneIfWinningNumberExists_exits() {
        int exist = ticket.getOneIfWinningNumberExists(1, 7);

        Assertions.assertEquals(1, exist);
    }

    @Test
    @DisplayName("티켓이 주어진 번호를 가지고 있지 않은 경우, 0을 반환하는지")
    void test_getOneIfWinningNumberExists_notExits() {
        int notExist = ticket.getOneIfWinningNumberExists(8, 7);

        Assertions.assertEquals(0, notExist);
    }

    @Test
    @DisplayName("티켓이 존재하는 보너스 번호에 대해 true를 반환하는지")
    void test_hasBonusNumber_true() {
        boolean has = ticket.hasBonusNumber(1);

        Assertions.assertTrue(has);
    }

    @Test
    @DisplayName("티켓이 존재하지 않은 보너스 번호에 대해 false를 반환하는지")
    void test_hasBonusNumber_false() {
        boolean notHas = ticket.hasBonusNumber(7);

        Assertions.assertFalse(notHas);
    }

    @Test
    @DisplayName("티켓이 일치하는 당첨 결과에 대해 1을 반환하는지")
    void test_getOneIfResult_result() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        ticket.setLottoResult(winningLotto);
        int one = ticket.getOneIfResult(LottoResult.FIRST);

        Assertions.assertEquals(1, one);
    }

    @Test
    @DisplayName("티켓이 다른 당첨 결과에 대해 0을 반환하는지")
    void test_getOneIfResult_notResult() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        ticket.setLottoResult(winningLotto);
        int zero = ticket.getOneIfResult(LottoResult.SECOND);

        Assertions.assertEquals(0, zero);
    }
}
