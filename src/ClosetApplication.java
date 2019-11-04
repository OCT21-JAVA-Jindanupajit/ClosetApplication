import lang.JaVALOR.utils.ConsoleMenu.ConsoleMenu;
import lang.JaVALOR.utils.ConsoleMenu.MenuItem;
import lang.JaVALOR.utils.KeyboardScanner.KeyboardScanner;

import java.util.Collections;

public class ClosetApplication {



    public static void main(String[] args) {

        // similar to Suitcase name = new Suitcase(name);
        // the new instance will be AUTO-INSTANTANEOUS when first call
        // sub sequence call, will refer to the previous instance with the same name
        // these three suitcase will be auto-registered with class Suitcase for later reference
        // A suitcase is an ArrayList<Item>, and work as an ArrayList<Item>
        // see class "Suitcase" for explanation

        Closet.get().addAll(
                new Jacket("Polyester", "White", "XL", "Casual"),
                new Jacket("Polyester", "Black", "XL", "Business"),
                new Jacket("Polyester", "Red", "XL", "Casual"),
                new Jacket("Polyester", "Green", "XL", "Business"),
                new Jacket("Polyester", "Blue", "XL", "Casual"),

                new Shirt("Cotton", "White", "XL", "Business"),
                new Shirt("Cotton", "Black", "XL", "Business"),
                new Shirt("Polyester", "Red", "XL", "Casual"),
                new Shirt("Polyester", "Green", "XL", "Casual"),
                new Shirt("Polyester", "Blue", "XL", "Casual"),

                new Pants("Jeans", "White", "XL", "Casual"),
                new Pants("Jeans", "Black", "XL", "Casual"),
                new Pants("Jeans", "Red", "XL", "Casual"),
                new Pants("Jeans", "Green", "XL", "Casual"),
                new Pants("Jeans", "Blue", "XL", "Casual"),

                new Shoes("Leather", "White", "XL", "Casual"),
                new Shoes("Leather", "Black", "XL", "Casual"),
                new Shoes("Leather", "Red", "XL", "Casual"),
                new Shoes("Leather", "Green", "XL", "Casual"),
                new Shoes("Leather", "Blue", "XL", "Casual"),

                new FlipFlop("Leather", "White", "XL", "Casual"),
                new FlipFlop("Leather", "Black", "XL", "Casual"),
                new FlipFlop("Leather", "Red", "XL", "Casual"),
                new FlipFlop("Leather", "Green", "XL", "Casual"),
                new FlipFlop("Leather", "Blue", "XL", "Casual")

        );

        SuitcaseBuilder work = new SuitcaseBuilder();
        work.add(Jacket.class);
        work.add(Shirt.class);
        work.add(Pants.class);
        work.add(Footwear.class);
        work.toSuitcase("Work");

        SuitcaseBuilder play = new SuitcaseBuilder();
        play.add(Jacket.class);
        play.add(Shirt.class);
        play.add(Pants.class);
        play.add(Footwear.class);
        play.toSuitcase("Play");

        SuitcaseBuilder vacation = new SuitcaseBuilder();
        vacation.add(Jacket.class);
        vacation.add(Shirt.class);
        vacation.add(Pants.class);
        vacation.add(Footwear.class);
        vacation.toSuitcase("Vacation");




        mainMenu();

    }

    private static void mainMenu() {
        ConsoleMenu menu = new ConsoleMenu();
        menu.add( new MenuItem("View Closet", null, (i, menuItem) -> {

                System.out.print(Closet.get());

        } ));

        for (String name : Suitcase.getAll().keySet()) {
            menu.add( new MenuItem(String.format("View Suitcase '%s'",name), null, (i, menuItem) -> {
                if (Suitcase.has(name)) {
                    Collections.sort(Suitcase.get(name));
                    System.out.print(Suitcase.get(name));
                }
                else {
                    System.out.printf("Suitcase %s not found \n", name);
                }
            } ));
        }

        MenuItem quit;
        menu.add( quit = new MenuItem("Quit", null, null));

        Integer choosen;
        do {
            menu.show();
            menu.action( choosen = menu.waitForChoice() );
        } while(menu.get(choosen) != quit);


        System.exit(1);
    }

}
