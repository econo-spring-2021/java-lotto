package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerTicket {
    private LottoTicket lottoTicket;
    private int bonusBall;

    public WinnerTicket(LottoTicket lottoTicket, int bonusBall) {
        this.lottoTicket = lottoTicket;
        this.bonusBall = bonusBall;
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public int lottoComparing(LottoTicket userLottoTicket){
        List<Integer> userLottos = new ArrayList<>(userLottoTicket.getLottoNumbers());
        List<Integer> winnerLottos = new ArrayList<>(lottoTicket.getLottoNumbers());

        for(int i=0; i<6; i++){
            for(int j =0; j<6;j++){
                if(userLottos.get(i) == winnerLottos.get(j))
                    userLottoTicket.lottoWinIncrease();
            }
        }

        for(int i=0; i<6; i++){
            if(userLottos.get(i) == bonusBall){
                userLottoTicket.lottoBonusCoincedence();
                break;
            }
        }
        return userLottoTicket.getWinCount();
    }
}
