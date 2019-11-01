import java.util.ArrayList;
import java.util.Collection;

public class Suitcase extends ArrayList<Item> {

    private String name;

    public Suitcase() {
        this("");
    }

    public Suitcase(String name) {
        super();
        this.name = name;
    }

    public Suitcase(int initialCapacity) {
        super(initialCapacity);
    }

    public Suitcase(Collection<? extends Item> c) {
        super(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Suitcase{++}";
    }
}
