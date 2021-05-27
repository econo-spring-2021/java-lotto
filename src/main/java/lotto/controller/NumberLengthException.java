package lotto.controller;

public class NumberLengthException extends Exception{
    public static final String NUMBER_LENGTH_EXCEPTION = "당첨 번호를 6개 입력하세요.";
    public NumberLengthException(){
        super(NUMBER_LENGTH_EXCEPTION);
    }
}
