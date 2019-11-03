import java.util.Collections;

public class ClosetApplication {



    public static void main(String[] args) {

        // similar to Suitcase name = new Suitcase(name);
        // the new instance will be AUTO-INSTANTANEOUS when first call
        // sub sequence call, will refer to the previous instance with the same name
        // these three suitcase will be auto-registered with class Suitcase for later reference
        // A suitcase is an ArrayList<Item>, and work as an ArrayList<Item>
        // see class "Suitcase" for explanation

        Collections.addAll(Suitcase.get("Work"),
                new Shirt("Polyester", "Red", "XL", "Casual"),
                new Pants("Jeans", "Blue", "XL", "Casual"),
                new Shirt("Polyester", "Black", "XL", "Business")
        );
                
        Suitcase.get("Play");
        Suitcase.get("Vacation");

        Collections.sort(Suitcase.get("Work"));

        System.out.println(Suitcase.get("Work"));
    }

    public static void test(Item a) {
        Suitcase.get("Play");
    }
}
