package lotto.controller;

public class InvalidInputLottoBallsException extends Exception {
    private static String INVALID_INPUT_WON_BALLS_MESSAGE = "지난 주 당첨 번호는 6개를 입력하셔야 됩니다.";

    public InvalidInputLottoBallsException() {
        super(INVALID_INPUT_WON_BALLS_MESSAGE);
    }
}
