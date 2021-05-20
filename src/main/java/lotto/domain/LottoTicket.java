package lotto.domain;

import java.util.ArrayList;

public class LottoTicket {
    private static ArrayList<Integer> lottoNumbers;

    public LottoTicket(ArrayList<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static ArrayList<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
