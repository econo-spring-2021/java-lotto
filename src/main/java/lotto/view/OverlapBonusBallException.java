package lotto.view;

public class OverlapBonusBallException extends Exception {
    public static final String OVERLAP_BONUSBALL_EXCEPTION = "보너스 볼을 당첨 번호와 중복되지 않게 입력하세요.";

    public OverlapBonusBallException() {
        super(OVERLAP_BONUSBALL_EXCEPTION);
    }
}
