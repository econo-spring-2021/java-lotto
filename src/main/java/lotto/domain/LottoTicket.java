package lotto.domain;

import java.util.ArrayList;

public class LottoTicket {
    private final ArrayList<Integer> lottoNumbers;
    private int matchCount;
    private boolean isBonusball;
    public static final int SECOND_MATCH_COUNT = 5;

    public LottoTicket(ArrayList<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public ArrayList<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isBonusball() {
        return isBonusball;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setBonusball(boolean bonusBall) {
        isBonusball = bonusBall;
    }

    public Rank checkMatchCount() {
        for (Rank rank : Rank.values()) {
            if (matchCount == SECOND_MATCH_COUNT && isBonusball == true) {
                return Rank.SECOND;
            }
            if (rank.getMatch() == matchCount) {
                return rank;
            }
        }
        return null;
    }
}
