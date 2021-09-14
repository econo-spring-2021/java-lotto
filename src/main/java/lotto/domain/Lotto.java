package lotto.domain;

import lotto.view.Constants;

import java.util.*;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int SIZE_EXCEPT_BONUS_NUMBER = 6;
    public static final int SIZE_CONTAINING_BONUS_BALL = 7;
    private List<LottoNumber> lottoNumbers;

    public Lotto() {
        List<LottoNumber> lottoNumberRange = new ArrayList<LottoNumber>();
        for (int i = LottoNumber.MINIMUM_VALUE; i <= LottoNumber.MAXIMUM_VALUE; i++) {
            lottoNumberRange.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumberRange);
        lottoNumbers = lottoNumberRange.subList(0, 6);
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        validateDuplicatedLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank findLottoRank(WinningLotto winningLotto) {
        Set<LottoNumber> lottoAndWinningLotto = new HashSet<>();
        lottoAndWinningLotto.addAll(lottoNumbers);
        lottoAndWinningLotto.addAll(winningLotto.getLottoNumbers());

        int matchCount = (Lotto.SIZE_EXCEPT_BONUS_NUMBER * 2) - lottoAndWinningLotto.size();
        boolean bonusMatch = lottoNumbers.contains(winningLotto.getBonusBall());

        return LottoRank.of(matchCount, bonusMatch);
    }

    private void validateDuplicatedLottoNumber(List<LottoNumber> lottoNumbers) throws IllegalArgumentException {
        Set<LottoNumber> lottoNumberHashSet = new HashSet<>();
        lottoNumberHashSet.addAll(lottoNumbers);
        if (lottoNumberHashSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }
    }

    private void validateLottoNumberCount(List<LottoNumber> lottoNumbers) throws IllegalArgumentException {
        if(lottoNumbers.size() != Lotto.SIZE_EXCEPT_BONUS_NUMBER) {
            throw new IllegalArgumentException("로또 번호의 개수는 " + Lotto.SIZE_EXCEPT_BONUS_NUMBER + "개 입니다.");
        }

    }
}
