package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class InputView {
    public static final String MONEY_ASK_INPUT_VIEW = "구입금액을 입력해 주세요.";
    public static final int LOTTO_PRICE = 1000;
    public static final String TICKETS_NUMBER_VIEW = "개를 구매했습니다.";
    public static final int ONE_LOTTO_TICKET_NUMBER = 6;
    public static final String WINNING_NUMBER_VIEW = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_VIEW = "보너스 볼을 입력해 주세요.";
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_FINISH_NUMBER = 45;

    public static int moneyInput() throws IOException {
        int lottoMoney = 0;
        try {
            System.out.println(MONEY_ASK_INPUT_VIEW);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            lottoMoney = Integer.parseInt(br.readLine());
            catchInvalidMoneyInputException(lottoMoney);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            moneyInput();
        }
        return lottoMoney;
    }

    public static void catchInvalidMoneyInputException(int lottoMoney) throws IOException {
        if (lottoMoney % LOTTO_PRICE != 0) {
            throw new InvalidMoneyInputException();
        }
    }

    public static int ticketsNumberView(int lottoMoney) {
        int lottoTickets = lottoMoney / LOTTO_PRICE;
        System.out.println(lottoTickets + TICKETS_NUMBER_VIEW);
        return lottoTickets;
    }

    public static void lottoNumbersView(ArrayList<Integer> lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(lottoNumbers.get(0));
        for (int i = 1; i < ONE_LOTTO_TICKET_NUMBER; i++) {
            sb.append(", " + lottoNumbers.get(i));
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static ArrayList<Integer> winningNumberInput() {
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        try {
            System.out.println(WINNING_NUMBER_VIEW);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String winningNumberInput = br.readLine();
            catchWinningNumberLengthException(winningNumberInput);
            catchOverlapWinningNumberException(winningNumberInput);
            catchInvalidWinningNumberException(winningNumberInput);
            StringTokenizer st = new StringTokenizer(winningNumberInput, ",");
            while (st.hasMoreTokens()) {
                winningNumbers.add(Integer.parseInt(st.nextToken()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            winningNumberInput();
        }
        return winningNumbers;
    }

    public static void catchWinningNumberLengthException(String winningNumberInput) throws WinningNumberLengthException {
        String[] input = winningNumberInput.split(",");
        if (input.length != ONE_LOTTO_TICKET_NUMBER) {
            throw new WinningNumberLengthException();
        }
    }

    public static void catchInvalidWinningNumberException(String winningNumberInput) throws InvalidWinningNumberException {
        StringTokenizer st = new StringTokenizer(winningNumberInput, ",");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (number < LOTTO_START_NUMBER || number > LOTTO_FINISH_NUMBER) {
                throw new InvalidWinningNumberException();
            }
        }
    }

    public static void catchOverlapWinningNumberException(String winningNumberInput) throws OverlapWinningNumberException {
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(winningNumberInput, ",");
        while (st.hasMoreTokens()) {
            String number = st.nextToken();
            if (list.contains(number)) {
                throw new OverlapWinningNumberException();
            }
            list.add(number);
        }
    }

    public static int bonusBallView(ArrayList<Integer> lottoNumbers){
        int bonusBall = 0;
        try {
            System.out.println(BONUS_BALL_VIEW);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            bonusBall = Integer.parseInt(br.readLine());
            catchInvalidBonusBallException(bonusBall);
            catchOverlapBonusBallException(bonusBall,lottoNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
           bonusBallView(lottoNumbers);
        }
        return bonusBall;
    }

    public static void catchInvalidBonusBallException(int bonusBall) throws InvalidBonusBallException {
        if(bonusBall < LOTTO_START_NUMBER || bonusBall >LOTTO_FINISH_NUMBER){
            throw new InvalidBonusBallException();
        }
    }

    public static void catchOverlapBonusBallException(int bonusBall, ArrayList<Integer> winningNumbers) throws OverlapBonusBallException {
        if(winningNumbers.contains(bonusBall)){
            throw new OverlapBonusBallException();
        }
    }
}
