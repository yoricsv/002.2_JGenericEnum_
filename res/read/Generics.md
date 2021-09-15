# <p align=center><b>Generics in Java</b></p>

**Generics** mean **parameterized types**. The idea is to allow type (*Integer*, *String*, … *etc*, and *user-defined* types) to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types.<br/> 
An entity such as class, interface, or method that operates on a parameterized type is called a generic entity.

### Why Generics?
The **Object** is the superclass of all other classes and Object reference can refer to any type object. These features lack type safety. Generics add that type safety feature. 
<br/>
Generics in Java is similar to [templates in C++][1]. For example, classes like HashSet, ArrayList, HashMap, etc use generics very well. There are some fundamental differences between the two approaches to generic types. 
 
### Generic Class 
Like C++, we use <> to specify parameter types in generic class creation. To create objects of a generic class, we use the following syntax. 

#### Syntax:
```java
BaseType <Type> obj = new BaseType <Type>();    // DECLARING AND INSTANCING 
```

> *Note:* In Parameter *\<type\>* we CAN'T USE primitives like *'int'*,*'char'* or *'double'*.<br/>
> Since Java 7, there is no need to specify the right side parameter *\<type\>*

#### Example:
```java
class Test<T>                                   // type specified by <T>
{
    T obj;                                      // type T object declaring

    Test(T obj)                                 // CONSTRUCTOR
    {
        this.obj = obj;
    }
    public T getObject()                        // GENERIC METHOD
    {
        return this.obj;
    }
}
   
class Main
{
    public static void main (String... args)    // DRIVER
    {
        Test <String>  sObj = 
            new Test<String>("Hello, World!");  // String type
        Test <Integer> iObj = 
            new Test<Integer>(255);             // Integer type

        System.out.println(iObj.getObject());   // Output: 255
        System.out.println(sObj.getObject());   // Output: Hello, World!
    }
}
```

We can also pass multiple Type parameters in Generic classes.

#### Example:
```java
class Test<T, U>                                // type specify by <T, U>
{
    T obj1;                                     // type T object declaring
    U obj2;                                     // type U object declaring

    Test(T obj1, U obj2)                        // CONSTRUCTOR
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
  
    public void print()
    {
        System.out.println(obj1);               // Output: Hello, World!
        System.out.println(obj2);               // Output: 255
    }
}
 
class Main
{
    public static void main (String... args)    // DRIVER
    {
        Test <String, Integer> obj =
            new Test <String, Integer> ("Hello, World!", 255);
  
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
    static <T> void genericDisp (T element)     // GENERIC METHOD
    {
        System.out.println(
            element
                .getClass()
                .getName() +
            " = "          +
            element
        );
    }

    public static void main(String... args)     // DRIVER
    {
        genericDisp(50);                        // Output: java.lang.Integer = 50
        genericDisp(12.4);                      // Output: java.lang.Double = 12.4
        genericDisp("Hello, world!");           // Output: java.lang.String = Hello, world!
    }
}
```

## Generics work only with Reference Types: 
When we declare an instance of a generic type, the type argument passed to the type parameter must be a reference type. We can't use primitive data types like int, char.

#### Syntax:
```java
Test<int> obj = new Test<int>(10);              // ERROR: Compile-time error!
```

The above line results in a compile-time error, that can be resolved by using type wrappers to encapsulate a primitive type. 

But primitive *type array* can **be passed** to the type parameter because **arrays are reference type**.

#### Syntax:
```java
ArrayList<int[]> a = new ArrayList<>();         // Everything OK!
```

### **Generic Types Differ Based on Their Type Arguments:**
Consider the following Java code. 

#### Example:
```java
class Test<T>
{
    T obj;

    Test(T obj)
    {
        this.obj = obj;
    }

    public T getObject()
    {
        return this.obj;
    }
}

class Main
{
   public static void main (String... args)
    {
        Test <String>  sObj = new Test<String>("Hello, World!");
        Test <Integer> iObj = new Test<Integer>(255);

        System.out.println(iObj.getObject());   // Output: 255
        System.out.println(sObj.getObject());   // Output: Hello, World!

        iObj = sObj;                            // ERROR: incompatible types:
                                                //        Test can't be converted to Test
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
import java.util.ArrayList;
  
class Test
{
    public static void main(String... args)
    {
        ArrayList al = new ArrayList();         // In case, without types
  
        al.add("Engine");
        al.add("Brakes");
        al.add(32);                             // In case, it's allow
  
        String s1 = (String) al.get(0);         // Output: Engine
        String s2 = (String) al.get(1);         // Output: Brakes
  
        String s3 = (String) al.get(2);         // ERROR: Cast Exception!!!
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
    public static void main(String... args)
    {
        ArrayList <String> al = 
                    new ArrayList<>();          // In case, generic
  
        al.add("Engine");
        al.add("Brakes");
        al.add(10);                             // In case, it doesn't allow
                                                // ERROR: no suitable method!!!
        String s1 = (String) al.get(0);
        String s2 = (String) al.get(1);
        String s3 = (String) al.get(2);
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
        ArrayList <String> al = new ArrayList<String> ();
  
        al.add("Engine");
        al.add("Brakes");
  
        String s1 = al.get(0);                  // Casting isn't needed
        String s2 = al.get(1);                  // Casting isn't needed
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
    public static void main(String... args)                         // DRIVER
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
                System.out.println(header + "- " + carSP.print());  // Output: Engine
            else
                System.out.println("- " + carSP.print());           // Output: Engine, Tires, ... etc.
        }
    }
}


class Vehicle <T>                                                   // GENERIC CLASS (Adjustable)
{
    T obj;
    
    Vehicle ()                                                      // DEFAULT CONSTRUCTOR
    {
    }

    Vehicle (T obj)                                                 // CONSTRUCTOR
    {
        this.obj = obj;
    }

    public T getObject()                                            // GENERIC METHOD
    {
        return this.obj;
    }

    public T getType()                                              // GENERIC METHOD
    {
        return obj;
    }

    public void setType(T obj)                                      // GENERIC METHOD
    {
        this.obj = obj;
    }

    public void print()                                              // GENERIC METHOD
    {
        System.out.println(obj);
    }
}
```

> *NOTE:* After compiling, all the generics will be deleted !!!

#### Generic class after compiling:
```java
// GENERIC CLASS AFTER COMPILING:
class Vehicle
{
    Object object;

    Vehicle ()
    {
    }

    Vehicle (Object object)
    {
        this.object = object;
    }

    public Object getObject()
    {
        return this.object;
    }

    public Object getType()
    {
        return object;
    }

    public void setType(Object Object)
    {
        this.object = object;
    }

    public void print()
    {
        System.out.println(object);
    }
}

```
---
<!--
* [templates in C++][1]
-->

[1]: http://geeksquiz.com/templates-cpp/
<br/>