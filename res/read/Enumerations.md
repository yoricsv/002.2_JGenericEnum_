# <p align=center><b>Enumeration (enum)</b></p>

Enumerations serve the purpose of representing a group of named constants in a programming language. For example, the 4 suits in a deck of playing cards may be 4 enumerators named Club, Diamond, Heart, and Spade, belonging to an enumerated type named Suit. Other examples include natural enumerated types (like the planets, days of the week, colors, directions, etc.).
<br/> 
Enums are used when we know all possible values at compile time, such as choices on a menu, rounding modes, command line flags, etc. It is not necessary that the set of constants in an enum type stay fixed for all time.
<br/>
In Java (from 1.5), enums are represented using enum data type. Java enums are more powerful than [C/C++ enums][1]. In Java, we can also add variables, methods and constructors to it. The main objective of enum is to define our own data types (Enumerated Data Types).

### **Declaration of enum in Java:**  
* Enum declaration can be done *outside a Class* or *inside a Class* but **not inside a Method**. 

#### Example (Out of class declaration):
```java
enum Color
{
    RED, GREEN, BLUE;
}
 
public class Test
{
    public static void main(String... args)
    {
        Color cObj = Color.GREEN;
        System.out.println(cObj);                       // Output: GREEN
    }
}
```

#### Example (Inside a class declaration):
```java
public class Test
{
    enum Color
    {
        RED, GREEN, BLUE;
    }
 
    public static void main(String... args)
    {
        Color cObj = Color.BLUE;
        System.out.println(cObj);                       // Output: BLUE
    }
}
```

* **The first line** inside the enum **should be a list of constants** and then other things like methods, variables and constructors.
* According to [Java naming conventions][2], it is recommended that we name **CONSTANT** with **all capital letters**

### **Important points of enum:**  
* Every enum is internally implemented by using Class.

#### Syntax (internally implementation):
```java
class Color
{
     public static final Color RED   = new Color();     // Object of TYPE ENUM
     public static final Color BLUE  = new Color();
     public static final Color GREEN = new Color();
}
```

* Every enum constant represents an object of **type enum**.
* Enum type **can be passed** as an argument to switch statement. 

#### Example:
```java
enum Day                                                // Class Day is ENUM Class
{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

public class Test
{
    Day day;

    public Test (Day day)                               // CONSTRUCTOR 
    {
        this.day = day;
    }
 
    public void dayIsToday()
    {
        switch(day)
        {
            case MONDAY:
                System.out.println("Today is Monday."); // Output: Today is Monday.
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
                System.out.println("Today is Saturday.");
                break;
            case SUNDAY:
                System.out.println("Today is Sunday.");
                break;
            default:
                System.out.println(
                    "There is something wrong. " +
                    "Please, try again."
                );
        }
    }
 
    public static void main(String... args)
    {
        String str = "MONDAY";

        Test t1 = new Test(Day.valueOf(str));
        t1.dayIsToday();
    }
}
```

* Every enum constant is always implicitly **public static final**. Since it is **static**, we can access it by using the enum Name. Since it is **final**, we can’t create child enums.
We can declare the **main() method** inside the enum. Hence we can invoke enum directly from the Command Prompt. 

#### Example:
```java
enum Color
{
    RED,
    GREEN,
    BLUE;

    public static void main(String... args)             // ENTRY POINT inside EMUN Class
    {
        Color cObj = Color.RED;
        System.out.println(cObj);                       // Output: RED
    }
}
```

## Enum and Inheritance :  
* All enums implicitly extend **java.lang.Enum class**. As a class can only extend **one** parent in Java, so an enum cannot extend anything else.
* **toString() method** is overridden in **java.lang.Enum class**, which returns enum constant name.
* enum can implement many interfaces.

<br/>

## values(), ordinal() and valueOf() methods:
These methods are present inside *java.lang.Enum.*
* **values()** method can be used to return all values present inside enum.
* **ordinal()** method can find each index of enum constant, just like array index. 
* **valueOf()** method returns the enum constant of the specified string value, if exists.

