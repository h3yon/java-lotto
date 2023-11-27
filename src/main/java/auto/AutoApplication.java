package auto;

import auto.application.AutoService;
import auto.application.MatchService;
import auto.view.InputView;
import auto.view.ResultView;

import java.util.List;
import java.util.Map;

public class AutoApplication {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lotteryCount = purchaseAmount / LOTTO_PRICE;
        ResultView.printLottoCounts(lotteryCount);

        List<List<Integer>> totalLotteryNumbers = AutoService.createLotteryNumbersList(lotteryCount);
        ResultView.printTotalLotteryNumbers(totalLotteryNumbers);

        List<Integer> winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        Map<Integer, Integer> matchedCountMap = MatchService.getMatchedCountMap(totalLotteryNumbers, winningNumbersLastWeek);
        ResultView.printLotteryStats(matchedCountMap, purchaseAmount);
    }
}
