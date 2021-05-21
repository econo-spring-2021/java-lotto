package lotto.view;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private ExceptionView exceptionView = new ExceptionView();

    public int getMoney() {
        try {
            String input = arrangeInput(scanner.nextLine());
            exceptionView.catchNotDigitInput(input);

            return Integer.parseInt(input);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

            return getMoney();
        }
    }

    public List<String> getWinningLottoNumber() {
        try {
            String input = arrangeInput(scanner.nextLine());

            List<String> inputList = Arrays.asList(input.split(","));
            exceptionView.catchNotDigitElement(inputList);
            exceptionView.catchNotProperCountOfNumber(inputList);

            return inputList;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

            return getWinningLottoNumber();
        }
    }

    public String getBonusBall() {
        try {
            String input = arrangeInput(scanner.nextLine());
            exceptionView.catchNotDigitInput(input);

            return input;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

            return getBonusBall();
        }
    }

    private String arrangeInput(String input) {
        return input.replaceAll(" ", "");
    }
}
