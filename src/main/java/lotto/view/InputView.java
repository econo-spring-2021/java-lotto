package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private Scanner scanner;
    private Integer inputMoney;
    private String winningLottoNumbers;
    private Integer bonusBall;
    private Integer manualLottoCount;

    public Integer inputMoney() {
        scanner = new Scanner(System.in);
        inputMoney = scanner.nextInt();
        return inputMoney;
    }

    public Integer inputManualLottoCount() {
        scanner = new Scanner(System.in);
        manualLottoCount = scanner.nextInt();
        return manualLottoCount;
    }

    public List<LottoNumber> inputLottoNumbers() {
        scanner = new Scanner(System.in);
        winningLottoNumbers = scanner.nextLine();
        winningLottoNumbers = eliminateSpaceBlank(winningLottoNumbers);
        List<LottoNumber> lottoNumbers = splitCommaFromStringInput(winningLottoNumbers);
        return lottoNumbers;
    }


    public String eliminateSpaceBlank(String stringContainingSpaceBlank) {
        return stringContainingSpaceBlank.trim().replace(Constants.SPACE, Constants.EMPTY);
    }

    public List<LottoNumber> splitCommaFromStringInput(String stringContainingComma) {
        return Arrays.asList(stringContainingComma.split(Constants.DELIMITER))
                .stream()
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    public Integer inputBonusBallNumber() {
        scanner = new Scanner(System.in);
        bonusBall = scanner.nextInt();
        return bonusBall;
    }

}
