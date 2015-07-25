package kata;

import org.junit.Test;
import za.co.no9.pbt.*;

import java.util.Arrays;
import java.util.List;

import static kata.SC.add;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static za.co.no9.pbt.Gen.forAll;
import static za.co.no9.pbt.MyCollections.*;
import static za.co.no9.pbt.Predicate.IS_NEGATIVE;

public class SCTest {
    private Generator<Integer> integers = new IntegerGenerator(-2000, 2000);
    private Generator<Integer> nonNegativeIntegers = new IntegerGenerator(0, 2000);
    private Generator<List<Integer>> nonEmptyListOfIntegers = integers.nonEmptyList();
    private Generator<List<Integer>> nonEmptyListOfNonNegativeIntegers = nonNegativeIntegers.nonEmptyList();
    private Generator<Character> separators = new CharacterGenerator().filter(new Predicate<Character>() {
        @Override
        public boolean test(Character ch) {
            return !(Character.isDigit(ch) || ch == '-' || ch == '[' || ch == ']' || ch == (char) 0);
        }
    });
    private Generator<List<String>> nonEmptyListOfStringSeparators = separators.nonEmptyList().asString().nonEmptyList();

    @Test
    public void given_a_blank_should_return_0() throws Exception {
        assertEquals(0, add(""));
    }

    @Test
    public void given_a_non_negative_integer_should_return_its_value_if_less_than_1001_otherwise_0() throws Exception {
        forAll(nonNegativeIntegers, new Function<Integer>() {
            public void test(Integer n) throws Exception {
                assertEquals(normaliseInt(n), add(n.toString()));
            }
        });
    }

    @Test
    public void given_non_negative_integers_separated_with_a_comma_or_newline_should_return_the_sum_of_all_values_less_than_1001() throws Exception {
        forAll(nonEmptyListOfNonNegativeIntegers, new Function<List<Integer>>() {
            public void test(List<Integer> ns) throws Exception {
                assertEquals(sum(ns), add(mkString(ns, Arrays.asList(",", "\n"))));
            }
        });
    }

    @Test
    public void given_non_negative_integers_separated_by_a_custom_single_character_separator_should_return_the_sum_of_all_less_than_1001() throws Exception {
        forAll(nonEmptyListOfNonNegativeIntegers, separators, new Function2<List<Integer>, Character>() {
            public void test(List<Integer> ns, Character sep) throws Exception {
                assertEquals(sum(ns), add("//" + sep + "\n" + join(ns, sep.toString())));
            }
        });
    }

    @Test
    public void given_non_negative_integers_separated_by_multiple_multi_character_separator_should_return_the_sum_of_all_less_than_1001() throws Exception {
        forAll(nonEmptyListOfNonNegativeIntegers, nonEmptyListOfStringSeparators, new Function2<List<Integer>, List<String>>() {
            public void test(List<Integer> ns, List<String> seps) throws Exception {
                assertEquals(sum(ns), add("//[" + join(seps, "][") + "]\n" + mkString(ns, seps)));
            }
        });
    }

    @Test
    public void given_integers_with_at_least_one_negative_should_throw_an_exception_with_the_negative_numbers_in_the_exception_message() throws Exception {
        forAll(nonEmptyListOfIntegers.filter(new Predicate<List<Integer>>() {
            @Override
            public boolean test(List<Integer> ns) {
                return exists(ns, IS_NEGATIVE);
            }
        }), new Function<List<Integer>>() {
            @Override
            public void test(List<Integer> ns) throws Exception {
                try {
                    add(join(ns, ","));
                    fail();
                } catch (IllegalArgumentException ex) {
                    assertEquals(join(filter(ns, IS_NEGATIVE), ","), ex.getMessage());
                }
            }
        });
    }

    private <T> String mkString(List<T> ns, final List<String> separators) {
        final OneOfGenerator<String> separatorsGen = OneOfGenerator.from(separators);

        return fold(ns, new StringBuilder(), new FoldFunction<T, StringBuilder>() {
            @Override
            public StringBuilder execute(StringBuilder result, T next) {
                if (result.length() > 0) {
                    result.append(separatorsGen.next());
                }
                return result.append(next);
            }
        }).toString();
    }

    private int sum(List<Integer> ns) {
        return fold(ns, 0, new FoldFunction<Integer, Integer>() {
            @Override
            public Integer execute(Integer result, Integer next) {
                return result + normaliseInt(next);
            }
        });
    }

    private int normaliseInt(int n) {
        return n < 1001 ? n : 0;
    }
}