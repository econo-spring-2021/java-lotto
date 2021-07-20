package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserAccountTest {

    @Test
    @DisplayName("수익률이 올바르게 계산되는지")
    void test_getIncomeRate() {
        UserAccount userAccount = new UserAccount(5000L);
        userAccount.setIncome(LottoResult.FIRST.getPrice());
        double rate = userAccount.getIncomeRate();

        Assertions.assertEquals(400000L, rate);
    }
}
