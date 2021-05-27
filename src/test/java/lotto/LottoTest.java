package lotto;

import lotto.controller.Lotto;
import lotto.domain.Calculation;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private final int lottoMoney = 5000;
    private int lottoTicketsNumber = 5;
    private static ArrayList<LottoTicket> lottoTickets = new ArrayList<>();
    private static WinningNumber winningNumbers;
    private static Calculation calculation = new Calculation();

    @Test
    public void ticketsNumberTest() {
        assertThat(Lotto.getAutomaticTickets(lottoMoney,1)).isEqualTo(4);
    }

    @BeforeAll
    public static void lottoSetting() {
        ArrayList<Integer> testNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> testNumbers2 = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12));
        ArrayList<Integer> testNumbers3 = new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 18));
        ArrayList<Integer> testNumbers4 = new ArrayList<>(Arrays.asList(19, 20, 21, 22, 23, 24));
        ArrayList<Integer> testNumbers5 = new ArrayList<>(Arrays.asList(25, 26, 27, 28, 29, 30));

        lottoTickets.add(new LottoTicket(testNumbers1));
        lottoTickets.add(new LottoTicket(testNumbers2));
        lottoTickets.add(new LottoTicket(testNumbers3));
        lottoTickets.add(new LottoTicket(testNumbers4));
        lottoTickets.add(new LottoTicket(testNumbers5));

        ArrayList<Integer> winningAnswers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 45));
        winningNumbers = new WinningNumber(winningAnswers);
        winningNumbers.setBonusBall(6);

        Lotto.checkLottoTicketsMatchCount(lottoTickets, winningNumbers);
        Lotto.calculateMatchResults(lottoTickets, calculation);
    }

    @Test
    public void LottoOneTicketMatchCountTest() {
        Lotto.checkOneLottoTicketMatchCount(lottoTickets.get(0), winningNumbers);
        assertThat(lottoTickets.get(0).getMatchCount()).isEqualTo(5);
        assertThat(lottoTickets.get(0).isBonusball()).isEqualTo(true);
    }

    @Test
    public void LottoTicketsMatchCountTest() {
        for (int i = 1; i < lottoTickets.size(); i++) {
            assertThat(lottoTickets.get(i).getMatchCount()).isEqualTo(0);
            assertThat(lottoTickets.get(i).isBonusball()).isEqualTo(false);
        }
    }

    @Test
    public void LottoTicketCheckMatchCountTest() {
        assertThat(lottoTickets.get(0).checkMatchCount()).isEqualTo(Rank.SECOND);
    }

    @Test
    public void CalculationSetResultTest() {
        assertThat(calculation.getResults().get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    public void CalculationBenefitPercentTest() {
        assertThat(calculation.getBenefitPercent(lottoMoney)).isEqualTo(600.0);
    }

}
