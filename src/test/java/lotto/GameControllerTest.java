package lotto;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {
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

        int money = 0;
        for (LottoResult lottoResult : LottoResult.values()) {
            money += lottoResult.getMoney() * resultStatistics.get(lottoResult);
        }
        assertThat(money).isEqualTo(55000);
    }
}