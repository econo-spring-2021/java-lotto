package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Long getUserMoney() {
        try {
            String input = arrangeInput(scanner.nextLine());

            return Long.parseLong(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return getUserMoney();
        }
    }

    public static int getManualLottoCount() {
        try {
            String input = arrangeInput(scanner.nextLine());

            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return getManualLottoCount();
        }
    }

    public static List<Integer> getLotto() {
        String input = arrangeInput(scanner.nextLine());
//        String input = scanner.nextLine();

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e);

            return getLotto();
        }
    }

    public static Integer getBonusBall() {
        try {
            String input = arrangeInput(scanner.nextLine());
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return getBonusBall();
        }
    }

    private static String arrangeInput(String input) {
        return input.replaceAll(" ", "");
    }
}
