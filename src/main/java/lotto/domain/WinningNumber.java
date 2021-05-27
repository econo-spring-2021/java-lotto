package lotto.domain;

import java.util.ArrayList;

public class WinningNumber {
    private ArrayList<Integer> winningNumber;
    private int bonusBall;

    public WinningNumber(ArrayList<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public WinningNumber(ArrayList<Integer> winningNumber, int bonusBall) {
        this.winningNumber = winningNumber;
        this.bonusBall = bonusBall;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }

    public ArrayList<Integer> getWinningNumbers() {
        return winningNumber;
    }

    public boolean isBonusBall(int number) {
        return this.bonusBall == number;
    }
}
