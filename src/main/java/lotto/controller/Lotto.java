package lotto.controller;

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
}
