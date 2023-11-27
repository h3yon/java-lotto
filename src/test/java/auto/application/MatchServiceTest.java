package auto.application;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class MatchServiceTest {
    private final MatchService matchService = new MatchService();
    @Test
    void getMatchedCountMapTest() {
        // given
        var lotteryNumbersList = List.of(
                List.of(1, 2, 3, 9, 10, 11),

                List.of(1, 2, 3, 4, 10, 11),
                List.of(1, 2, 3, 4, 10, 11),

                List.of(1, 2, 3, 4, 5, 11),
                List.of(1, 2, 3, 4, 5, 11),
                List.of(1, 2, 3, 4, 5, 11));
        var winningNumbersLastWeek = List.of(1, 2, 3, 4, 5, 6);
        // when
        Map<Integer, Integer> matchedCountMap = matchService.getMatchedCountMap(lotteryNumbersList, winningNumbersLastWeek);
        // then
        SoftAssertions.assertSoftly(assertions -> {
            assertions.assertThat(matchedCountMap.get(3)).isEqualTo(1);
            assertions.assertThat(matchedCountMap.get(4)).isEqualTo(2);
            assertions.assertThat(matchedCountMap.get(5)).isEqualTo(3);
            assertions.assertThat(matchedCountMap.get(6)).isEqualTo(0);
        });
    }
}
