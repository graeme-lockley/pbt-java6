package za.co.no9.pbt;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.Gen.forAll;

public class FloatGeneratorTest {
    private static final float MIN = -3928.32f;
    private static final float MAX = 1.232f;

    @Test
    public void given_a_fixed_width_list_of_floats_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        final Generator<List<Float>> listGenerator = FloatGenerator.from(MIN, MAX).list(10, 10);

        forAll(listGenerator, new Consumer<List<Float>>() {
            @Override
            public void accept(List<Float> floats) {
                for (float f : floats) {
                    assertTrue(f >= MIN && f <= MAX);
                }
                assertEquals(10, floats.size());
            }
        });
    }
}