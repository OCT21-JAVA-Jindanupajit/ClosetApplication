public abstract class Item {

    private String material = "Cotton";
    private String color = "White";
    private String size = "Free Size";
    private String type = "";

    public Item() {
    }

    public Item(String material, String color, String size) {
        this.material = material;
        this.color = color;
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
