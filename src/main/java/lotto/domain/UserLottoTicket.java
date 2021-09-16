package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoTicket {
    private List<LottoTicket> purchasedLotto = new ArrayList<>();

    public void addAutoLottoTicket(){
        purchasedLotto.add(LottoFactory.LottoAutoGenerate());
    }

    public void addManualLottoTicket(LottoTicket lottoTicket) {
        purchasedLotto.add(lottoTicket);
    }

    public List<Integer> getPurchasedLotto(int index) {
        Collections.sort(purchasedLotto.get(index).getLottoNumbers());
        return purchasedLotto.get(index).getLottoNumbers();
    }

    public List<LottoTicket> getPurchasedLotto() {
        return purchasedLotto;
    }
}
