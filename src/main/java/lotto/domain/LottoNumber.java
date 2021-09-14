package lotto.domain;

import lotto.view.Constants;

import java.util.Objects;

public class LottoNumber {
    public static final int MINIMUM_VALUE = 1;
    public static final int MAXIMUM_VALUE = 45;
    private int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validateRange(int number) throws IllegalArgumentException {
        if(number < LottoNumber.MINIMUM_VALUE || number > LottoNumber.MAXIMUM_VALUE ) {
            throw new IllegalArgumentException("로또 번호의 범위는 1 ~ 45 사이의 수 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
