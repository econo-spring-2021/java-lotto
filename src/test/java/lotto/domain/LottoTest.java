package lotto.domain;

import lotto.view.Constants;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_생성_확인하기() {
        Lotto lotto = new Lotto();
        assertEquals(lotto.getLottoNumbers().size(), Lotto.SIZE_EXCEPT_BONUS_NUMBER);
    }

    @Test
    void 당첨_번호_입력시_로또_당첨_통계를_반환하는지_테스트() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        Lotto lotto = new Lotto(lottoNumbers);
        List<LottoNumber> winningLottoWithoutBonusBall = Stream.of(1, 2, 3, 4, 7, 8).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        LottoNumber bonusBall = new LottoNumber(9);
        WinningLotto winningLotto = new WinningLotto(winningLottoWithoutBonusBall, bonusBall);

        assertTrue(Arrays.asList(LottoRank.values()).contains(lotto.findLottoRank(winningLotto)));
    }

    @Test
    void 중복된_숫자를_입력한_경우_예외발생() {
        List<LottoNumber> duplicatedLottoNumbers = Stream.of(1,2,3,4,5,5).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Lotto(duplicatedLottoNumbers));

        String message= exception.getMessage();

        assertThat("중복된 로또 번호가 존재합니다.",is(equalTo(message)));
    }

    @Test
    void 로또_번호의_개수가_6개_미만일_경우_예외발생() {
        List<LottoNumber> lottoNumbersUnderSix = Stream.of(1,2,3).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new Lotto(lottoNumbersUnderSix));

        String message = exception.getMessage();

        assertThat("로또 번호의 개수는 " + Lotto.SIZE_EXCEPT_BONUS_NUMBER + "개 입니다.", is(equalTo(message)));
    }

}