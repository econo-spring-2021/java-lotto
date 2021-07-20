package lotto.domain;

import lotto.view.NotProperArgumentException;

public class UserAccount {
    public static final Long MIN_MONEY = 0l;
    public static final Long MAX_MONEY = Long.MAX_VALUE;

    private final Long money;
    private Long income;

    public UserAccount(Long money) {
        if (money < MIN_MONEY || MAX_MONEY < money)
            throw new IllegalArgumentException("적절하지 않는 돈의 범위입니다.");

        this.money = money;
    }

    public Long getMoney() {
        return money;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public double getIncomeRate() {
        return income / (double) (money);
    }
}
