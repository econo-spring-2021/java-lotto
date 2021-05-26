package lotto;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserAccountTest {

    @Test
    void test_getIncomeRate() {
        UserAccount userAccount = new UserAccount(5000L);
        userAccount.setIncome(LottoResult.FIRST_LOTTO_PRICE);
        double rate = userAccount.getIncomeRate();

        Assertions.assertEquals(400000L, rate);
    }
}
