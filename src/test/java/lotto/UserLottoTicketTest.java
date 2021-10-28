package lotto;

import lotto.domain.UserLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserLottoTicketTest {

    @Test
    @DisplayName("사용자들이 로또를 구매할 때 로또가 확실히 추가되는지")
    void addLottoTicketTest() {
        //given
        UserLottoTicket userLottoTicket = new UserLottoTicket();

        //when
<<<<<<< HEAD
        for (int i = 0; i < 10; i++)
            userLottoTicket.addAutoLottoTicket();
=======
        for(int i =0; i<10; i++)
            userLottoTicket.addAutoLottoTicket();

>>>>>>> 9bc58090828d2a10d16a69abd3a1d819abaa5353
        //then
        assertThat(userLottoTicket.getPurchasedLotto().size()).isEqualTo(10);
    }
}