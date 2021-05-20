package lotto.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int getMoney() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
