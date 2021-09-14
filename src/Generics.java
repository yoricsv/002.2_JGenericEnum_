import java.util.ArrayList;
import java.util.List;

public class Generics
{
    public static void main(String... args)
    {
        String  downCastMsg = "DOWN-CAST",
                genericMsg  = "GENERICS",
                headerMsg   = "\n---------------------------------\n\t\tUSED THE ",
                footerMsg   = "\n---------------------------------\nYou've chosen the following: \n",
                header;

        // WITHOUT GENERICS
        List    carSpareParts = new ArrayList();                    // There was created an Object!
        Vehicle carDodge      = new Vehicle();

        carSpareParts.add("Engine");
        carSpareParts.add("Tires");
        carSpareParts.add("Brakes");
        carSpareParts.add("Body");
        carSpareParts.add("Exhaust system");
        //carSpareParts.add(carDodge);                              // CALL ERROR: Cast Exception!!!

        header = headerMsg + downCastMsg + footerMsg;

        for ( int i = 0;
                  i < carSpareParts.size();
                  i++)
        {
            // String carSparePart = carSpareParts.get(3);          // ERROR: Different types!!!
            // String dodgeSP      = (String) carSpareParts.get(5); // ERROR: Cast Exception!!!
            String carSparePart = (String) carSpareParts.get(i);    // DOWN-CASTING to solve the first problem

            if(i == 0)
                System.out.println(header + "- " + carSparePart);   // Output: Engine
            else
                System.out.println("- " + carSparePart);            // Output: Engine, Tires, ... etc.
        }

        // USING GENERICS
        List<String> carSPs = new ArrayList<>();                    // GENERIC

        carSPs.add("Engine");
        carSPs.add("Tires");
        carSPs.add("Brakes");
        carSPs.add("Body");
        carSPs.add("Exhaust system");

        header = headerMsg + genericMsg + footerMsg;

        for ( int i = 0;
                  i < carSPs.size();
                  i++)
        {
            String carSP = carSPs.get(i);

            if(i == 0)
                System.out.println(header + "- " + carSP);          // Output: Engine
            else
                System.out.println("- " + carSP);                   // Output: Engine, Tires, ... etc.
        }
    }
}

class Vehicle
{
}
