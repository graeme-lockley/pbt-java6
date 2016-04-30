package za.co.no9.pbt;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.PBT.forAll;

public class SetOfGeneratorTest {
    private static final int MINIMUM_ITERATION = 5;
    private static final int MAXIMUM_ITERATION = 15;

    private static final int MINIMUM_INTEGER = -100;
    private static final int MAXIMUM_INTEGER = 100;

    @Test
    public void should_return_sets_within_limits() throws Exception {
        SetOfGenerator<Integer> setOfNumbers = new SetOfGenerator<Integer>(IntegerGenerator.from(MINIMUM_INTEGER, MAXIMUM_INTEGER));
        setOfNumbers.setIteration(MINIMUM_ITERATION, MAXIMUM_ITERATION);

        final int ranges[] = new int[2];
        ranges[0] = MAXIMUM_ITERATION;
        ranges[1] = MINIMUM_ITERATION;

        forAll(setOfNumbers, new Function<java.util.Set<Integer>>() {
            @Override
            public void test(Set<Integer> ns) throws Exception {
                ranges[0] = Math.min(ranges[0], ns.size());
                ranges[1] = Math.max(ranges[1], ns.size());

                assertTrue(ns.size() >= Math.min(1, MAXIMUM_ITERATION));
                assertTrue(ns.size() <= MAXIMUM_ITERATION);

                for (int n : ns) {
                    assertTrue(n >= MINIMUM_INTEGER);
                    assertTrue(n <= MAXIMUM_INTEGER);
                }
            }
        });

        assertTrue(Math.min(1, MAXIMUM_ITERATION) <= ranges[0]);
        assertTrue(MAXIMUM_ITERATION >= ranges[1]);
    }
}