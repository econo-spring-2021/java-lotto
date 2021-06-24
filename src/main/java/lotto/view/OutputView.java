package lotto.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String PURCHASED_LOTTO_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WIN_STATISTICS_SEPARATOR ="---------";
    private static final String BENEFIT_MESSAGE ="총 수익률은 ";
    private static final String BENEFIT_MESSAGE_END = "입니다.";

    public static void numberOfLottoShow(int number){
        System.out.println(number+PURCHASED_LOTTO_NUMBER_MESSAGE);
    }

    public static void resultShow(HashMap<String,Integer> results){
        System.out.println(WIN_STATISTICS_MESSAGE);
        System.out.println(WIN_STATISTICS_SEPARATOR);
    }

    public static void lottoTicketNumberShow(List<Integer> lottoNumbers){
        System.out.println(lottoNumbers);
    }

    public static void benefitShow(double benefit){
        System.out.println(BENEFIT_MESSAGE+benefit+BENEFIT_MESSAGE_END);
    }

}
