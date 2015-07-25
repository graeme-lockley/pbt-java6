package za.co.no9.pbt;

import java.util.List;

public class OneOfGenerator<T> extends AbstractGenerator<T> {
    private final List<T> elements;
    private final IntegerGenerator elementChooser;

    private OneOfGenerator(List<T> elements) {
        this.elements = elements;
        this.elementChooser = new IntegerGenerator(0, elements.size() - 1);
    }

    public static <T> OneOfGenerator<T> from(List<T> elements) {
        return new OneOfGenerator<T>(elements);
    }

    @Override
    public T next() {
        return elements.get(elementChooser.next());
    }
}
