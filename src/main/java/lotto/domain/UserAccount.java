package lotto.domain;

public class UserAccount {
    private final Long money;
    private Long income;

    public UserAccount(Long money) {
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
