public abstract class Item implements Comparable {

    private String material = "Cotton";
    private String color = "White";
    private String size = "Free Size";
    private String type = "";

    public Item() {
    }

    public Item(String material, String color, String size, String type) {
        this.material = material;
        this.color = color;
        this.size = size;
        this.type = type;
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

    public String getKind() {
        return this.getClass().getName();
    }

    public int getKindId() {
        switch(this.getKind()) {
            case "Shirt": return 1;
            case "Pants": return 2;
            case "Shoes": return 3;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return this.getKind()+" (" +
                " material: '" + material + '\'' +
                ", color: '" + color + '\'' +
                ", size: '" + size + '\'' +
                ", type: '" + type + '\'' +
                " )";
    }

    // enable Collections.sort()
    @Override
    public int compareTo(Object o) {
        return (this.getKindId() > ((Item) o).getKindId())?1:-1 ;
    }
}
