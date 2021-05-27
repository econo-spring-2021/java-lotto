package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class InputView {
    public static final String MONEY_ASK_INPUT_VIEW = "구입금액을 입력해 주세요.";
    public static final int ONE_LOTTO_TICKET_NUMBER = 6;
    public static final String WINNING_NUMBER_VIEW = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_VIEW = "보너스 볼을 입력해 주세요.";
    public static final String MANUAL_TICKETS_INPUT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_NUMBERS_INPUT = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String TICKETS_COUNT_VIEW1 = "수동으로 ";
    public static final String TICKETS_COUNT_VIEW2 = "장, 자동으로 ";
    public static final String TICKETS_COUNT_VIEW3 = "장을 구매했습니다.";

    public static int moneyInput() throws IOException {
        int lottoMoney = 0;
        System.out.println(MONEY_ASK_INPUT_VIEW);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lottoMoney = Integer.parseInt(br.readLine());
        return lottoMoney;
    }

    public static int manualTicketsInput() throws IOException {
        System.out.println(MANUAL_TICKETS_INPUT);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int manualTickets = Integer.parseInt(br.readLine());
        return manualTickets;
    }

    public static void manualNumbersInputView() throws IOException {
        System.out.println(MANUAL_NUMBERS_INPUT);
    }

    public static String manualNumbersInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String manualNumbers = br.readLine();
        return manualNumbers;
    }

    public static ArrayList<Integer> setNumbers(String number) {
        ArrayList<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(number, ",");
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        return numbers;
    }

    public static void ticketsCountView(int manualTickets, int automaticTickets) {
        System.out.println(TICKETS_COUNT_VIEW1 + manualTickets + TICKETS_COUNT_VIEW2 + automaticTickets + TICKETS_COUNT_VIEW3);
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


    public static String winningNumberInput() throws IOException {
        System.out.println(WINNING_NUMBER_VIEW);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String winningNumberInput = br.readLine();

        return winningNumberInput;
    }

    public static int bonusBallView() throws IOException {
        int bonusBall = 0;

        System.out.println(BONUS_BALL_VIEW);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bonusBall = Integer.parseInt(br.readLine());

        return bonusBall;
    }
}
