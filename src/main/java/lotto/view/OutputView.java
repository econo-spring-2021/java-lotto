package lotto.view;

import java.util.*;

public class OutputView {
    private static final String MANUAL_LOTTO_MESSAGE = "수동으로 ";
    private static final String LOTTO_UNIT ="장, ";
    private static final String AUTO_LOTTO_MESSAGE ="자동으로 ";
    private static final String PURCHASED_LOTTO_NUMBER_MESSAGE = "장을 구매했습니다.";
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WIN_STATISTICS_SEPARATOR ="---------";
    private static final String THREE_LOTTO_COINCIDENCE_MESSAGE = "3개 일치 (5000원) - ";
    private static final String FOUR_LOTTO_COINCIDENCE_MESSAGE = "4개 일치 (50000원) - ";
    private static final String FIVE_LOTTO_COINCIDENCE_MESSAGE = "5개 일치 (1500000원) - ";
    private static final String FIVE_BONUS_LOTTO_COINCIDENCE_MESSAGE = "5개 일치, 보너스 볼 일치(30000000원) - ";
    private static final String SIX_LOTTO_COINCIDENCE_MESSAGE = "6개 일치 (2000000000원) - ";
    private static final String BENEFIT_MESSAGE ="총 수익률은 ";
    private static final String BENEFIT_MESSAGE_END = "입니다.";

    public static void numberOfLottoShow(int autoLottoCount, int manualLottoCount){
        System.out.println(MANUAL_LOTTO_MESSAGE+autoLottoCount+LOTTO_UNIT+AUTO_LOTTO_MESSAGE+manualLottoCount+PURCHASED_LOTTO_NUMBER_MESSAGE);
    }

    public static void resultSignalShow(){
        System.out.println();
        System.out.println(WIN_STATISTICS_MESSAGE);
        System.out.println(WIN_STATISTICS_SEPARATOR);
    }

    public static void resultShow(List<Integer> results){
        StringBuilder sb = new StringBuilder();
        sb.append(THREE_LOTTO_COINCIDENCE_MESSAGE).append(results.get(0)).append("개").append("\n");
        sb.append(FOUR_LOTTO_COINCIDENCE_MESSAGE).append(results.get(1)).append("개").append("\n");
        sb.append(FIVE_LOTTO_COINCIDENCE_MESSAGE).append(results.get(2)).append("개").append("\n");
        sb.append(FIVE_BONUS_LOTTO_COINCIDENCE_MESSAGE).append(results.get(3)).append("개").append("\n");
        sb.append(SIX_LOTTO_COINCIDENCE_MESSAGE).append(results.get(4)).append("개").append("\n");
        System.out.println(sb.toString());
    }

    public static void lottoTicketNumberShow(List<Integer> lottoNumbers){
        System.out.println(lottoNumbers);
    }

    public static void benefitShow(String benefit){
        System.out.println(BENEFIT_MESSAGE+benefit+BENEFIT_MESSAGE_END);
    }

}
