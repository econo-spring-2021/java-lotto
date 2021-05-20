package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;

public class OutputView {

    public static void askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyingLotteCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoTicket(LottoTicket ticket) {
        System.out.println("[" + String.join(",", ticket.getNumbers()) + "]");
    }
}
