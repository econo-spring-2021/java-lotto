package lotto.controller;

public class InvalidInputMoneyException extends Exception {
    private static final String INVALID_INPUT_MONEY_MESSAGE = "로또는 1000원 이상부터 살 수 있습니다.";

    public InvalidInputMoneyException() {
        super(INVALID_INPUT_MONEY_MESSAGE);
    }
}
