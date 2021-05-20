package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int getMoney() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public List<String> getWinningLottoNumber() {
        String input = scanner.nextLine().replaceAll(" ", "");
        return Arrays.asList(input.split(","));
    }

    public String getBonusBall() {
        String input = scanner.nextLine().replaceAll(" ", "");
        return input;
    }
}
