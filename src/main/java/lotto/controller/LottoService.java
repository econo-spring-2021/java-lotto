package lotto.controller;

import lotto.view.InvalidLottoNumebrsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class LottoService {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private int randomGive(){
        return (int)(Math.random()*45)+1;
    }
    private HashSet<Integer> validateDuplicate(){
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>(LOTTO_NUMBERS_SIZE);
        for (int i=0; i<LOTTO_NUMBERS_SIZE; i++){
            nonDuplicateNumbers.add(randomGive());
        }
        return nonDuplicateNumbers;
    }

    private ArrayList<Integer> validateSize(HashSet<Integer> nonDuplicateNumbers) throws InvalidLottoNumebrsException {
        ArrayList<Integer>lottoNumbers = new ArrayList<>(nonDuplicateNumbers);
        if(lottoNumbers.size()<LOTTO_NUMBERS_SIZE)
            throw  new InvalidLottoNumebrsException();
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

}
