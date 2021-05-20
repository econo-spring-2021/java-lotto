package lotto.view;

public class OverlapWinningNumberException extends Exception {
    public static final String OVERLAP_WINNING_NUMBER_EXCEPTION = "당첨 번호를 중복되지 않게 입력하세요.";

    public OverlapWinningNumberException(){
        super(OVERLAP_WINNING_NUMBER_EXCEPTION);
    }
}
