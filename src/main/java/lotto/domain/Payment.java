package lotto.domain;

import lotto.view.Constants;

public class Payment {
    int money;

    public Payment(int money) {
        isUnderMinimumMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    private void isUnderMinimumMoney(int money) throws IllegalArgumentException {
        if(money < Constants.LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1000원 입니다.");
        }
    }
}
