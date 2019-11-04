import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


// Allow only ONE instance of Closet which will be return by Closet.get()
// no one else can instantaneous Closet by declare "abstract"!
public abstract class Closet extends ArrayList<Item>{

    private static final Closet instance = new MyCloset();
    private static final Random r = new Random();

    private static class MyCloset extends Closet {
        public MyCloset() {
            super();
        }

    }

    public static Closet get() {

        return instance;
    }

    public Closet(int initialCapacity) {
        super(initialCapacity);
    }

    public Closet() {
    }

    public Closet(Collection<? extends Item> c) {
        super(c);
    }

    public boolean addAll(Item... items) {
        return Collections.addAll(this, items);
    }


    public int getRandom() {

        return r.nextInt(this.size());
    }

    public int getRandom(Class cls) {


        Closet c = new MyCloset();
        for (Item i : this) {
            if (cls.isInstance(i)) {
                c.add(i);
            }
        }

        if (c.size() == 0)
            return -1;
        else
            return this.indexOf(c.get(r.nextInt(c.size())));
    }

    public boolean  has(Class cls) {

        for (Item i : this) {
            if (cls.isInstance(i))
                return true;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();
        for (Item item : this) {
            if (content.length() > 0)
                content.append("\n\t");
            else
                content.append("\t");
            content.append(item);
        }

        return String.format("Closet : \n%s\n",content);
    }
}
