package lotto.view;

public class InvalidWinningNumberException extends Exception {
    public static final String INVALID_WINNING_NUMBER_EXCEPTION = "당첨 번호를 1 이상 45이하의 숫자로 입력하세요.";

    public InvalidWinningNumberException() {
        super(INVALID_WINNING_NUMBER_EXCEPTION);
    }
}
