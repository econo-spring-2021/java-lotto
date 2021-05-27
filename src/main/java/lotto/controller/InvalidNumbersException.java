package lotto.controller;

public class InvalidNumbersException extends Exception{
    public static final String INVALID_NUMBERS_EXCEPTION = "당첨 번호를 1 이상 45이하의 숫자로 입력하세요.";
    public InvalidNumbersException(){
        super(INVALID_NUMBERS_EXCEPTION);
    }
}
