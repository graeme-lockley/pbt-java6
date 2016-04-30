package za.co.no9.pbt;

public class DoubleGenerator extends AbstractGenerator<Double> {
    private final double min;
    private final double max;

    private DoubleGenerator(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public static Generator<Double> from() {
        return new DoubleGenerator(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public static Generator<Double> from(double min, double max) {
        return new DoubleGenerator(min, max);
    }

    @Override
    public Double next() {
        return (Math.random() * (max - min)) + min;
    }
}
