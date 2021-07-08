package lotto;

import lotto.domain.LottoException;
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
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        ticket.setLottoResult(winningLotto);
        int one = ticket.getOneIfResult(LottoResult.FIRST);

        Assertions.assertEquals(1, one);
    }

    @Test
    @DisplayName("티켓이 다른 당첨 결과에 대해 0을 반환하는지")
    void test_getOneIfResult_notResult() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        ticket.setLottoResult(winningLotto);
        int zero = ticket.getOneIfResult(LottoResult.SECOND);

        Assertions.assertEquals(0, zero);
    }

    @Test
    @DisplayName("많은 숫자 갯수를 가진 로또가 예외를 발생하는지")
    void test_lottoTicket_overCountNumberException() {
        LottoException exception = Assertions.assertThrows(LottoException.class,
                () -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)));

        String message = exception.getMessage();
        Assertions.assertEquals("로또 번호의 갯수가 필요한 갯수보다 많습니다.", message);
    }

    @Test
    @DisplayName("적은 숫자 갯수를 가진 로또가 예외를 발생하는지")
    void test_lottoTicket_underCountNumberException() {
        LottoException exception = Assertions.assertThrows(LottoException.class,
                () -> new LottoTicket(Arrays.asList(1, 2, 3)));

        String message = exception.getMessage();
        Assertions.assertEquals("로또 번호의 갯수가 필요한 갯수보다 적습니다.", message);
    }

    @Test
    @DisplayName("움수의 숫자를 가진 로또가 예외를 발생하는지")
    void test_lottoTicket_negativeNumberRangeException() {
        LottoException exception = Assertions.assertThrows(LottoException.class,
                () -> new LottoTicket(Arrays.asList(-1, 2, 3, 4, 5, 6)));

        String message = exception.getMessage();
        Assertions.assertEquals("올바르지 않은 범위의 로또 숫자가 존재합니다.", message);
    }

    @Test
    @DisplayName("45보다 큰 숫자를 가진 로또가 예외를 발생하는지")
    void test_lottoTicket_overNumberRangeException() {
        LottoException exception = Assertions.assertThrows(LottoException.class,
                () -> new LottoTicket(Arrays.asList(46, 2, 3, 4, 5, 6)));

        String message = exception.getMessage();
        Assertions.assertEquals("올바르지 않은 범위의 로또 숫자가 존재합니다.", message);
    }

    @Test
    @DisplayName("중복된 숫자를 가진 로또가 예외를 발생하는지")
    void test_lottoTicket_duplicatedNumberRangeException() {
        LottoException exception = Assertions.assertThrows(LottoException.class,
                () -> new LottoTicket(Arrays.asList(1, 1, 3, 4, 5, 6)));

        String message = exception.getMessage();
        Assertions.assertEquals("중복되는 로또 번호가 있습니다.", message);
    }

    @Test
    @DisplayName("움수의 보너스 번호를 가진 당첨 티켓이 예외를 발생하는지")
    void test_winningLottoTicket_negativeNumberRangeException() {
        LottoException exception = Assertions.assertThrows(LottoException.class,
                () -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), -1));

        String message = exception.getMessage();
        Assertions.assertEquals("올바르지 않은 범위의 로또 숫자가 존재합니다.", message);
    }

    @Test
    @DisplayName("45보다 큰 보너스 번호를 가진 당첨 티켓이 예외를 발생하는지")
    void test_winningLottoTicket_overNumberRangeException() {
        LottoException exception = Assertions.assertThrows(LottoException.class,
                () -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 46));

        String message = exception.getMessage();
        Assertions.assertEquals("올바르지 않은 범위의 로또 숫자가 존재합니다.", message);
    }
}
