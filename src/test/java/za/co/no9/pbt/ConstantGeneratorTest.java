package za.co.no9.pbt;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ConstantGeneratorTest {
    private static final String STRING_CONSTANT = "Hello world";
    private static final long LONG_CONSTANT = 12345L;

    @Test
    public void should_return_a_constant_string() throws Exception {
        Generator<String> generator = new ConstantGenerator<String>(STRING_CONSTANT);
        assertEquals(STRING_CONSTANT, generator.next());
    }

    @Test
    public void should_return_a_list_of_strings() throws Exception {
        Generator<List<String>> generator = new ConstantGenerator<String>(STRING_CONSTANT).nonEmptyList();

        for (String value : generator.next()) {
            assertEquals(STRING_CONSTANT, value);
        }
    }

    @Test
    public void should_return_a_set_of_strings() throws Exception {
        Generator<Set<String>> generator = new ConstantGenerator<String>(STRING_CONSTANT).nonEmptySet();

        for (String value : generator.next()) {
            assertEquals(STRING_CONSTANT, value);
        }
    }

    @Test
    public void should_return_a_constant_long() throws Exception {
        Generator<Long> generator = new ConstantGenerator<Long>(LONG_CONSTANT);
        assertEquals(LONG_CONSTANT, (long) generator.next());
    }

    @Test
    public void should_return_a_list_of_longs() throws Exception {
        Generator<List<Long>> generator = new ConstantGenerator<Long>(LONG_CONSTANT).nonEmptyList();

        for (long value : generator.next()) {
            assertEquals(LONG_CONSTANT, value);
        }
    }

    @Test
    public void should_return_a_set_of_longs() throws Exception {
        Generator<Set<Long>> generator = new ConstantGenerator<Long>(LONG_CONSTANT).nonEmptySet();

        for (long value : generator.next()) {
            assertEquals(LONG_CONSTANT, value);
        }
    }
}
