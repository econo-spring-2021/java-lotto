package lotto.view;

public class InvalidInputMoneyException extends Exception {
    private static final String INVALID_INPUT_MONEY_EXCEPTION = "로또는 1000원 이상 부터 살 수 있습니다.";

    public InvalidInputMoneyException(){
        super(INVALID_INPUT_MONEY_EXCEPTION);
    }
}
