package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private ExceptionView exceptionView = new ExceptionView();

    public Long getMoney(Scanner scanner) {
        try {
            String input = arrangeInput(scanner.nextLine());
            exceptionView.catchNotDigitInput(input);

            return Long.parseLong(input);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<String> getWinningLottoNumbers(Scanner scanner) {
        try {
            String input = arrangeInput(scanner.nextLine());

            List<String> inputList = Arrays.asList(input.split(","));
            exceptionView.catchNotDigitElement(inputList);
            exceptionView.catchNotProperCountOfNumber(inputList);

            return inputList;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public String getBonusBall(Scanner scanner) {
        try {
            String input = arrangeInput(scanner.nextLine());
            exceptionView.catchNotDigitInput(input);

            return input;
        } catch (NotProperArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private String arrangeInput(String input) {
        return input.replaceAll(" ", "");
    }
}
