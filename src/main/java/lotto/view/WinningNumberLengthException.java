package lotto.view;

public class WinningNumberLengthException  extends Exception{
    public static final String WINNING_NUMBER_LENGTH_EXCEPTION = "당첨 번호를 6개 입력하세요.";
    public WinningNumberLengthException(){
        super(WINNING_NUMBER_LENGTH_EXCEPTION);
    }
}
