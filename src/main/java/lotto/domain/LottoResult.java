package lotto.domain;

public enum LottoResult {
    FIRST(6), SECOND(7), THIRD(5), FORTH(4), FIFTH(3);

    private final int value;

    LottoResult(int value) {
        this.value = value;
    }
}
