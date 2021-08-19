package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WinnerTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTicketTest {

    @Test
    @DisplayName("입력된 당첨 번호대로 지난 주 로또 당첨 티켓이 생성되는지")
    void getWonLottoTicketTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1; i<12; i+=2)
            arrayList.add(i);

        LottoTicket lottoTicket = new LottoTicket(arrayList);
        WinnerTicket winnerTicket = new WinnerTicket(lottoTicket,45);

        assertThat(winnerTicket.getLottoTicket()).isEqualTo(lottoTicket);
    }

    @Test
    void getBonusBallTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1; i<12; i+=2)
            arrayList.add(i);

        LottoTicket lottoTicket = new LottoTicket(arrayList);
        WinnerTicket winnerTicket = new WinnerTicket(lottoTicket,45);

        assertThat(winnerTicket.getBonusBall()).isEqualTo(45);
    }
}