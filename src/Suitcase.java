import java.util.*;


public abstract class Suitcase extends ArrayList<Item>{

//    Note: Instantaneous is controller by inner class "MySuitcase" through Suitcase.get(String)
//    We need to register all instance

    private static HashMap<String, Suitcase> instanceCollection = new HashMap<>();

    // helper class to work around abstract restriction
    private static class MySuitcase extends Suitcase {
        public MySuitcase(String name) {
            super(name);
        }

    }

    private static Suitcase getNewInstance(String name) {
        if (instanceCollection.containsKey(name)) {
            // If duplicate, throw exception
            // but first remove the last reference to this method, so people can go to the right line of code

            // Create an exception
            IllegalArgumentException ex = new IllegalArgumentException("A suitcase '" + name + "' is already existed!");
            // retrieve stack trace
            StackTraceElement[] stack = ex.getStackTrace();
            // remove the last element which refer to this method
            ex.setStackTrace(Arrays.copyOfRange(stack,1,stack.length));

            // throw it!
            throw ex;

        }
        // put new instance and it's name (as key)
        // MySuitcase is polymorphism (can become Suitcase)
        instanceCollection.put(name, new MySuitcase(name));

        return instanceCollection.get(name);
    }

    // Suitcase.get(name) will be available globally
    public static Suitcase get(String name) {
        if (instanceCollection.containsKey(name))
           return instanceCollection.get(name);
        else
           return getNewInstance(name);
    }

    // destroy a suitcase
    public static Suitcase destroy(String name) {
        if (instanceCollection.containsKey(name))
            return instanceCollection.remove(name);
        else
            return null;
    }

    public static Boolean has(String name) {
        return instanceCollection.containsKey(name);
    }

    private String name;

    // instantaneous not allowed
    public Suitcase() {
        this("<no name>");
    }

    // instantaneous not allowed
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
        Suitcase i;
        if (! instanceCollection.containsKey(name)) {
            i = instanceCollection.remove(this.name);
            instanceCollection.put(name,i);
            this.name = name;
        } else {
            // duplicate
        }


    }

    public Suitcase get(Class cls) {


        Suitcase sc = new MySuitcase(cls.getName());
        for (Item i : this) {
            if (cls.isInstance(i)) {
                sc.add(i);
            }
        }

        return sc;
    }

    public static HashMap<String, Suitcase> getAll() {
        return instanceCollection;
    }
    public boolean addAll(Item... items) {
        return Collections.addAll(this, items);
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

        return String.format("Suitcase (%s): \n%s\n",this.name,content);
    }
}
