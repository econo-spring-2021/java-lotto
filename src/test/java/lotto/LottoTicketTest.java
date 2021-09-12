package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {
    private LottoTicket lottoTicket;

    @Test
    @DisplayName("티켓이 생성될 때 번호 6개를 가지고 있는지")
    public void lottoSizeTest() {
        //given
        lottoTicket = LottoFactory.LottoAutoGenerate();
        //when

        //then
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("티켓이 생성될 때 로또 번호 범위가 1~45인지")
    public void lottoNumberRangeTest() {
        //given
        lottoTicket = LottoFactory.LottoAutoGenerate();
        boolean rangeOutFlag = false;

        //when
        for (int lottoNumber : lottoTicket.getLottoNumbers()) {
            if (lottoNumber > 45 || lottoNumber < 1)
                rangeOutFlag = true;
        }

        //then
        assertThat(rangeOutFlag).isEqualTo(false);
    }

    @Test
    @DisplayName("티켓마다 가지고 있는 보너스볼 일치 여부가 false로 초기화되어 있는지")
    public void lottoBonusFlagInit() {
        //given
        lottoTicket = LottoFactory.LottoAutoGenerate();

        //when

        //then
        assertThat(lottoTicket.isBonusFlag()).isEqualTo(false);
    }

    @Test
    @DisplayName("로또 번호 중복될 때 예외 발생하는지")
    public void DuplicatedLottoNumberExceptionTest(){
        //given
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(1);
        lottoNumbers.add(1);
        lottoNumbers.add(1);
        lottoNumbers.add(1);
        lottoNumbers.add(1);
        //when
        boolean exceptionFlag = false;
        try {
            LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        } catch (Exception e) {
            exceptionFlag = true;
        }
        //then
        assertThat(exceptionFlag).isEqualTo(true);

    }

    @Test
    @DisplayName("로또 번호 범위 벗어날 때 예외 발생하는지")
    public void InvalidRangeLottoNumberExceptionTest(){
        //given
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(48);
        //when
        boolean exceptionFlag = false;
        try {
            LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        } catch (Exception e) {
            exceptionFlag = true;
        }
        //then
        assertThat(exceptionFlag).isEqualTo(true);

    }
}