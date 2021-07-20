package lotto.view;

public class NotProperArgumentException extends RuntimeException {
    public NotProperArgumentException() {
        super("[Exception] 올바르지 않은 입력 형식입니다.");
    }

    public NotProperArgumentException(String message) {
        super(message);
    }
}
