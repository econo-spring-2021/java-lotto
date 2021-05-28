package lotto.domain;

import java.util.HashMap;

public class Calculation {
    private final HashMap<Rank, Integer> results = new HashMap<>();

    public void initResults() {
        results.put(Rank.FIFTH, 0);
        results.put(Rank.FOURTH, 0);
        results.put(Rank.THIRD, 0);
        results.put(Rank.SECOND, 0);
        results.put(Rank.FIRST, 0);
    }

    public HashMap<Rank, Integer> getResults() {
        return results;
    }

    public void setResults(Rank rank) {
        results.put(rank, results.getOrDefault(rank, 0) + 1);
    }

    public double getBenefitPercent(int money) {
        double sum = 0;
        for (Rank rank : Rank.values()) {
            if (results.get(rank) != null) {
                sum += results.get(rank) * rank.getMoney();
            }
        }
        return sum / money;
    }
}
