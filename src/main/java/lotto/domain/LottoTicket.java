package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket() {
        List<Integer> tempLottoNumbers = new ArrayList<>();
        for (int i =1; i<=45; i++){
            tempLottoNumbers.add(i);
        }
        Collections.shuffle(tempLottoNumbers);
        lottoNumbers = tempLottoNumbers.subList(0,6);
    }

    public LottoTicket(List<Integer> lottoNumbers){
        this.lottoNumbers =lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
