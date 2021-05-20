package lotto.view;

public class InputView {
    private static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LASTWEEK_WINNING_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static void moneyInput(){
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
    }

    public static void wonNumberInput(){
        System.out.println(LASTWEEK_WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public static void bonusBallInput(){
        System.out.println(BONUS_BALL_INPUT_MESSAGE);
    }
}
