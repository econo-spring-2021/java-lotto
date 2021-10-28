package lotto;

import lotto.controller.GameController;
import lotto.controller.InvalidInputMoneyException;

public class Application {
    public static void main(String[] args) throws InvalidInputMoneyException {
        GameController game = new GameController();
        game.lottoPurchase();
        game.winningBallInput();
        int income = game.lottoPrizeCalculate(game.lottoResultShow());
        game.lottoBenefitShow(income);
    }
}
