package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void 로또_번호가_잘_들어가_있는지_확인() {
        LottoNumber lottoNumber = new LottoNumber(1);

        int expected = 1;
        int actual = lottoNumber.getNumber();

        assertThat(actual,is(equalTo(expected)));
    }

    @Test
    void 로또_번호_범위를_벗어날_경우_예외발생() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new LottoNumber(46));

        String message = exception.getMessage();

        assertThat("로또 번호의 범위는 1 ~ 45 사이의 수 입니다.",is(equalTo(message)));

    }

}