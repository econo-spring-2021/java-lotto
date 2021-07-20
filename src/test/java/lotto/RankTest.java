package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("랭크에 맞는 돈 테스트")
    @Test
    public void getMoneyTest() {
        assertThat(Rank.FIRST.getMoney()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getMoney()).isEqualTo(3_000_000);
        assertThat(Rank.THIRD.getMoney()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getMoney()).isEqualTo(50000);
        assertThat(Rank.FIFTH.getMoney()).isEqualTo(5000);
    }

    @DisplayName("랭크에 맞는 일치수 테스트")
    @Test
    public void getMatchTest() {
        assertThat(Rank.FIRST.getMatch()).isEqualTo(6);
        assertThat(Rank.SECOND.getMatch()).isEqualTo(5);
        assertThat(Rank.THIRD.getMatch()).isEqualTo(5);
        assertThat(Rank.FOURTH.getMatch()).isEqualTo(4);
        assertThat(Rank.FIFTH.getMatch()).isEqualTo(3);
    }

    @DisplayName("당첨번호와 일치하는 개수에 맞는 랭크 테스트")
    @Test
    public void checkMatchCountOfTest() {
        assertThat(Rank.checkMatchCountOf(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.checkMatchCountOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.checkMatchCountOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.checkMatchCountOf(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.checkMatchCountOf(3, true)).isEqualTo(Rank.FIFTH);
    }
}
