package za.co.no9.pbt;

import java.util.List;
import java.util.Set;

public abstract class AbstractGenerator<T> implements Generator<T> {
    @Override
    public String next(String separator) {
        return next().toString();
    }

    @Override
    public Generator<List<T>> list() {
        return new ListOfGenerator<T>(this);
    }

    @Override
    public Generator<List<T>> list(int minLength, int maxLength) {
        final ListOfGenerator<T> listOfGenerator = new ListOfGenerator<T>(this);
        listOfGenerator.setLengthRange(minLength, maxLength);
        return listOfGenerator;
    }

    @Override
    public Generator<List<T>> nonEmptyList() {
        return new NonEmptyListOfGenerator<T>(this);
    }

    @Override
    public Generator<Set<T>> set() {
        return new SetOfGenerator<T>(this);
    }

    @Override
    public Generator<Set<T>> set(int minimumIteration, int maximumIteration) {
        final SetOfGenerator<T> listOfGenerator = new SetOfGenerator<T>(this);
        listOfGenerator.setIteration(minimumIteration, maximumIteration);
        return listOfGenerator;
    }

    @Override
    public Generator<Set<T>> nonEmptySet() {
        return new NonEmptySetOfGenerator<T>(this);
    }


    @Override
    public Generator<T> filter(Predicate<T> predicate) {
        return new FilterGenerator<T>(this, predicate);
    }

    @Override
    public Generator<String> asString() {
        return asString("");
    }

    @Override
    public Generator<String> asString(String separator) {
        return new AsStringGenerator(this, separator);
    }
}
