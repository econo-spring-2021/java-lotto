package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.NotProperArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputTest {

    private final LottoController lottoController = new LottoController();
    private final InputView inputView = new InputView();

    @Test
    public void test_getMomoney_properInput() {
        Scanner scanner = new Scanner("5000");
        Long money = inputView.getMoney(scanner);

        Assertions.assertEquals(5000L, money);
    }

    @Test
    public void test_getMoney_exceptionInput() {
        Scanner scanner = new Scanner("abc");

        assertThatThrownBy(() -> inputView.getMoney(scanner))
                .isInstanceOf(NotProperArgumentException.class)
                .hasMessage("[Exception] 올바르지 않은 입력 형식입니다.");
    }

    @Test
    public void test_getWinningLottoNumbers_properInput() {
        Scanner scanner = new Scanner("1,2,3,4,5,6");
        List<String> lottoNumbers = inputView.getWinningLottoNumbers(scanner);

        Assertions.assertEquals(Arrays.asList("1","2","3","4","5","6"), lottoNumbers);
    }

    @Test
    public void test_getWinningLottoNumber_exceptionInput() {
        Scanner scanner = new Scanner("a,b,c,d,e,f");

        Assertions.assertThrows(NotProperArgumentException.class,
                () -> inputView.getWinningLottoNumbers(scanner));
    }

    @Test
    public void test_getWinningLottoNumber_exceptionInput2() {
        Scanner scanner = new Scanner("12.42.53,42");

        Assertions.assertThrows(NotProperArgumentException.class,
                () -> inputView.getWinningLottoNumbers(scanner));
    }

    @Test
    public void test_getBonusBall_properInput() {
        Scanner scanner = new Scanner("6");
        String ball = inputView.getBonusBall(scanner);

        Assertions.assertEquals("6", ball);
    }

    @Test
    public void test_getBonusBall_exceptionInput() {
        Scanner scanner = new Scanner("abc");

        Assertions.assertThrows(NotProperArgumentException.class, () -> inputView.getBonusBall(scanner));
    }
}
