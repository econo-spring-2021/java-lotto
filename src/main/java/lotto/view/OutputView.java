package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTicket;

public class OutputView {

    private static final String ASKING_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUYINGLOTTE_COUNT_MESSAGE = "개를 구매했습니다.";

    private static final String ASKING_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String ASKING_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final String FIFTH_LOTTO_MESSAGE = "3개 일치 (" + LottoTicket.FIFTH_LOTTO_PRICE + "원)- ";
    private static final String FORTH_LOTTO_MESSAGE = "4개 일치 (" + LottoTicket.FORTH_LOTTO_PRICE + "원)- ";
    private static final String THIRD_LOTTO_MESSAGE = "5개 일치 (" + LottoTicket.THIRD_LOTTO_PRICE + "원)- ";
    private static final String SECOND_LOTTO_MESSAGE = "5개 일치, 보너스 볼 일 (" + LottoTicket.SECOND_LOTTO_PRICE + "원)- ";
    private static final String FIRST_LOTTO_MESSAGE = "6개 일치 (" + LottoTicket.FIRST_LOTTO_PRICE + "원)- ";

    private static final String ICOME_RATE_FRONT_MESSAGE = "총 수익률은 ";
    private static final String ICOME_RATE_BACK_MESSAGE = "입니다";

    public static void askMoney() {
        System.out.println(ASKING_MONEY_MESSAGE);
    }

    public static void printBuyingLotteCount(int count) {
        System.out.println(count + BUYINGLOTTE_COUNT_MESSAGE);
    }

    public static void printLottoTicket(LottoTicket ticket) {
        System.out.println("[" + String.join(",", ticket.getNumbers()) + "]");
    }

    public static void askWinningLottoNumber() {
        System.out.println(ASKING_WINNING_LOTTO_NUMBER_MESSAGE);
    }

    public static void askBonusNumber() {
        System.out.println(ASKING_BONUS_NUMBER_MESSAGE);
    }

    public static void printLottoResult(UserLottoTicket tickets) {
        System.out.print(FIFTH_LOTTO_MESSAGE);
        System.out.println(tickets.getSpecificResultCount(LottoResult.FIFTH));

        System.out.print(FORTH_LOTTO_MESSAGE);
        System.out.println(tickets.getSpecificResultCount(LottoResult.FORTH));

        System.out.print(THIRD_LOTTO_MESSAGE);
        System.out.println(tickets.getSpecificResultCount(LottoResult.THIRD));

        System.out.print(SECOND_LOTTO_MESSAGE);
        System.out.println(tickets.getSpecificResultCount(LottoResult.SECOND));

        System.out.print(FIRST_LOTTO_MESSAGE);
        System.out.println(tickets.getSpecificResultCount(LottoResult.FIRST));
    }

    public static void printIncomeRate(double rate) {
        System.out.println(ICOME_RATE_FRONT_MESSAGE + rate + ICOME_RATE_BACK_MESSAGE);
    }
}
