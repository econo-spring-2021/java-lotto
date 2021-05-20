package lotto.view;

public class InvalidLottoNumbersException extends Exception {
    private static final String INVALID_LOTTO_NUMBERS_EXCEPTION = "로또 번호는 6개만 가능합니다.";

    public InvalidLottoNumbersException(){
        super(INVALID_LOTTO_NUMBERS_EXCEPTION);
    }
}
