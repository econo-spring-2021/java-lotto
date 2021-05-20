package lotto.view;

public class InvalidMoneyInputException extends RuntimeException{
    public static final String invalidMoneyInput = "구입 금액을 1000원 단위로 입력해주세요.";

    public InvalidMoneyInputException(){
        super(invalidMoneyInput);
    }
}
