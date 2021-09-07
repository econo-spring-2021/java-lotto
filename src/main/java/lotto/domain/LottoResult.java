package lotto.domain;

import java.util.*;

public class LottoResult {
    private Map<LottoRank, Integer> winningStatistics;

    public LottoResult() {
        winningStatistics = new HashMap<>();
    }

    public Map<LottoRank, Integer> show(List<LottoRank> lottoRanks) {
        Arrays.stream(LottoRank.values()).forEach(rank -> winningStatistics.put(rank, 0));
        lottoRanks.forEach(rank -> winningStatistics.put(rank, winningStatistics.get(rank) + 1));
        return winningStatistics;
    }

    public double calculateTotalEarningRate(Payment inputMoney) {
        long winningMoney = 0;

        for(LottoRank lottoRank : LottoRank.values()) {
            winningMoney += ((long) lottoRank.getMoney() * winningStatistics.get(lottoRank));
        }

        return (double) winningMoney / inputMoney.getMoney();
    }
}
