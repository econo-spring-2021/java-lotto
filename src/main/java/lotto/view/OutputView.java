package lotto.view;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void inputMoneyMessage() {
        System.out.println(Constants.INPUT_MONEY_MESSAGE);
    }

    public static void inputManualLottoCountMessage() {
        System.out.println(Constants.INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
    }

    public static void inputManualLottoMessage() {
        System.out.println(Constants.INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);
    }

    public static void printLottoCountMessage(int manualLottoCount, int autoLottoCount) {
        System.out.println(String.format(Constants.PURCHASE_NUMBER_PRINT_MESSAGE, manualLottoCount, autoLottoCount));
    }

    public static void printLottoTicketMessage(int lottoNumber1, int lottoNumber2, int lottoNumber3, int lottoNumber4, int lottoNumber5, int lottoNumber6) {
        System.out.println(String.format(Constants.LOTTO_TICKET_PRINT_MESSAGE,
                lottoNumber1,
                lottoNumber2,
                lottoNumber3,
                lottoNumber4,
                lottoNumber5,
                lottoNumber6));
    }

    public static void inputSixDigitNumbersMessage() {
        System.out.println(Constants.SIX_DIGIT_NUMBERS_INPUT_MESSAGE);
    }

    public static void inputBonusNumberMessage() {
        System.out.println(Constants.BONUS_BALL_INPUT_MESSAGE);
    }

    public static void printWinningStatistics() {
        System.out.println(Constants.WINNING_STATISTICS_MESSAGE);
        System.out.println(Constants.LINE_MADE_BY_HYPHEN_MESSAGE);
    }

    public static void printResult(int matchCount, int money, int count) {
                System.out.println(String.format(Constants.THREE_NUMBER_MATCH_MESSAGE,
                        matchCount,
                        money,
                        count));
    }

    public static void printEarningRate(double earningRate) {
        System.out.println(String.format(Constants.PROFIT_RATE_RESULT_MESSAGE,earningRate));
    }
}
