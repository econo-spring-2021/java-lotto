package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @Test
    void 등수를_올바르게_출력하는지_테스트() {
        LottoRank lottoRank = LottoRank.of(3, false);
        assertEquals(LottoRank.RANK_FIVE.toString(), lottoRank.name());
    }

}