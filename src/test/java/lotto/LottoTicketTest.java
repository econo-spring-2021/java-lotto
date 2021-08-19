package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private LottoTicket lottoTicket;

    @Test
    @DisplayName("티켓이 생성될 때 번호 6개를 가지고 있는지")
    public void lottoSizeTest() {
        //given
        lottoTicket = new LottoTicket();
        //when

        //then
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("티켓이 생성될 때 로또 번호 범위가 1~45인지")
    public void lottoNumberRangeTest() {
        //given
        lottoTicket = new LottoTicket();
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
        lottoTicket = new LottoTicket();

        //when

        //then
        assertThat(lottoTicket.isBonusFlag()).isEqualTo(false);
    }
}