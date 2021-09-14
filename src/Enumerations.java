public class Enumerations
{
    private static final int ENGINE  = 0;
    private static final int TIRES   = 1;
    private static final int BRAKES  = 2;
    private static final int BODY    = 3;
    private static final int EXHAUST = 4;

    public static void main(String... args)
    {
        int howMuchCost = 0;

        switch (howMuchCost)
        {
            case ENGINE:
                System.out.println("Engine is 1300$");
                break;
            case TIRES:
                System.out.println("Engine is 400$");
                break;
            case BRAKES:
                System.out.println("Engine is 120$");
                break;
            case BODY:
                System.out.println("Engine is 2500$");
                break;
            case EXHAUST:
                System.out.println("Engine is 200$");
                break;
            default:
                System.out.println("It's a New Spare Part");
        }

    }
}
