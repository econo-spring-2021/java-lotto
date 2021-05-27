package lotto.controller;

public class InvalidBonusBallException extends Exception {
    public static final String INVALID_BONUS_BALL_EXCEPTION = "보너스볼을 1 이상 45 이하로 입력하세요.";

    public InvalidBonusBallException() {
        super(INVALID_BONUS_BALL_EXCEPTION);
    }
}
