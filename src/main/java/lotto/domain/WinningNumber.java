package lotto.domain;

import java.util.ArrayList;

public class WinningNumber {
    private ArrayList<Integer> winningNumbers;
    private int bonusBall;

    public WinningNumber(ArrayList<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }

    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
