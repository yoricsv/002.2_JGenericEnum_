# <p align=center><b>Enumeration (enum)</b></p>

Enumerations serve the purpose of representing a group of named constants in a programming language. For example, the 4 suits in a deck of playing cards may be 4 enumerators named Club, Diamond, Heart, and Spade, belonging to an enumerated type named Suit. Other examples include natural enumerated types (like the planets, days of the week, colors, directions, etc.).
<br/> 
Enums are used when we know all possible values at compile time, such as choices on a menu, rounding modes, command line flags, etc. It is not necessary that the set of constants in an enum type stay fixed for all time.
<br/>
In Java (from 1.5), enums are represented using enum data type. Java enums are more powerful than [C/C++ enums][1]. In Java, we can also add variables, methods and constructors to it. The main objective of enum is to define our own data types (Enumerated Data Types).

### **Declaration of enum in Java:**  
* Enum declaration can be done outside a Class or inside a Class but not inside a Method. 

#### Example:
```java
// A simple enum example where enum is declared
// outside any class (Note enum keyword instead of
// class keyword)
enum Color
{
    RED, GREEN, BLUE;
}
 
public class Test
{
    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1); // Output: RED
    }
}
```

#### Example:
```java
// enum declaration inside a class.
public class Test
{
    enum Color
    {
        RED, GREEN, BLUE;
    }
 
    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1); // Output: RED
    }
}
```

* The first line inside the enum should be a list of constants and then other things like methods, variables and constructors.
* According to [Java naming conventions][2], it is recommended that we name constant with all capital letters


### **Important points of enum:**  
* Every enum is internally implemented by using Class.

#### Syntax:
```java
/* internally above enum Color is converted to
class Color
{
     public static final Color RED = new Color();
     public static final Color BLUE = new Color();
     public static final Color GREEN = new Color();
}*/
```

* Every enum constant represents an object of type enum.
* enum type can be passed as an argument to switch statement. 

#### Example:
```java
// A Java program to demonstrate working on enum
// in switch case (Filename Test. Java)
import java.util.Scanner;
 
// An Enum class
enum Day
{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY;
}
 
// Driver class that contains an object of "day" and
// main().
public class Test
{
    Day day;
 
    // Constructor
    public Test(Day day)
    {
        this.day = day;
    }
 
    // Prints a line about Day using switch
    public void dayIsLike()
    {
        switch (day)
        {
        case MONDAY:
            System.out.println("Mondays are bad."); // Output: Mondays are bad.
            break;
        case FRIDAY:
            System.out.println("Fridays are better.");
            break;
        case SATURDAY:
        case SUNDAY:
            System.out.println("Weekends are best.");
            break;
        default:
            System.out.println("Midweek days are so-so.");
            break;
        }
    }
 
    // Driver method
    public static void main(String[] args)
    {
        String str = "MONDAY";
        Test t1 = new Test(Day.valueOf(str));
        t1.dayIsLike();
    }
}
```

* Every enum constant is always implicitly **public static final**. Since it is **static**, we can access it by using the enum Name. Since it is **final**, we can’t create child enums.
We can declare the **main() method** inside the enum. Hence we can invoke enum directly from the Command Prompt. 

#### Example:
```java
// A Java program to demonstrate that we can have
// main() inside enum class.
enum Color
{
    RED, GREEN, BLUE;
 
    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1); // Output: RED
    }
}
```

## Enum and Inheritance :  
* All enums implicitly extend **java.lang.Enum class**. As a class can only extend **one** parent in Java, so an enum cannot extend anything else.
* **toString() method** is overridden in **java.lang.Enum class**, which returns enum constant name.
* enum can implement many interfaces.

<br/>

## values(), ordinal() and valueOf() methods:
* These methods are present inside **java.lang.Enum.**
* **values() method** can be used to return all values present inside enum.
* Order is important in enums.By using **ordinal() method**, each enum constant index can be found, just like array index.
* **valueOf() method** returns the enum constant of the specified string value, if exists.

#### Example:
```java
// Java program to demonstrate working of values(),
// ordinal() and valueOf()
enum Color
{
    RED, GREEN, BLUE;
}
 
public class Test
{
    public static void main(String[] args)
    {
        // Calling values()
        Color arr[] = Color.values();
 
        // enum with loop
        for (Color col : arr)
        {
            // Calling ordinal() to find index
            // of color.
            System.out.println(col + " at index "
                             + col.ordinal() // Output: RED at index 0
                             // Output: GREEN at index 1
                             // Output: BLUE at index 2
                             );
        }
 
        // Using valueOf(). Returns an object of
        // Color with given constant.
        // Uncommenting second line causes exception
        // IllegalArgumentException
        System.out.println(Color.valueOf("RED")
        );  // Output: RED
        // System.out.println(Color.valueOf("WHITE"));
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
// Java program to demonstrate that enums can have constructor
// and concrete methods.
 
// An enum (Note enum keyword inplace of class keyword)
enum Color
{
    RED, GREEN, BLUE;
 
    // enum constructor called separately for each
    // constant
    private Color()
    {
        System.out.println("Constructor called for : " +
        this.toString());
    }
 
    public void colorInfo()
    {
        System.out.println("Universal Color");
    }
}

/*      OUTPUT:
Constructor called for : RED
Constructor called for : GREEN
Constructor called for : BLUE
RED
Universal Color
*/
 
public class Test
{   
    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
        c1.colorInfo();
    }
}
```

## <p align=center><b>Enum with Customized Value in Java</b></p>
By default enums have their own string values, we can also assign some custom values to enums. Consider below example for that.

#### Example:
```java
enum  Fruits
{
    APPLE (“RED”),
    BANANA(“YELLOW”),
    GRAPES(“GREEN”);
}
```

In above example we can see that the Fruits enum have three members i.e APPLE, BANANA and GRAPES with have their own different custom values RED, YELLOW and GREEN respectively.
<br/>

**Now to use this enum in code, there are some points we have to follow:**
1. We have to create parameterized constructor for this enum class. Why? Because as we know that enum class’s object can’t be create explicitly so for initializing we use parameterized constructor. And the constructor cannot be the public or protected it must have private or default modifiers. Why? if we create public or protected, it will allow initializing more than one objects. This is totally against enum concept.
2. We have to create one getter method to get the value of enums.

#### Example:
```java
// Java program to demonstrate how values can
// be assigned to enums.
enum TrafficSignal
{
    // This will call enum constructor with one
    // String argument
    RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN");
  
    // declaring private variable for getting values
    private String action;
  
    // getter method
    public String getAction()
    {
        return this.action;
    }
  
    // enum constructor - cannot be public or protected
    private TrafficSignal(String action)
    {
        this.action = action;
    }
}
  
/*         OUTPUT:
* name : RED action: STOP
* name : GREEN action: GO 
* name : ORANGE action: SLOW DOWN 
*/


// Driver code
public class EnumConstructorExample
{
    public static void main(String args[])
    {
        // let's print name of each enum and there action
        // - Enum values() examples
        TrafficSignal[] signals = TrafficSignal.values();
  
        for (TrafficSignal signal : signals)
        {
            // use getter method to get the value
            System.out.println("name : " + signal.name() +
                        " action: " + signal.getAction() );
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