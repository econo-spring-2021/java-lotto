package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static final String moneyAskInputView = "구입금액을 입력해 주세요.";
    public static final int lottoPrice = 1000;

    public static void moneyInput() throws IOException{
        try{
            System.out.println(moneyAskInputView);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int lottoMoney = Integer.parseInt(br.readLine());
            catchInvalidMoneyInputException(lottoMoney);
        }catch (Exception e){
            System.out.println(e.getMessage());
            moneyInput();
        }


    }

    public static void catchInvalidMoneyInputException(int lottoMoney) throws IOException {
        if (lottoMoney % lottoPrice != 0) {
            throw new InvalidMoneyInputException();
        }
    }
}
