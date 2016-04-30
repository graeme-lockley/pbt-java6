package za.co.no9.pbt;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.PBT.forAll;

public class ByteGeneratorTest {
    private static final byte MIN = (byte) 5;
    private static final byte MAX = (byte) 10;

    @Test
    public void given_a_fixed_width_list_of_bytes_then_the_lists_should_be_of_the_prescribed_length() throws Exception {
        final Generator<List<Byte>> listGenerator = ByteGenerator.from(MIN, MAX).list(10, 10);

        forAll(listGenerator, new Function<List<Byte>>() {
            @Override
            public void test(List<Byte> bytes) throws Exception {
                for (byte b : bytes) {
                    assertTrue(b >= MIN && b <= MAX);
                }
                assertEquals(10, bytes.size());
            }
        });
    }
}
