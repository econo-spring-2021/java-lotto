package lotto.controller;

import lotto.view.InputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputException {
    public static final int LOTTO_PRICE = 1000;
    public static final int ONE_LOTTO_TICKET_NUMBER = 6;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_FINISH_NUMBER = 45;

    public static int catchLottoMoneyException(int lottoMoney) throws IOException {
        try {
            catchInvalidMoneyInputException(lottoMoney);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            lottoMoney = InputView.moneyInput();
        }
        return lottoMoney;
    }

    public static void catchInvalidMoneyInputException(int lottoMoney) throws IOException {
        if (lottoMoney % LOTTO_PRICE != 0) {
            throw new InvalidMoneyInputException();
        }
    }

    public static int catchManualTicketsException(int lottoMoney, int manualTickets) throws IOException {
        try {
            catchInvalidManualTicketsException(lottoMoney, manualTickets);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manualTickets = InputView.manualTicketsInput();
        }
        return manualTickets;
    }

    public static void catchInvalidManualTicketsException(int lottoMoney, int manualTickets) throws IOException, InvalidManualInputException {
        int lottoTickets = lottoMoney / LOTTO_PRICE;
        if (lottoTickets < manualTickets) {
            throw new InvalidManualInputException();
        }
    }

    public static String catchManualNumbersException(String manualNumbers) throws IOException {
        try {
            catchNumbersLengthException(manualNumbers);
            catchInvalidNumbersException(manualNumbers);
            catchOverlapNumbersException(manualNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            manualNumbers = InputView.manualNumbersInput();
        }
        return manualNumbers;
    }

    public static void catchNumbersLengthException(String manualNumbers) throws NumberLengthException {
        String[] input = manualNumbers.split(",");
        if (input.length != ONE_LOTTO_TICKET_NUMBER) {
            throw new NumberLengthException();
        }
    }

    public static void catchInvalidNumbersException(String manualNumbers) throws InvalidNumbersException {
        StringTokenizer st = new StringTokenizer(manualNumbers, ",");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (number < LOTTO_START_NUMBER || number > LOTTO_FINISH_NUMBER) {
                throw new InvalidNumbersException();
            }
        }
    }

    public static void catchOverlapNumbersException(String winningNumberInput) throws OverlapNumbersException {
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(winningNumberInput, ",");
        while (st.hasMoreTokens()) {
            String number = st.nextToken();
            if (list.contains(number)) {
                throw new OverlapNumbersException();
            }
            list.add(number);
        }
    }

    public static String catchWinningNumberException(String winningNumberInput) throws IOException {
        try {
            catchNumbersLengthException(winningNumberInput);
            catchOverlapNumbersException(winningNumberInput);
            catchInvalidNumbersException(winningNumberInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            winningNumberInput = InputView.winningNumberInput();
        }
        return winningNumberInput;
    }

    public static int catchBonusBallException(ArrayList<Integer> lottoNumbers, int bonusBall) throws IOException {
        try {
            catchInvalidBonusBallException(bonusBall);
            catchOverlapBonusBallException(bonusBall, lottoNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            bonusBall = InputView.bonusBallView();
        }
        return bonusBall;
    }

    public static void catchInvalidBonusBallException(int bonusBall) throws InvalidBonusBallException {
        if (bonusBall < LOTTO_START_NUMBER || bonusBall > LOTTO_FINISH_NUMBER) {
            throw new InvalidBonusBallException();
        }
    }

    public static void catchOverlapBonusBallException(int bonusBall, ArrayList<Integer> winningNumbers) throws OverlapBonusBallException {
        if (winningNumbers.contains(bonusBall)) {
            throw new OverlapBonusBallException();
        }
    }
}
