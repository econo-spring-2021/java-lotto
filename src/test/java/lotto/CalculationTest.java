package lotto;

import lotto.domain.Calculation;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTest {
    private static Calculation calculation;
    private static int lottoMoney;

    @BeforeAll
    public static void setCalculation() {
        calculation = new Calculation();
        calculation.initResults();
        calculation.getResults().put(Rank.FIFTH, 2);
        lottoMoney = 5000;

    }

    @DisplayName("Rank FIFTH에 랭크된 개수 테스트")
    @Test
    public void getResultsTest() {
        assertThat(calculation.getResults().get(Rank.FIFTH)).isEqualTo(2);
    }

    @DisplayName("총 수익률 테스트")
    @Test
    public void getBenefitPercentTest() {
        assertThat(calculation.getBenefitPercent(lottoMoney)).isEqualTo(2.0);
    }
}
