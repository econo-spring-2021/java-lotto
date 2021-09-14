package lotto.domain;

import lotto.view.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto extends Lotto {
    private LottoNumber bonusBall;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        super(lottoNumbers);
        validateDuplicatedLottoNumber(lottoNumbers,bonusBall);
        this.bonusBall = bonusBall;
    }

    public List<LottoNumber> getLottoNumbers() {
        return super.getLottoNumbers();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    public void validateDuplicatedLottoNumber(List<LottoNumber> lottoNumbers, LottoNumber bonusBall) throws IllegalArgumentException {
        Set<Integer> lottoNumberHashSet = new HashSet<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            lottoNumberHashSet.add(lottoNumber.getNumber());
        }
        lottoNumberHashSet.add(bonusBall.getNumber());
        if (lottoNumberHashSet.size() < Lotto.SIZE_CONTAINING_BONUS_BALL) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호와 중복됩니다.");
        }
    }
}
