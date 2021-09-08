package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    void 당첨_통계들을_반환하는_show_메서드_테스트() {
        LottoResult lottoResult = new LottoResult();
        Map<LottoRank, Integer> winningStatistics = lottoResult.show(Arrays.asList(LottoRank.values()));

        assertEquals(winningStatistics.size(),6);
    }

    @Test
    void 수익률_계산_테스트() {
        Payment payment = new Payment(1000);
        LottoResult lottoResult = new LottoResult();
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.RANK_FIVE);
        lottoResult.show(lottoRanks);

        assertEquals(lottoResult.calculateTotalEarningRate(payment), 5.0);
    }
}