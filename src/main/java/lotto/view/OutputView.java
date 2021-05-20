package lotto.view;

import java.util.HashMap;

public class OutputView {
    private static final String PURCHASED_LOTTO_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WIN_STATISTICS_SEPARATOR ="---------";
    private static final String THREE_COINCIDENCES_MESSAGE = "3개 일치 (5000원)- ";
    private static final String FOUR_COINCIDENCES_MESSAGE = "4개 일치 (50000원)- ";
    private static final String FIVE_COINCIDENCES_MESSAGE = "5개 일치 (1500000원)- ";
    private static final String FIVE_BONUSBALL_COINCIDENCES_MESSAGE = "5개 일치, 보너스 볼 일치(30000000원)- ";
    private static final String SIX_COINCIDENCES_MESSAGE = "6개 일치 (2000000000원)- ";
    private static final String BENEFIT_MESSAGE ="총 수익률은 ";
    private static final String BENEFIT_MESSAGE_END = "입니다.";

    public static void numberOfLottoShow(int number){
        System.out.println(number+PURCHASED_LOTTO_NUMBER_MESSAGE);
    }

    public static void resultShow(HashMap<String,Integer> results){
        System.out.println(WIN_STATISTICS_MESSAGE);
        System.out.println(WIN_STATISTICS_SEPARATOR);

        for(String s : results.keySet()){
            System.out.println(THREE_COINCIDENCES_MESSAGE+results.get(s));
        }
    }

    public static void benefitShow(double benefit){
        System.out.println(BENEFIT_MESSAGE+benefit+BENEFIT_MESSAGE_END);
    }

}
