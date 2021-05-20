package lotto.domain;

public class UserAccount {
    private final int money;
    private int income;

    public UserAccount(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
