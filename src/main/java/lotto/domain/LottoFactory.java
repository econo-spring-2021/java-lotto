package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static List<Integer> tempLottoNumbers = new ArrayList<>();

    public static LottoTicket LottoAutoGenerate() {
        for (int i = 1; i <= 45; i++) {
            tempLottoNumbers.add(i);
        }
        Collections.shuffle(tempLottoNumbers);

        List<Integer> completeNumbers = new ArrayList<>(tempLottoNumbers.subList(0, 6));
        LottoTicket lottoTicket = new LottoTicket(completeNumbers);
        tempLottoNumbers.clear();
        return lottoTicket;
    }
}
