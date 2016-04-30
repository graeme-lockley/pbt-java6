package za.co.no9.pbt;

public class ByteGenerator extends AbstractGenerator<Byte> {
    private final Generator<Integer> generator;

    private ByteGenerator(byte min, byte max) {
        generator = IntegerGenerator.from((int) min, (int) max);
    }

    public static ByteGenerator from() {
        return new ByteGenerator(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }

    public static ByteGenerator from(byte min, byte max) {
        return new ByteGenerator(min, max);
    }

    @Override
    public Byte next() {
        return (byte) generator.next().intValue();
    }
}
