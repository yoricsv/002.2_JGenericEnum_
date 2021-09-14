# <p align=center><b>Generics in Java</b></p>

**Generics** mean **parameterized types**. The idea is to allow type (*Integer*, *String*, … *etc*, and *user-defined* types) to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types. 
An entity such as class, interface, or method that operates on a parameterized type is called a generic entity.

### Why Generics?
The **Object** is the superclass of all other classes and Object reference can refer to any type object. These features lack type safety. Generics add that type safety feature. We will discuss that type of safety feature in later examples.
<br/>
Generics in Java is similar to [templates in C++][1]. For example, classes like HashSet, ArrayList, HashMap, etc use generics very well. There are some fundamental differences between the two approaches to generic types. 
 
### Generic Class 
Like C++, we use <> to specify parameter types in generic class creation. To create objects of a generic class, we use the following syntax. 

#### Syntax:
```java
// To create an instance of generic class 
BaseType <Type> obj = new BaseType <Type>()

Note: In Parameter type we can not use primitives like 
      'int','char' or 'double'.
```

#### Example:
```java
// We use < > to specify Parameter type
class Test<T>
{
    // An object of type T is declared
    T obj;
    Test(T obj) {  this.obj = obj;  }  // constructor
    public T getObject()  { return this.obj; }
}
   
// Driver class to test above
class Main
{
    public static void main (String[] args)
    {
        // instance of Integer type
        Test <Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());   // Output: GeeksForGeeks
   
        // instance of String type
        Test <String> sObj =
                          new Test<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());   // Output: GeeksForGeeks
    }
}
```

We can also pass multiple Type parameters in Generic classes.

#### Example:
```java
// We use < > to specify Parameter type
class Test<T, U>
{
    T obj1;  // An object of type T
    U obj2;  // An object of type U
  
    // constructor
    Test(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
  
    // To print objects of T and U
    public void print()
    {
        System.out.println(obj1); // Output: GeeksForGeeks
        System.out.println(obj2); // Output: 15
    }
}
  
// Driver class to test above
class Main
{
    public static void main (String[] args)
    {
        Test <String, Integer> obj =
            new Test<String, Integer>("GfG", 15);
  
        obj.print();
    }
}
```

## Generic Functions: 
We can also write generic functions that can be called with different types of arguments based on the type of arguments passed to the generic method, the compiler handles each method.

#### Example:
```java
class Test
{
    // A Generic method example
    static <T> void genericDisplay (T element)
    {
        System.out.println(element.getClass().getName() +
                           " = " + element);
    }
   
    // Driver method
    public static void main(String[] args)
    {
         // Calling generic method with Integer argument
        genericDisplay(11);     // Output: 11
   
        // Calling generic method with String argument
        genericDisplay("GeeksForGeeks");    // Output: GeeksForGeeks
   
        // Calling generic method with double argument
        genericDisplay(1.0);    // Output: 1.0
    }
}
```

## Generics work only with Reference Types: 
When we declare an instance of a generic type, the type argument passed to the type parameter must be a reference type. We cannot use primitive data types like int, char.

#### Syntax:
```java
Test<int> obj = new Test<int>(20);
```

The above line results in a compile-time error, that can be resolved by using type wrappers to encapsulate a primitive type. 

But primitive type array can be passed to the type parameter because arrays are reference type.

#### Syntax:
```java
ArrayList<int[]> a = new ArrayList<>();
```

### **Generic Types Differ Based on Their Type Arguments:**
Consider the following Java code. 

#### Example:
```java
class Test<T>
{
    // An object of type T is declared
    T obj;
    Test(T obj) {  this.obj = obj;  }  // constructor
    public T getObject()  { return this.obj; }
}
   
// Driver class to test above
class Main
{
    public static void main (String[] args)
    {
        // instance of Integer type
        Test <Integer> iObj = new Test<Integer>(15);  
        System.out.println(iObj.getObject());
   
        // instance of String type
        Test <String> sObj =
                          new Test<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());
        iObj = sObj; // Output: error: incompatible types:
 Test cannot be converted to Test   
    }
}
```

