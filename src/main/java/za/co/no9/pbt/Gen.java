package za.co.no9.pbt;

public class Gen {
    public static int ITERATIONS = 1000;

    public static <T> void forAll(Generator<T> gen1, Consumer<T> consumer) throws Exception {
        for (int i = 0; i < ITERATIONS; i += 1) {
            consumer.accept(gen1.next());
        }
    }

    public static <T1, T2> void forAll(Generator<T1> gen1, Generator<T2> gen2, Consumer2<T1, T2> function) throws Exception {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next());
        }
    }

    public static <T1, T2, T3> void forAll(Generator<T1> gen1, Generator<T2> gen2, Generator<T3> gen3, Consumer3<T1, T2, T3> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next(), gen3.next());
        }
    }

    public static <T1, T2, T3, T4> void forAll(Generator<T1> gen1, Generator<T2> gen2, Generator<T3> gen3, Generator<T4> gen4, Consumer4<T1, T2, T3, T4> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next(), gen3.next(), gen4.next());
        }
    }

    public static <T1, T2, T3, T4, T5> void forAll(Generator<T1> gen1, Generator<T2> gen2, Generator<T3> gen3, Generator<T4> gen4, Generator<T5> gen5, Consumer5<T1, T2, T3, T4, T5> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next(), gen3.next(), gen4.next(), gen5.next());
        }
    }

    public static <T1, T2, T3, T4, T5, T6> void forAll(Generator<T1> gen1, Generator<T2> gen2, Generator<T3> gen3, Generator<T4> gen4, Generator<T5> gen5, Generator<T6> gen6, Consumer6<T1, T2, T3, T4, T5, T6> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next(), gen3.next(), gen4.next(), gen5.next(), gen6.next());
        }
    }

    public static <T1, T2, T3, T4, T5, T6, T7> void forAll(Generator<T1> gen1, Generator<T2> gen2, Generator<T3> gen3, Generator<T4> gen4, Generator<T5> gen5, Generator<T6> gen6, Generator<T7> gen7, Consumer7<T1, T2, T3, T4, T5, T6, T7> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next(), gen3.next(), gen4.next(), gen5.next(), gen6.next(), gen7.next());
        }
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8> void forAll(Generator<T1> gen1, Generator<T2> gen2, Generator<T3> gen3, Generator<T4> gen4, Generator<T5> gen5, Generator<T6> gen6, Generator<T7> gen7, Generator<T8> gen8, Consumer8<T1, T2, T3, T4, T5, T6, T7, T8> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next(), gen3.next(), gen4.next(), gen5.next(), gen6.next(), gen7.next(), gen8.next());
        }
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> void forAll(Generator<T1> gen1, Generator<T2> gen2, Generator<T3> gen3, Generator<T4> gen4, Generator<T5> gen5, Generator<T6> gen6, Generator<T7> gen7, Generator<T8> gen8, Generator<T9> gen9, Consumer9<T1, T2, T3, T4, T5, T6, T7, T8, T9> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next(), gen3.next(), gen4.next(), gen5.next(), gen6.next(), gen7.next(), gen8.next(), gen9.next());
        }
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> void forAll(Generator<T1> gen1, Generator<T2> gen2, Generator<T3> gen3, Generator<T4> gen4, Generator<T5> gen5, Generator<T6> gen6, Generator<T7> gen7, Generator<T8> gen8, Generator<T9> gen9, Generator<T10> gen10, Consumer10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> function) {
        for (int i = 0; i < ITERATIONS; i += 1) {
            function.accept(gen1.next(), gen2.next(), gen3.next(), gen4.next(), gen5.next(), gen6.next(), gen7.next(), gen8.next(), gen9.next(), gen10.next());
        }
    }
}
