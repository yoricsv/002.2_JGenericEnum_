import java.util.ArrayList;
import java.util.List;

public class Generics
{
    public static void main(String... args)
    {
        // WITHOUT GENERICS
        List    carSpareParts = new ArrayList();               // There was created an Object!
        Vehicle carDodge      = new Vehicle();


        carSpareParts.add("Engine");
        carSpareParts.add("Tires");
        carSpareParts.add("Brakes");
        carSpareParts.add("Body");
        carSpareParts.add("Exhaust system");
        carSpareParts.add(carDodge);


        // String carSparePart = carSpareParts.get(3);          // ERROR: Different types!!!
        // String dodgeSP      = (String) carSpareParts.get(5); // ERROR: Cast Exception!!!
        String carSparePart = (String) carSpareParts.get(3);    // DOWN-CASTING to solve the first problem

        System.out.println(
                "\n---------------------------------"       +
                "\n\t\tUSED THE DOWN-CAST"                  +
                "\n---------------------------------"       +
                "\nYou have chosen the following part: \n"  +
                carSparePart                                    // Output: Body
        );


        List<String> carSPs = new ArrayList<>();                // USE GENERICS

        carSPs.add("Engine");
        carSPs.add("Tires");
        carSPs.add("Brakes");
        carSPs.add("Body");
        carSPs.add("Exhaust system");

        String carSP = carSPs.get(4);

        System.out.println(
                "\n---------------------------------"   +
                "\n\t\tUSED THE GENERICS"               +
                "\n---------------------------------"   +
                "\nYou've chosen the following: \n"     +
                carSP                                           // Output: Exhaust system
        );
    }
}

class Vehicle
{
}
