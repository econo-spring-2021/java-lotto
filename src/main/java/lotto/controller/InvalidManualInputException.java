package lotto.controller;

public class InvalidManualInputException extends Exception{
    public static final String INVALID_MANUAL_INPUT = "구입금액으로 구매할 수 있는 로또 수로 수동으로 구매할 로또 수를 입력하세요.";

    public InvalidManualInputException(){
        super(INVALID_MANUAL_INPUT);
    }
}
