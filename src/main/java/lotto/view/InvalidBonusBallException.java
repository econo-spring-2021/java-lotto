package lotto.view;

public class InvalidBonusBallException extends Exception {
    public static final String INVALID_BONUS_BALL_EXCEPTION = "보너스볼을 1이상 45이하로 입력하세요.";

    public InvalidBonusBallException() {
        super(INVALID_BONUS_BALL_EXCEPTION);
    }
}
