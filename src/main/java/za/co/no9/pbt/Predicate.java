package za.co.no9.pbt;

public interface Predicate<T> {
    Predicate<Integer> IS_NEGATIVE = new Predicate<Integer>() {
        @Override
        public boolean test(Integer item) {
            return item < 0;
        }
    };

    boolean test(T item);
}
