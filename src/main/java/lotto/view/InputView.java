package lotto.view;

import lotto.controller.InvalidInputMoneyException;
import lotto.controller.InvalidInputLottoBallsException;

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
    private static final String MANUAL_PURCHASE_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static Scanner input = new Scanner(System.in);

    public static int moneyInput() throws InvalidInputMoneyException {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
        int purchasedMoney = input.nextInt();
        String buffer = input.nextLine();
        if(purchasedMoney<LOTTO_TICKET_PRICE)
            throw new InvalidInputMoneyException();
        return purchasedMoney/LOTTO_TICKET_PRICE;
    }

    public static int manualLottoCountsInput(){
        System.out.println(MANUAL_PURCHASE_LOTTO_COUNT_MESSAGE);
        int purchaseCount = input.nextInt();
        String buffer = input.nextLine();
        return purchaseCount;
    }

    public static void manualLottoInputMessageShow(){
        System.out.println(MANUAL_LOTTO_NUMBERS_INPUT_MESSAGE);
    }

    public static void wonLottoInputMessageShow() {
        System.out.println(LASTWEEK_WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public static List<Integer> lottoNumberInput() throws InvalidInputLottoBallsException {
        List<Integer> tempWinningBalls = new ArrayList<>();
        String winningBallString = input.nextLine().replaceAll(" ","").trim();
        String[] winningBallArray = separateWinningBall(winningBallString);

        if(winningBallArray.length !=6 ) {
            throw new InvalidInputLottoBallsException();
        }
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
