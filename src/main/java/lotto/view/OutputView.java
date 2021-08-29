package lotto.view;

import lotto.domain.LottoTicket;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void inputMoneyMessage() {
        System.out.println(Constants.INPUT_MONEY_MESSAGE);
    }

    public static void printLottoCountMessage(int lottoCount) {
        System.out.println(String.format(Constants.PURCHASE_NUMBER_PRINT_MESSAGE, lottoCount));
    }

    public static void printLottoTicketMessage(LottoTicket lottoTicket, int lottoCount) {
        for(int i = 0; i < lottoCount; i++) {
            System.out.println(String.format(Constants.LOTTO_TICKET_PRINT_MESSAGE,
                    lottoTicket.getLottos().get(i).getLottoNumbers().get(0).getNumber(),
                    lottoTicket.getLottos().get(i).getLottoNumbers().get(1).getNumber(),
                    lottoTicket.getLottos().get(i).getLottoNumbers().get(2).getNumber(),
                    lottoTicket.getLottos().get(i).getLottoNumbers().get(3).getNumber(),
                    lottoTicket.getLottos().get(i).getLottoNumbers().get(4).getNumber(),
                    lottoTicket.getLottos().get(i).getLottoNumbers().get(5).getNumber()
                    ));
        }
    }

    public static void inputSixDigitNumbersMessage() {
        System.out.println(Constants.SIX_DIGIT_NUMBERS_INPUT_MESSAGE);
    }

    public static void inputBonusNumberMessage() {
        System.out.println(Constants.BONUS_BALL_INPUT_MESSAGE);
    }

    public static void printWinningStatistics() {
        System.out.println(Constants.WINNING_STATISTICS_MESSAGE);
        System.out.println(Constants.LINE_MADE_BY_HYPHEN_MESSAGE);
    }
}
