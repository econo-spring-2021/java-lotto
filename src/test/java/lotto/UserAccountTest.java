package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.UserAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserAccountTest {

    @Test
    public void test_getIncomeRate() {
        UserAccount userAccount = new UserAccount(5000L);
        userAccount.setIncome(LottoTicket.FIRST_LOTTO_PRICE);
        double rate = userAccount.getIncomeRate();

        Assertions.assertEquals(400000L, rate);
    }
}
