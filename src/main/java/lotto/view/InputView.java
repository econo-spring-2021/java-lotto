package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자가 아닌 입력이 있습니다. 다시 입력해주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static Long getUserMoney() {
        try {
            String input = arrangeInput(scanner.nextLine());

            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);

            return getUserMoney();
        }
    }

    public static int getManualLottoCount() {
        try {
            String input = arrangeInput(scanner.nextLine());

            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);

            return getManualLottoCount();
        }
    }

    public static List<Integer> getLotto() {
        String input = arrangeInput(scanner.nextLine());

        return splitLottoString(input);
    }

    public static List<Integer> splitLottoString(String str) {
        try {
            String[] splitedInputs = str.split(",");
            List<Integer> splitedNumberInputs = new ArrayList<>();
            for (String splitedInput : splitedInputs) {
                splitedNumberInputs.add(Integer.parseInt(splitedInput));
            }

            return splitedNumberInputs;
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);

            return getLotto();
        }
    }

    public static Integer getBonusNumber() {
        try {
            String input = arrangeInput(scanner.nextLine());
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_EXCEPTION_MESSAGE);

            return getBonusNumber();
        }
    }

    private static String arrangeInput(String input) {
        return input.replaceAll(" ", "");
    }
}
