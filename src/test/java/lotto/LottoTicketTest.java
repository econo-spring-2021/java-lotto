package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private static LottoTicket lottoTicket;

    @BeforeAll
    public static void setLottoTicket(){
        ArrayList<Integer> testNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket = new LottoTicket(testNumbers);
        lottoTicket.setMatchCount(2);
        lottoTicket.setBonusball(true);
    }

    @DisplayName("getLottoNumbers 테스트")
    @Test
    public void getLottoNumbersTest(){
        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("getMatchCount 테스트")
    @Test
    public void getMatchCountTest(){
        assertThat(lottoTicket.getMatchCount()).isEqualTo(2);
    }

    @DisplayName("isBonusBall 테스트")
    @Test
    public void isBonusBallTest(){
        assertThat(lottoTicket.isBonusball()).isEqualTo(true);
    }
}
