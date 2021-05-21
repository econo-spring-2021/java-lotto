package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;

public class ExceptionView {

    private static final String LOTTO_NUMBERCOUNT_EXCEPTION_MESSAGE = "[Exception] 당첨 번호는 6개가 필요합니다.";

    public void catchNotDigitInput(String input) {
        boolean isDigit = input.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isDigit) throw new NotProperArgumentException();
    }

    public void catchNotDigitElement(List<String> list) {
        for (String element : list){
            catchNotDigitInput(element);
        }
    }

    public void catchNotProperCountOfNumber(List<String> list) {
        if (list.size() != LottoTicket.LOTTO_NUMBER_LENGTH)
            throw new NotProperArgumentException(LOTTO_NUMBERCOUNT_EXCEPTION_MESSAGE);
    }
}
