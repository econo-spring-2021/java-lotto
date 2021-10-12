package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private LottoTicket lottoTicket;

    public LottoMachine (int autoLottoCount, int manualLottoCount, List<Lotto> manualLottos) {
        lottoTicket = new LottoTicket();
        generateAutoLottoTicket(autoLottoCount);
        generateManualLottoTicket(manualLottoCount, manualLottos);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    private void generateAutoLottoTicket(int autoLottoCount) {
        for(int i = 0; i < autoLottoCount; i++) {
            Lotto lotto = new Lotto(generateAutoLottoNumbers());
            lottoTicket.add(lotto);
        }
    }

    private List<LottoNumber> generateAutoLottoNumbers() {
        List<LottoNumber> lottoNumberRange = new ArrayList<LottoNumber>();
        for (int i = LottoNumber.MINIMUM_VALUE; i <= LottoNumber.MAXIMUM_VALUE; i++) {
            lottoNumberRange.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumberRange);
        return lottoNumberRange.subList(0, 6);
    }

    private void generateManualLottoTicket(int manualLottoCount, List<Lotto> manualLottos) {
        for(int i = 0; i < manualLottoCount; i++) {
            lottoTicket.add(manualLottos.get(i));
        }
    }
}