Even though iObj and sObj are of type Test, they are the references to different types because their type parameters differ. Generics add type safety through this and prevent errors.
<br/>
**Advantages of Generics:** 
Programs that use Generics has got many benefits over non-generic code. 

1. **Code Reuse**: We can write a method/class/interface once and use it for any type we want.

2. **Type Safety**: Generics make errors to appear compile time than at run time (It’s always better to know problems in your code at compile time rather than making your code fail at run time). Suppose you want to create an ArrayList that store name of students and if by mistake programmer adds an integer object instead of a string, the compiler allows it. But, when we retrieve this data from ArrayList, it causes problems at runtime.

#### Example:
```java
// generics can cause run time exceptions
import java.util.*;
  
class Test
{
    public static void main(String[] args)
    {
        // Creatinga an ArrayList without any type specified
        ArrayList al = new ArrayList();
  
        al.add("Sachin");
        al.add("Rahul");
        al.add(10); // Compiler allows this
  
        String s1 = (String)al.get(0);
        String s2 = (String)al.get(1);
  
        // Causes Runtime Exception
        String s3 = (String)al.get(2);  // Output: Exception in thread "main" java.lang.ClassCastException: 
  // java.lang.Integer cannot be cast to java.lang.String
   // at Test.main(Test.java:19)
    }
}
```

### **How generics solve this problem?** 
At the time of defining ArrayList, we can specify that this list can take only String objects.

#### Example:
```java
import java.util.*;
  
class Test
{
    public static void main(String[] args)
    {
        // Creating a an ArrayList with String specified
        ArrayList <String> al = new ArrayList<String> ();
  
        al.add("Sachin");
        al.add("Rahul");
  
        // Now Compiler doesn't allow this
        al.add(10);     //Output: 15: error: no suitable method found for add(int)
       // al.add(10); 
        //  ^
  
        String s1 = (String)al.get(0);
        String s2 = (String)al.get(1);
        String s3 = (String)al.get(2);
    }
}
```

3. **Individual Type Casting isn't needed:** If we do not use generics, then, in the above example every time we retrieve data from ArrayList, we have to typecast it. Typecasting at every retrieval operation is a big headache. If we already know that our list only holds string data then we need not typecast it every time.

#### Example:
```java
import java.util.*;
  
class Test
{
    public static void main(String[] args)
    {
        // Creating a an ArrayList with String specified
        ArrayList <String> al = new ArrayList<String> ();
  
        al.add("Sachin");
        al.add("Rahul");
  
        // Typecasting is not needed 
        String s1 = al.get(0);
        String s2 = al.get(1);
    }
}
```

4. Generics promotes code reusability.
5. **Implementing generic algorithms:** By using generics, we can implement algorithms that work on different types of objects and at the same, they are type safe too.

#### Example:
```java
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

// GENERIC CLASS (Adjustable)                                       // GENERIC CLASS AFTER COMPILING:
class Vehicle <T>                                                   //class Vehicle
{                                                                   //{
    T t;                                                            //    Object object;
                                                                    //
    public T getType()                                              //    public Object getType()
    {                                                               //    }
        return t;                                                   //        return object;
    }                                                               //    }
                                                                    //
    public void setType(T t)                                        //    public void setType(Object Object)
    {                                                               //    {
        this.t = t;                                                 //        this.object = Object;
    }                                                               //    }
}                                                                   //}

// GENERIC CLASS AFTER COMPILING:
//class Vehicle
//{
//    Object object;
//
//    public Object getType()
//    {
//        return object;
//    }
//
//    public void setType(Object Object)
//    {
//        this.object = Object;
//    }
//}

```

<!--
* [templates in C++][1]
-->

[1]: http://geeksquiz.com/templates-cpp/

---
<br/>