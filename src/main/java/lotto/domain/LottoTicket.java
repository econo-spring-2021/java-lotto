package lotto.domain;

import java.util.ArrayList;

public class LottoTicket {
    private final ArrayList<Integer> lottoNumbers;
    private int matchCount;
    private boolean isBonusball;

    public LottoTicket(ArrayList<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public ArrayList<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void setBonusball(boolean bonusBall) {
        isBonusball = bonusBall;
    }

    public boolean isBonusball() {
        return isBonusball;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
