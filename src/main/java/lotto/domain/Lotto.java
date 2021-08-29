package lotto.domain;

import lotto.view.Constants;

import java.util.*;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        List<LottoNumber> lottoNumberRange = new ArrayList<LottoNumber>();
        for (int i = Constants.LOTTO_MINIMUM_VALUE; i <= Constants.LOTTO_MAXIMUM_VALUE; i++) {
            lottoNumberRange.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumberRange);
        lottoNumbers = lottoNumberRange.subList(0, 6);
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateDuplicatedLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public void validateDuplicatedLottoNumber(List<LottoNumber> lottoNumbers) throws IllegalArgumentException {
        Set<Integer> lottoNumberHashSet = new HashSet<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            lottoNumberHashSet.add(lottoNumber.getNumber());
        }
        if (lottoNumberHashSet.size() < Constants.LOTTO_SIZE_EXCEPT_BONUS_NUMBER) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }
    }
}
