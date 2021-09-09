package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> lottoNumbers;
    private int winCount;
    private boolean bonusFlag;

    public boolean isBonusFlag() {
        return bonusFlag;
    }

    public LottoTicket(List<Integer> lottoNumbers){
        this.lottoNumbers =lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void lottoWinIncrease(){
        winCount++;
    }

    public void lottoBonusCoincedence(){
        bonusFlag = true;
    }

    public int getWinCount() {
        return winCount;
    }
}
