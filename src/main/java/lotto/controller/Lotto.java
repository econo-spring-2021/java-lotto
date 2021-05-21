package lotto.controller;

import lotto.domain.Calculation;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {

    public static ArrayList<Integer> setOriginalLottoNumbers() {
        ArrayList<Integer> originalLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            originalLottoNumbers.add(i);
        }
        Collections.shuffle(originalLottoNumbers);
        return originalLottoNumbers;
    }

    public static ArrayList<Integer> setLottoNumbers(ArrayList<Integer> originalLottoNumbers) {
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
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
