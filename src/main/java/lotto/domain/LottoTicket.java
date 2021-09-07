package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private List<Lotto> lottos;

    public LottoTicket() {
        lottos = new ArrayList<Lotto>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<LottoRank> findLottoRanks(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.findLottoRank(winningLotto))
                .collect(Collectors.toList());
    }
}
