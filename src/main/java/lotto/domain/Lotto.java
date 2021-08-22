package lotto.domain;

import lotto.view.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        List<LottoNumber> lottoNumberRange = new ArrayList<LottoNumber>();
        for(int i = Constants.LOTTO_MINIMUM_VALUE; i <= Constants.LOTTO_MAXIMUM_VALUE; i++) {
            lottoNumberRange.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumberRange);
        lottoNumbers = lottoNumberRange.subList(0, 6);
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
