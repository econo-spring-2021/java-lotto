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
    public static final int LOTTO_PRICE = 1000;

    public static int getAutomaticTickets(int lottoMoney, int manualTickets){
        return lottoMoney / LOTTO_PRICE - manualTickets;
    }
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

    public static void checkLottoTicketsMatchCount(ArrayList<LottoTicket> lottoTickets, WinningNumber winningNumber){
        for(int i=0; i<lottoTickets.size();i++){
            checkOneLottoTicketMatchCount(lottoTickets.get(i),winningNumber);
        }
    }
    public static void checkOneLottoTicketMatchCount(LottoTicket lottoTicket, WinningNumber winningNumber){
        int count = 0;
        ArrayList<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
        for(int number : lottoNumbers){
            if(winningNumber.getWinningNumbers().contains(number)){
                count++;
            }
            if(winningNumber.isBonusBall(number)){
                lottoTicket.setBonusball(true);
            }
        }
        lottoTicket.setMatchCount(count);
    }

    public static void calculateMatchResults(ArrayList<LottoTicket> lottoTickets, Calculation calculation){
        for(LottoTicket lottoTicket : lottoTickets){
            Rank rank = Rank.checkMatchCountOf(lottoTicket.getMatchCount(),lottoTicket.isBonusball());
            if(rank != Rank.NOTHING){
                calculation.setResults(rank);
            }
        }
    }

}
