package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoTicketTest {

    private LottoTicket ticket;

    @BeforeEach
    void initLottoTicket() {
        ticket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void test_getOneIfWinningNumberExists_exits() {
        int exist = ticket.getOneIfWinningNumberExists(1, 7);

        Assertions.assertEquals(1, exist);
    }

    @Test
    void test_getOneIfWinningNumberExists_notExits() {
        int notExist = ticket.getOneIfWinningNumberExists(8, 7);

        Assertions.assertEquals(0, notExist);
    }

    @Test
    void test_hasBonusNumber_true() {
        boolean has = ticket.hasBonusNumber(1);

        Assertions.assertTrue(has);
    }

    @Test
    void test_hasBonusNumber_false() {
        boolean notHas = ticket.hasBonusNumber(7);

        Assertions.assertFalse(notHas);
    }

    @Test
    void test_getOneIfResult_result() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        ticket.setLottoResult(winningLotto);
        int one = ticket.getOneIfResult(LottoResult.FIRST);

        Assertions.assertEquals(1, one);
    }

    @Test
    void test_getOneIfResult_notResult() {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        ticket.setLottoResult(winningLotto);
        int zero = ticket.getOneIfResult(LottoResult.SECOND);

        Assertions.assertEquals(0, zero);
    }
}
