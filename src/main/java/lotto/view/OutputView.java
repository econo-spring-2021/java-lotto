package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTicket;

import java.lang.reflect.Field;
import java.util.List;

public class OutputView {

    private static final String ASKING_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUYINGLOTTE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String FIFTH_LOTTO_MESSAGE = "3개 일치 (5000원)- ";
    private static final String FORTH_LOTTO_MESSAGE = "4개 일치 (50000원)- ";
    private static final String THIRD_LOTTO_MESSAGE = "5개 일치 (1500000원)- ";
    private static final String SECOND_LOTTO_MESSAGE = "5개 일치, 보너스 볼 일 (30000000원)- ";
    private static final String FIRST_LOTTO_MESSAGE = "6개 일치 (2000000000원)- ";

    public static void askMoney() {
        System.out.println(ASKING_MONEY_MESSAGE);
    }

    public static void printBuyingLotteCount(int count) {
        System.out.println(count + BUYINGLOTTE_COUNT_MESSAGE);
    }

    public static void printLottoTicket(LottoTicket ticket) {
        System.out.println("[" + String.join(",", ticket.getNumbers()) + "]");
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
}
