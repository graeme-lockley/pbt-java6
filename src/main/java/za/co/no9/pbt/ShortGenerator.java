package za.co.no9.pbt;

public class ShortGenerator extends AbstractGenerator<Short> {
    private final short min;
    private final short max;

    private ShortGenerator(short min, short max) {
        this.min = min;
        this.max = max;
    }

    public static Generator<Short> from() {
        return new ShortGenerator(Short.MIN_VALUE, Short.MAX_VALUE);
    }

    public static Generator<Short> from(short min, short max) {
        return new ShortGenerator(min, max);
    }

    @Override
    public Short next() {
        return (short) ((Math.random() * (max - min)) + min + 0.5);
    }
}
