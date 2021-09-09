package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private List<Integer> lottoNumbers;
    private int winCount;
    private boolean bonusFlag;

    public boolean isBonusFlag() {
        return bonusFlag;
    }

    public LottoTicket(List<Integer> lottoNumbers){
        validateLottoNumbers(lottoNumbers);
        validateDuplicatedLottoNumbers(lottoNumbers);
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

    public void validateLottoNumbers(List<Integer> lottoNumbers){
        for(int lottoNumber : lottoNumbers){
            if(lottoNumber<1 || lottoNumber >45) throw new IllegalArgumentException("로또 번호는 1부터 45까지 존재합니다");
        }
    }

    public void validateDuplicatedLottoNumbers(List<Integer> lottoNumbers){
        Set<Integer> distincLottoNumbers = new HashSet<>(lottoNumbers);
        if(distincLottoNumbers.size() != lottoNumbers.size())
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
    }
}
