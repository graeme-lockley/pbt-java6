package za.co.no9.pbt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyCollections {
    public static String join(Collection collection) {
        return join(collection, "");
    }

    public static String join(Collection collection, String separator) {
        StringBuilder sb = new StringBuilder();
        for (Object o : collection) {
            sb.append(separator).append(o.toString());
        }
        return sb.substring(separator.length());
    }

    public static <T> List<T> filter(List<T> items, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> boolean exists(List<T> items, Predicate<T> predicate) {
        for (T item : items) {
            if (predicate.test(item)) {
                return true;
            }
        }
        return false;
    }

    public static <S> S fold(List<S> items, FoldFunction<S, S> foldFunction) {
        Iterator<S> iterator = items.iterator();
        S first = iterator.next();
        return fold(iterator, first, foldFunction);
    }

    public static <S, T> T fold(List<S> items, T initial, FoldFunction<S, T> foldFunction) {
        return fold(items.iterator(), initial, foldFunction);
    }

    private static <S, T> T fold(Iterator<S> items, T initial, FoldFunction<S, T> foldFunction) {
        T result = initial;
        while (items.hasNext()) {
            result = foldFunction.execute(result, items.next());
        }
        return result;
    }

    public static <T> List<T> times(int n, Supplier<T> supplier) {
        List<T> result = new ArrayList<T>();

        for (int lp = 0; lp < n; lp += 1) {
            result.add(supplier.get());
        }

        return result;
    }

    public static <T> void each(List<T> items, Consumer<T> consumer) {
        for (T item : items) {
            consumer.accept(item);
        }
    }
}
