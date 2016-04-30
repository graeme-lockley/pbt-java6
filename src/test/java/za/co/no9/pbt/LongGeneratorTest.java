package za.co.no9.pbt;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.Gen.forAll;

public class LongGeneratorTest {
    private static final long MIN = -10L;
    private static final long MAX = 10L;

    @Test
    public void given_a_fixed_width_list_of_longs_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        final Generator<List<Long>> listGenerator = LongGenerator.from(MIN, MAX).list(10, 10);

        forAll(listGenerator, new Consumer<List<Long>>() {
            @Override
            public void accept(List<Long> longs) {
                for (long l : longs) {
                    assertTrue(l >= MIN && l <= MAX);
                }
                assertEquals(10, longs.size());
            }
        });
    }
}
