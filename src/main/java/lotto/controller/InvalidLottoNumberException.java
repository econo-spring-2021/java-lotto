package lotto.controller;

public class InvalidLottoNumberException extends Exception {
    private static final String INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1 이상 45이하의 숫자로 입력하세요.";

    public InvalidLottoNumberException() {
        super(INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }
}
