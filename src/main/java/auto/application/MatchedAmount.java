package auto.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum MatchedAmount {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000),
    NONE(0, 0);

    private static final Map<Integer, MatchedAmount> MATCHED_AMOUNT_MAP = new HashMap<>();

    private final int count;
    private final int amount;

    static {
        Arrays.asList(values())
              .forEach(enumValue -> MATCHED_AMOUNT_MAP.put(enumValue.count, enumValue));
    }

    MatchedAmount(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public static MatchedAmount findByCount(int count, boolean isMatchedBonus) { // findByNumberWithMatchedBonus
        if (count == FIVE.getCount()) {
            return isMatchedBonus ? FIVE_AND_BONUS : FIVE;
        }
        if (!MATCHED_AMOUNT_MAP.containsKey(count)) {
            return NONE;
        }
        return MATCHED_AMOUNT_MAP.get(count);
    }

    public static boolean isMatchedNumberFiveAndBonus(MatchedAmount matchedAmount) {
        return FIVE_AND_BONUS == matchedAmount;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }
}
