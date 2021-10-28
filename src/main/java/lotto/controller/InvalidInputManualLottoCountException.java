package lotto.controller;

public class InvalidInputManualLottoCountException extends Exception {
    private static final String INVALID_INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동 로또 구매 수가 총 구매 로또 수를 초과했습니다.";

    public InvalidInputManualLottoCountException() {
        super(INVALID_INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
    }
}