#### Example:
```java
enum Color
{
    RED,
    GREEN,
    BLUE;
}
 
public class Test
{
    public static void main(String... args)
    {
/*
    *****************************************
    * values() returns the names of enum    *
    *****************************************
*/
        Color[] arr = Color.values();

        for (Color enumName : arr)
        {
/*
    *****************************************
    * ordinal() returns the index of enum   *
    *****************************************
*/
            System.out.println(
                enumName            +                   // Output: RED at index 0
                " at index "        +                   // Output: GREEN at index 1
                enumName.ordinal()                      // Output: BLUE at index 2
            );
        }
/*
    *****************************************
    * valueOf() - returns a constant object *
    *****************************************
*/
        System.out.println(
            Color.valueOf("RED")                        // Output: RED
        );

        // System.out.println(
        //    Color.valueOf("WHITE")                    // ERROR: IllegalArgumentException
        //);
    }
}
```

## **enum and constructor:**
* enum can contain a constructor and it is executed separately for each enum constant at the time of enum class loading.
* We can’t create enum objects explicitly and hence we can’t invoke enum constructor directly.
<br/>

## enum and methods :  
* enum can contain both **concrete** methods and **abstract** methods. If an enum class has an abstract method, then each instance of the enum class must implement it 

#### Example:
```java
enum Color
{
    RED,
    GREEN,
    BLUE;
 /*
    *************************************************************
    * REQUIREMENTS FOR THE ENUM CLASS:                          *
    *                                                           *
    *   - Use the keyword "enum" insted "class"                 *
    *   - The constructor ALWAYS have to be PRIVATE!!!          *
    *   - The constructor called SEPARATELY for each constant   *
    *************************************************************
*/
    private Color()                                     // PRIVATE ENUM CONSTRUCTOR
    {
        System.out.println(
            "Constructor called for : " +               // Output: Constructor called for : RED
            this.toString()                             // Output: Constructor called for : GREEN
        );                                              // Output: Constructor called for : BLUE
    }
 
    public void colorInfo()
    {
        System.out.println(
            "Universal Color"                           // Output: Universal Color
        );
    }
}

public class Test
{   
    public static void main(String... args)
    {
        Color cObj = Color.RED;
        System.out.println(cobj);                       // Output: RED

        cObj.colorInfo();
    }
}
```

## <p align=center><b>Enum with Customized Value in Java</b></p>
By default enums have their own string values, we can also assign some custom values to enums. Consider below example for that.

#### Example:
```java
enum  Fruits
{
    APPLE ("RED"),
    BANANA("YELLOW"),
    GRAPES("GREEN");
}
```

In above example we can see that the Fruits enum have three members i.e APPLE, BANANA and GRAPES with have their own different custom values RED, YELLOW and GREEN respectively.
<br/>

**Now to use this enum in code, there are some points we have to follow:**
1. We have to create parameterized constructor for this enum class. Why? Because as we know that enum class’s object can’t be create explicitly so for initializing we use parameterized constructor. And the constructor cannot be the public or protected it must have private or default modifiers. Why? if we create public or protected, it will allow initializing more than one objects. This is totally against enum concept.
2. We have to create one getter method to get the value of enums.

#### Example:
```java
enum TrafficSignal
{
    RED     ("STOP"),                                   // Assigning via the ENUM CONSTRUCTOR
    ORANGE  ("WAIT"),
    GREEN   ("GO"); 

    private String action;                              // PRIVATE VARIABLE FOR PASSING VALUE
 
    private TrafficSignal(String action)                // PRIVATE ENUM CONSTRUCTOR
    {
        this.action = action;
    }

    public String getAction()                           // GETTER
    {
        return this.action;
    }
}

public class EnumConstructor
{
    public static void main(String... args)
    {
        TrafficSignal[] signals = TrafficSignal.values();
  
        for (TrafficSignal signal : signals)
        {
            System.out.println(                         // Output: Signal is: RED, action is: STOP
                "Signal is: "    + signal.name()      + // Output: Signal is: ORANGE, action is: WAIT
                ", action is : " + signal.getAction()   // Output: Signal is: GREEN, action is: GO
            );
        }
    }
}
```

<!--
* [C/C++ enums][1]
* [Java naming conventions][2]
-->

[1]: https://www.geeksforgeeks.org/enumeration-enum-c/
[2]: http://www.oracle.com/technetwork/java/codeconventions-135099.html

---
<br/>