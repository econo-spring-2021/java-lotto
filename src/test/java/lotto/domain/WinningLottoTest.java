package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    void 당첨_로또_생성_확인하기() {
        List<LottoNumber> winningLottoNumbers = Stream.of(1,2,3,4,5,6).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        LottoNumber bonusBall = new LottoNumber(7);

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusBall);

        assertEquals(winningLotto.getLottoNumbers(),winningLottoNumbers);
        assertEquals(winningLotto.getBonusBall(), bonusBall);
    }

    @Test
    void 중복된_로또_번호가_있는지_확인하기() {
        List<LottoNumber> winningLottoNumbers = Stream.of(1,2,3,4,5,6).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        LottoNumber bonusBall = new LottoNumber(6);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> new WinningLotto(winningLottoNumbers, bonusBall));

        String message = exception.getMessage();

        assertThat("보너스 볼이 당첨 번호와 중복됩니다.",is(equalTo(message)));
    }


}