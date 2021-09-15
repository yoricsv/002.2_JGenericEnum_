import java.util.ArrayList;
import java.util.List;

enum Day                                                            // OUT-OF-CLASS IMPLEMENTATION
{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

class Color                                                         // INTERNAL IMPLEMENTATION
{
    public static final Color RED   = new Color();                  // Object of TYPE ENUM
    public static final Color BLUE  = new Color();
    public static final Color GREEN = new Color();

    public String getEnumName()
    {
        return this.toString();
    }
}

public class Enumerations
{
    Day day;

    public Enumerations(Day day)
    {
        this.day = day;
    }

    public void dayIsToday()
    {
        switch(day)
        {
            case MONDAY:
                System.out.println("Today is Monday.");
                break;
            case TUESDAY:
                System.out.println("Today is Tuesday.");
                break;
            case WEDNESDAY:
                System.out.println("Today is Wednesday.");
                break;
            case THURSDAY:
                System.out.println("Today is Thursday.");
                break;
            case FRIDAY:
                System.out.println("Today is Friday.");
                break;
            case SATURDAY:
                System.out.println("Today is Saturday.");           // Output: Today is Saturday.
                break;
            case SUNDAY:
                System.out.println("Today is Sunday.");
                break;
            default:
                System.out.println("There is something wrong. Please, try again.");
        }
    }


    private static final int ENGINE  = 0;                           // INTERNAL IMPLEMENTATION
    private static final int TIRES   = 1;                           // constant Variable with ENUM TYPE
    private static final int BRAKES  = 2;
    private static final int BODY    = 3;
    private static final int EXHAUST = 4;


    public static void main(String... args)
    {
        System.out.println(
                "\nDisplayed static enum object: " + Color.RED      // Output: Color@7ef20235
        );
        System.out.println(
                "\nDisplayed static enum object: " + Color.GREEN    // Output: Color@27d6c5e0
        );
        System.out.println(
                "\nDisplayed static enum object: " + Color.BLUE     // Output: Color@4f3f5b24
        );

        Color[] cArr = new Color[3];

        cArr[0] = Color.GREEN;
        cArr[1] = Color.BLUE;
        cArr[2] = Color.RED;

        List<Color> enumColorList = new ArrayList<>();

        enumColorList.add(Color.BLUE);
        enumColorList.add(Color.RED);
        enumColorList.add(Color.GREEN);

        for (Color enumName : cArr)
        {
            System.out.println(                                     // Output: Color@27d6c5e0
                    "\nDisplayed Object via Array: " + enumName     // Output: Color@4f3f5b24
            );                                                      // Output: Color@7ef20235
        }

        for (Color colorList : enumColorList)
        {
            System.out.println(                                     // Output: Color@4f3f5b24
                    "\nDisplayed Object via List: "  + colorList    // Output: Color@7ef20235
            );                                                      // Output: Color@27d6c5e0
        }



        String str = "SATURDAY";

        Enumerations todayIs = new Enumerations(Day.valueOf(str));
        todayIs.dayIsToday();



        int howMuchCost = BODY;                                     // Allowed using enumName or number

        switch (howMuchCost)
        {
            case ENGINE:
                System.out.println("Engine is 1300$");
                break;
            case TIRES:
                System.out.println("Tires is 400$");
                break;
            case BRAKES:
                System.out.println("Brakes is 120$");
                break;
            case BODY:
                System.out.println("Body is 2500$");                // Output: Body is 2500$
                break;
            case EXHAUST:
                System.out.println("Exhaust system is 200$");
                break;
            default:
                System.out.println("It's a New Spare Part");
        }



        TrafficSignal[] signals = TrafficSignal.values();

        for (TrafficSignal signal : signals)
        {
            System.out.println(                                     // Output: Signal is: RED, action is: STOP
                    "Signal is: "    + signal.name()      +         // Output: Signal is: ORANGE, action is: WAIT
                    ", action is : " + signal.getAction()           // Output: Signal is: GREEN, action is: GO
            );
        }
    }
}
enum TrafficSignal
{
    RED     ("STOP"),                                         // Assigning via the ENUM CONSTRUCTOR
    ORANGE  ("WAIT"),
    GREEN   ("GO");

    private String action;                                          // PRIVATE VARIABLE FOR PASSING VALUE

    private TrafficSignal(String action)                            // PRIVATE ENUM CONSTRUCTOR
    {
        this.action = action;
    }

    public String getAction()                                       // GETTER
    {
        return this.action;
    }
}

