package za.co.no9.pbt;

public class LongGenerator extends AbstractGenerator<Long> {
    private final long min;
    private final long max;

    private LongGenerator(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public static Generator<Long> from() {
        return new LongGenerator(Long.MIN_VALUE, Long.MAX_VALUE - 1);
    }

    public static Generator<Long> from(long min, long max) {
        if (max == Long.MAX_VALUE) {
            throw new IllegalArgumentException("Unable to support max value of Long.MAX_VALUE");
        }
        return new LongGenerator(min, max);
    }

    @Override
    public Long next() {
        return (long) ((Math.random() * (max - min)) + min + 0.5);
    }
}
