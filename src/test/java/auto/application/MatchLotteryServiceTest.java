package auto.application;

import auto.domain.Lotto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class MatchLottoServiceTest {
    private final MatchLottoService matchLottoService = new MatchLottoService();

    @Test
    void getMatchedCountMapTest() {
        // given
        var lotteryNumbersList = List.of(
                new Lotto(List.of(1, 2, 3, 9, 10, 11)),

                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),

                new Lotto(List.of(1, 2, 3, 4, 5, 11)),
                new Lotto(List.of(1, 2, 3, 4, 5, 11)),
                new Lotto(List.of(1, 2, 3, 4, 5, 11)));
        var winningNumbersLastWeek = List.of(1, 2, 3, 4, 5, 6);
        // when
        Map<MatchedAmount, Integer> matchedCountMap = matchLottoService.getMatchedCountMap(lotteryNumbersList, winningNumbersLastWeek, 9);
        // then
        SoftAssertions.assertSoftly(assertions -> {
            assertions.assertThat(matchedCountMap.get(MatchedAmount.THREE)).isEqualTo(1);
            assertions.assertThat(matchedCountMap.get(MatchedAmount.FOUR)).isEqualTo(2);
            assertions.assertThat(matchedCountMap.get(MatchedAmount.FIVE)).isEqualTo(3);
            assertions.assertThat(matchedCountMap.get(MatchedAmount.SIX)).isEqualTo(0);
        });
    }
}
