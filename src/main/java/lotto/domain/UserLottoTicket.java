package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoTicket {
    private List<LottoTicket> purchasedLotto = new ArrayList<>();

    public void addLottoTicket(){
        purchasedLotto.add(LottoFactory.LottoAutoGenerate());
    }

    public List<Integer> getPurchasedLotto(int index) {
        Collections.sort(purchasedLotto.get(index).getLottoNumbers());
        return purchasedLotto.get(index).getLottoNumbers();
    }

    public List<LottoTicket> getPurchasedLotto() {
        return purchasedLotto;
    }
}
