package za.co.no9.pbt;

public class CharacterGenerator extends AbstractGenerator<Character> {
    private final Generator<Integer> generator;

    protected CharacterGenerator() {
        this((char) 0, (char) 255);
    }

    protected CharacterGenerator(char min, char max) {
        generator = new IntegerGenerator((int) min, (int) max);
    }

    public static CharacterGenerator from() {
        return new CharacterGenerator();
    }

    public static CharacterGenerator from(char min, char max) {
        return new CharacterGenerator(min, max);
    }

    @Override
    public Character next() {
        return (char) generator.next().intValue();
    }
}
