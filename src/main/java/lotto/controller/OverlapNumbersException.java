package lotto.controller;

public class OverlapNumbersException extends Exception{
    public static final String OVERLAP_NUMBER_EXCEPTION = "당첨 번호를 중복되지 않게 입력하세요.";
    public OverlapNumbersException(){
        super(OVERLAP_NUMBER_EXCEPTION);
    }
}
