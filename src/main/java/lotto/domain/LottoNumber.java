package lotto.domain;

import lotto.view.Constants;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validateRange(int number) throws IllegalArgumentException {
        if(number < Constants.LOTTO_MINIMUM_VALUE || number > Constants.LOTTO_MAXIMUM_VALUE ) {
            throw new IllegalArgumentException("로또 번호의 범위는 1 ~ 45 사이의 수 입니다.");
        }
    }
}
