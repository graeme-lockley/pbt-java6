package za.co.no9.pbt;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static za.co.no9.pbt.Gen.forAll;
import static za.co.no9.pbt.MyCollections.each;

public class ListOfGeneratorTest {
    private static final int MINIMUM_LENGTH = 5;
    private static final int MAXIMUM_LENGTH = 15;

    private static final int MINIMUM_INTEGER = 0;
    private static final int MAXIMUM_INTEGER = 10;

    @Test
    public void should_return_lists_within_limits() throws Exception {
        ListOfGenerator<Integer> listOfNumbers = new ListOfGenerator<Integer>(new IntegerGenerator(MINIMUM_INTEGER, MAXIMUM_INTEGER));
        listOfNumbers.setLengthRange(MINIMUM_LENGTH, MAXIMUM_LENGTH);

        final int ranges[] = new int[2];
        ranges[0] = MAXIMUM_LENGTH;
        ranges[1] = MINIMUM_LENGTH;

        forAll(listOfNumbers, new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> ns) throws Exception {
                ranges[0] = Math.min(ranges[0], ns.size());
                ranges[1] = Math.max(ranges[1], ns.size());

                assertTrue(ns.size() >= MINIMUM_LENGTH);
                assertTrue(ns.size() <= MAXIMUM_LENGTH);

                each(ns, new Consumer<Integer>() {
                    @Override
                    public void accept(Integer n) {
                        assertTrue(n >= MINIMUM_INTEGER);
                        assertTrue(n <= MAXIMUM_INTEGER);
                    }
                });
            }
        });

        assertEquals(MINIMUM_LENGTH, ranges[0]);
        assertEquals(MAXIMUM_LENGTH, ranges[1]);
    }
}