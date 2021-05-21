package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;

public class OutputView {
    public static final String WINNING_STATISTICS_VIEW ="당첨 통계";
    public static final String FIFTH_RESULT_VIEW = "3개 일치 (5000원) - ";
    public static final String FOURTH_RESULT_VIEW = "4개 일치 (50000원) - ";
    public static final String THIRD_RESULT_VIEW = "5개 일치 (1500000원) - ";
    public static final String SECOND_RESULT_VIEW = "5개 일치, 보너스 볼 일치 (30000000원) - ";
    public static final String FIRST_RESULT_VIEW = "6개 일치 (2000000000원) - ";
    public static final String COUNT_VIEW = "개";
    public static final String FINAL_BENEFIT_PERCENT_VIEW = "총 수익률은 ";
    public static final String FINAL_BENEFIT_PERCENT_VIEW2 = "입니다.";

    public static void winningStatisticsView(){
        System.out.println("");
        System.out.println(WINNING_STATISTICS_VIEW);
        System.out.println("--------");
    }

    public static void winningResultsView(HashMap<Rank, Integer> results){
        System.out.println(FIFTH_RESULT_VIEW+results.get(Rank.FIFTH)+COUNT_VIEW);
        System.out.println(FOURTH_RESULT_VIEW+results.get(Rank.FOURTH)+COUNT_VIEW);
        System.out.println(THIRD_RESULT_VIEW+results.get(Rank.THIRD)+COUNT_VIEW);
        System.out.println(SECOND_RESULT_VIEW+results.get(Rank.SECOND)+COUNT_VIEW);
        System.out.println(FIRST_RESULT_VIEW+results.get(Rank.FIRST)+COUNT_VIEW);
    }

    public static void finalBenefitPercentView(double percent){
        System.out.println("");
        System.out.println(FINAL_BENEFIT_PERCENT_VIEW+percent+FINAL_BENEFIT_PERCENT_VIEW2);
    }
}
