package lotto;

import lotto.controller.GameController;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinnerTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {
    @Test
    @DisplayName("내가 산 로또 티켓과 지난 주 당첨 로또 티켓과 일치 횟수")
    void lottoComparing() {
        GameController gameController = new GameController();
        List<Integer> myLottos = new ArrayList<>();
        for (int i = 1; i <= 6; i++)
            myLottos.add(i);
        LottoTicket lottoTicket = new LottoTicket(myLottos);
        LottoTicket winnerLotto = new LottoTicket(myLottos);
        WinnerTicket winnerTicket = new WinnerTicket(winnerLotto, 45);
        assertThat(GameController.lottoComparing(winnerTicket, lottoTicket)).isEqualTo(6);
    }

    @Test
    @DisplayName("내가 산 로또 당첨 통계에 따른 상금이 정확한지")
    void lottoResultShow() {
        LinkedHashMap<LottoResult, Integer> resultStatistics = new LinkedHashMap<>();
        resultStatistics.put(LottoResult.THREE_WIN, 1);
        resultStatistics.put(LottoResult.FOUR_WIN, 1);
        resultStatistics.put(LottoResult.FIVE_WIN, 0);
        resultStatistics.put(LottoResult.FIVE_BONUS_WIN, 0);
        resultStatistics.put(LottoResult.SIX_WIN, 0);
        resultStatistics.put(LottoResult.LOSE, 0);

        int money =0;
        for (LottoResult lottoResult : LottoResult.values()) {
            money += lottoResult.getMoney() * resultStatistics.get(lottoResult);
        }
        assertThat(money).isEqualTo(55000);
    }
}