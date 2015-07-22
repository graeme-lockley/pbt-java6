package za.co.no9.pbt;

import java.util.List;

public class AppendGenerator extends AbstractGenerator<String> {
    private Generator generator;
    private final String separator;

    public AppendGenerator(Generator generator, String separator) {
        this.generator = generator;
        this.separator = separator;
    }

    @Override
    public String next() {
        Object object = generator.next();

        if (object instanceof List) {
            StringBuilder sb = new StringBuilder();
            List list = (List) object;
            boolean isFirst = true;
            for (Object item : list) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    sb.append(separator);
                }
                sb.append(item.toString());
            }
            return sb.toString();
        } else {
            return object.toString();
        }
    }
}
