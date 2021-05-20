package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static final String moneyAskInputView = "구입금액을 입력해 주세요.";
    public static final int lottoPrice = 1000;
    public static final String ticketsNumberView = "개를 구매했습니다.";

    public static int moneyInput() throws IOException{
        int lottoMoney =0;
        try{
            System.out.println(moneyAskInputView);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            lottoMoney = Integer.parseInt(br.readLine());
            catchInvalidMoneyInputException(lottoMoney);

        }catch (Exception e){
            System.out.println(e.getMessage());
            moneyInput();
        }
        return lottoMoney;
    }

    public static void catchInvalidMoneyInputException(int lottoMoney) throws IOException {
        if (lottoMoney % lottoPrice != 0) {
            throw new InvalidMoneyInputException();
        }
    }

    public static int ticketsNumberView(int lottoMoney){
        int lottoTickets = lottoMoney / lottoPrice;
        System.out.println(lottoTickets+ticketsNumberView);
        return lottoTickets;
    }
}
