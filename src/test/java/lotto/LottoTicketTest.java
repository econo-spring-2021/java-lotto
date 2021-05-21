package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoTicketTest {

    private LottoTicket ticket;

    @BeforeEach
    public  void initLottoTicket() {
        ticket = new LottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
    }

    @Test
    public void test_getOneIfWinningNumberExists_exits() {
        int exist = ticket.getOneIfWinningNumberExists("1", "7");

        Assertions.assertEquals(1, exist);
    }

    @Test
    public void test_getOneIfWinningNumberExists_notExits() {
        int notExist = ticket.getOneIfWinningNumberExists("8", "7");

        Assertions.assertEquals(0, notExist);
    }

    @Test
    public void test_hasBonusNumber_true() {
        boolean has = ticket.hasBonusNumber("1");

        Assertions.assertTrue(has);
    }

    @Test
    public void test_hasBonusNumber_false() {
        boolean notHas = ticket.hasBonusNumber("7");

        Assertions.assertFalse(notHas);
    }

    @Test
    public void test_getOneIfResult_result() {
        ticket.setResult(LottoResult.FIRST);
        int one = ticket.getOneIfResult(LottoResult.FIRST);

        Assertions.assertEquals(1, one);
    }

    @Test
    public void test_getOneIfResult_notResult() {
        ticket.setResult(LottoResult.FIRST);
        int zero = ticket.getOneIfResult(LottoResult.SECOND);

        Assertions.assertEquals(0, zero);
    }
}
