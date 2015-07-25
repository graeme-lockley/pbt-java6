package za.co.no9.pbt;

public class AsStringGenerator extends AbstractGenerator<String> {
    private Generator generator;
    private final String separator;

    public AsStringGenerator(Generator generator, String separator) {
        this.generator = generator;
        this.separator = separator;
    }

    @Override
    public String next() {
        return generator.next(separator);
    }
}
