package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
public class WinningNumberTest {
    private static WinningNumber winningNumber;
    private static int bonusBall;

    @BeforeAll
    public static void setWinningNumber(){
        ArrayList<Integer> winningAnswers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusBall = 7;
        winningNumber = new WinningNumber(winningAnswers,bonusBall);
    }

    @DisplayName("getWinningNumber() 테스트")
    @Test
    public void getWinningNumberTest(){
        assertThat(winningNumber.getWinningNumbers()).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("isBonusBallTest")
    @Test
    public void isBonusBallTest(){
        assertThat(winningNumber.isBonusBall(7)).isEqualTo(true);
    }
}
