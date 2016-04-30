package za.co.no9.pbt;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.Gen.forAll;

public class IntegerGeneratorTest {
    private static final int MIN = -1244;
    private static final int MAX = 942672;

    @Test
    public void given_a_fixed_width_list_of_generator_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        final Generator<List<Integer>> listGenerator = IntegerGenerator.from(MIN, MAX).list(10, 10);

        forAll(listGenerator, new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                for (int i : integers) {
                    assertTrue(i >= MIN && i <= MAX);
                }
                assertEquals(10, integers.size());
            }
        });
    }
}