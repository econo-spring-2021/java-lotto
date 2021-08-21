package lotto.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private Integer inputMoney;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Integer inputMoney() {
        inputMoney = scanner.nextInt();
        return inputMoney;
    }
}
