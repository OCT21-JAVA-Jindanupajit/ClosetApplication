public class SuitcaseBuilder extends Suitcase {

    public boolean add(Item item) {
        return super.add(item);
    }

    public boolean add(Class cls, Item item) {
        if (cls.isInstance(item)) {
            if (Closet.get().indexOf(item) > -1)
                Closet.get().remove(item);

            return this.add(item);
        }
        else
            return false;
    }

    public boolean add(Class cls) {
        if (Closet.get().isEmpty())
            return false;

        Item item = Closet.get().get(Closet.get().getRandom(cls));

        if (item == null)
            return false;
        else
            return add(cls, item);
    }



    public Suitcase toSuitcase(String name) {





        // No Shoes!
        if (this.get(Shoes.class).size() == 0) {
            Shoes shoes = (Shoes) Closet.get().get(Closet.get().getRandom(Shoes.class));
            this.add(shoes);
        }

        Suitcase.get(name).addAll(this);
        return Suitcase.get(name);
    }

}
