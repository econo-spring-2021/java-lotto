package lotto.domain;

public class UserAccount {
    private final int money;
    private Long income;

    public UserAccount(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public double getIncomeRate() {
        return income / (double) (money);
    }
}
