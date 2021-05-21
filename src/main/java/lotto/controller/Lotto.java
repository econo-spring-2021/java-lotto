package lotto.controller;

import lotto.domain.Calculation;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_FINISH_NUMBER = 45;
    public static final int ONE_LOTTO_TICKET_NUMBER = 6;

    public static ArrayList<Integer> setOriginalLottoNumbers() {
        ArrayList<Integer> originalLottoNumbers = new ArrayList<>();
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_FINISH_NUMBER; i++) {
            originalLottoNumbers.add(i);
        }
        Collections.shuffle(originalLottoNumbers);
        return originalLottoNumbers;
    }

    public static ArrayList<Integer> setLottoNumbers(ArrayList<Integer> originalLottoNumbers) {
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < ONE_LOTTO_TICKET_NUMBER; i++) {
            lottoNumbers.add(originalLottoNumbers.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static void checkLottoTicketsMatchCount(ArrayList<LottoTicket> lottoTickets, WinningNumber winningNumbers){
        for(int i=0; i<lottoTickets.size();i++){
            checkOneLottoTicketMatchCount(lottoTickets.get(i),winningNumbers);
        }
    }
    public static void checkOneLottoTicketMatchCount(LottoTicket lottoTicket, WinningNumber winningNumbers){
        int count = 0;
        ArrayList<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
        for(int number : lottoNumbers){
            if(winningNumbers.getWinningNumbers().contains(number)){
                count++;
            }
            if(winningNumbers.isBonusBall(number)){
                lottoTicket.setBonusball(true);
            }
        }
        lottoTicket.setMatchCount(count);
    }

    public static void calculateMatchResults(ArrayList<LottoTicket> lottoTickets, Calculation calculation){
        for(LottoTicket lottoTicket : lottoTickets){
            if(lottoTicket.checkMatchCount() != Rank.NOTHING){
                calculation.setResults(lottoTicket.checkMatchCount());
            }
        }
    }

}
