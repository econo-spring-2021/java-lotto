package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.UserLottoTicketsDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ASKING_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASKING_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASKING_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 로또 번호를를 입력해 주세요.";
    private static final String USER_LOTTE_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.\n";

    private static final String ASKING_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String ASKING_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final String FIFTH_LOTTO_MESSAGE = "3개 일치 (" + LottoResult.FIFTH_LOTTO_PRICE + "원)- ";
    private static final String FORTH_LOTTO_MESSAGE = "4개 일치 (" + LottoResult.FORTH_LOTTO_PRICE + "원)- ";
    private static final String THIRD_LOTTO_MESSAGE = "5개 일치 (" + LottoResult.THIRD_LOTTO_PRICE + "원)- ";
    private static final String SECOND_LOTTO_MESSAGE = "5개 일치, 보너스 볼 일 (" + LottoResult.SECOND_LOTTO_PRICE + "원)- ";
    private static final String FIRST_LOTTO_MESSAGE = "6개 일치 (" + LottoResult.FIRST_LOTTO_PRICE + "원)- ";

    private static final String INCOME_RATE_FORMAT_MESSAGE = "총 수익률은 %f입니다.\n";


    public static void askUserMoney() {
        System.out.println(ASKING_MONEY_MESSAGE);
    }

    public static void askManualLottoCount() { System.out.println(ASKING_MANUAL_LOTTO_COUNT_MESSAGE);}

    public static void askManualLottoNumber() {
        System.out.println(ASKING_MANUAL_LOTTO_NUMBER_MESSAGE);
    }

    public static void printUserLottoTicket(int manualLottoCount, int automaticLottoCount,
                                            UserLottoTicketsDto userLottoTicketsDto) {
        System.out.printf(USER_LOTTE_COUNT_MESSAGE, manualLottoCount, automaticLottoCount);
        for (LottoTicket ticket : userLottoTicketsDto.getLottoTickets()) {
            printLottoTicket(ticket.getNumbers());
        }
    }

    public static void printLottoTicket(List<Integer> numbers) {
        System.out.println("[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]");
    }

    public static void askWinningLottoNumber() {
        System.out.println(ASKING_WINNING_LOTTO_NUMBER_MESSAGE);
    }

    public static void askBonusNumber() {
        System.out.println(ASKING_BONUS_NUMBER_MESSAGE);
    }

    public static void printLottoResult(UserLottoTickets tickets) {
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
        System.out.printf(INCOME_RATE_FORMAT_MESSAGE, rate);
    }
}
