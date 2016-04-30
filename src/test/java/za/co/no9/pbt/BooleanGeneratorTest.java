package za.co.no9.pbt;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BooleanGeneratorTest {
    @Test
    public void given_1000_coin_tosses_should_get_a_head_and_a_tail_at_least_once() throws Exception {
        BooleanGenerator generator = BooleanGenerator.from();

        int trueCount = 0;
        int falseCount = 0;

        for (int lp = 0; lp < 1000; lp += 1) {
            if (generator.next()) {
                trueCount += 1;
            } else {
                falseCount += 1;
            }
        }

        assertTrue(trueCount > 0);
        assertTrue(falseCount > 0);
    }
}