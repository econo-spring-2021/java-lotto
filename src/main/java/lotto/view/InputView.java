package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Long getMoney() {
        try {
            String input = arrangeInput(scanner.nextLine());
            return Long.parseLong(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return getMoney();
        }
    }

    public static List<Integer> getWinningLottoNumbers( ) {
        try {
            String input = arrangeInput(scanner.nextLine());

            String[] splitedInputs = input.split(",");
            List<Integer> splitedNumberInputs = new ArrayList<>();
            for(String splitedInput : splitedInputs) {
                splitedNumberInputs.add(Integer.parseInt(input));
            }

            return splitedNumberInputs;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return getWinningLottoNumbers();
        }
    }

    public static Integer getBonusBall( ) {
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
