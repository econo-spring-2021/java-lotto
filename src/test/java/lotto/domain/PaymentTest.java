package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    @Test
    void 값이_잘_들어가_있는지_확인() {
        Payment payment = new Payment(1000);

        int expected = 1000;
        int actual = payment.getMoney();

        assertThat(actual,is(equalTo(expected)));
    }

    @Test
    void 값이_1000원_미만_일_경우_예외발생() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Payment(900));

        String message= exception.getMessage();

        assertThat("로또 구입 금액은 최소 1000원 입니다.", is(equalTo(message)));
    }
}