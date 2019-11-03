import java.util.function.Consumer;

public abstract class Garment extends Item {

    public Garment() {
    }

    public Garment(String material, String color, String size, String type) {
        super(material, color, size, type);
    }

}
