package za.co.no9.pbt;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.PBT.forAll;

public class DoubleGeneratorTest {
    private static final double MIN = -3928.32;
    private static final double MAX = 1.232;

    @Test
    public void given_a_fixed_width_list_of_doubles_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        final Generator<List<Double>> listGenerator = DoubleGenerator.from(MIN, MAX).list(10, 10);

        forAll(listGenerator, new Function<List<Double>>() {
            @Override
            public void test(List<Double> doubles) throws Exception {
                for (double d : doubles) {
                    assertTrue(d >= MIN && d <= MAX);
                }
                assertEquals(10, doubles.size());
            }
        });
    }
}