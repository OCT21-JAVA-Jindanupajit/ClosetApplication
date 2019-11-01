public class ClosetApplication {

    public static void main(String[] args) {
        Suitcase sc = new Suitcase();


    }

    public static void test(Item a) {
        System.out.printf("Item %s\n", a instanceof Item);
        System.out.printf("Item %s\n", a instanceof Shirt);

        System.out.printf("Item %s\n", a instanceof Garment);
    }
}
