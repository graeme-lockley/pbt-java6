package za.co.no9.pbt;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.PBT.forAll;

public class ShortGeneratorTest {
    private static final short MIN = (short) -10;
    private static final short MAX = (short) 10;

    @Test
    public void given_a_fixed_width_list_of_shorts_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        final Generator<List<Short>> listGenerator = ShortGenerator.from(MIN, MAX).list(10, 10);

        forAll(listGenerator, new Function<List<Short>>() {
            @Override
            public void test(List<Short> shorts) throws Exception {
                for (short s : shorts) {
                    assertTrue(s >= MIN && s <= MAX);
                }
                assertEquals(10, shorts.size());
            }
        });
    }
}