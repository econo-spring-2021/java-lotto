package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {
    @Test
    void 로또_티켓_생성_확인하기() {
        List<LottoNumber> lottoNumbers = Stream.of(1,2,3,4,5,6).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        Lotto lotto = new Lotto(lottoNumbers);
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.add(lotto);

        assertEquals(lottoTicket.getLottos().size(),1);
    }

    @Test
    void 로또_당첨_통계_반환_테스트() {
        //given
        List<LottoNumber> lottoNumbers1 = Stream.of(1,2,3,4,5,6).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        List<LottoNumber> lottoNumbers2 = Stream.of(1,2,3,4,7,8).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        Lotto lotto1 = new Lotto(lottoNumbers1);
        Lotto lotto2 = new Lotto(lottoNumbers2);
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.add(lotto1);
        lottoTicket.add(lotto2);

        List<LottoNumber> winningLottoNumbers = Stream.of(1,2,3,4,5,6).map(number -> new LottoNumber(number)).collect(Collectors.toList());
        LottoNumber bonusBall = new LottoNumber(7);

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusBall);

        //when
        List<LottoRank> ranks = lottoTicket.findLottoRanks(winningLotto);

        //then
        assertEquals(ranks.size(),2);
    }

}