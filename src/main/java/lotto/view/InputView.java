package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final String LASTWEEK_WINNING_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String SEPARATE_WINNING_BALL = ",";
    private static Scanner input = new Scanner(System.in);

    public static int moneyInput(){
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
        return input.nextInt()/LOTTO_TICKET_PRICE;
    }

    public static List<Integer> wonNumberInput(){
        List<Integer> tempWinningBalls = new ArrayList<>();
        System.out.println(LASTWEEK_WINNING_NUMBERS_INPUT_MESSAGE);
        String buffer = input.nextLine();
        String winningBallString = input.nextLine().replaceAll(" ","").trim();
        String[] winningBallArray = separateWinningBall(winningBallString);

        for (int i=0; i<6; i++){
            tempWinningBalls.add(Integer.parseInt(winningBallArray[i]));
        }
        Collections.sort(tempWinningBalls);
        return tempWinningBalls;
    }

    public static String[] separateWinningBall(String winningBalls){
        return winningBalls.split(SEPARATE_WINNING_BALL);
    }

    public static int bonusBallInput(){
        System.out.println(BONUS_BALL_INPUT_MESSAGE);
        return input.nextInt();
    }
}
