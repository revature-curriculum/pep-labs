<h1>Intro to Java</h1>

Before we dive into writing code, we need to identify what kind of constructs we will be working with. 
When working with Java, there are 3 basic entities that we will encounter:

- ##### Variables

- ##### Methods

- ##### Classes

We will utilize the entities above to throughout Java programs.

## Variables
A variable is a container that we can be used to temporarily store data. You can think of them like writing down 
information on a chalkboard while working through a math problem. Java must know what type of data a variable 
could be before it is created.

#### General Syntax

```java
datatype variableName = value;
```

#### Example

If we would like to store the numerical value 102 as a variable called `counter`, we could write:

```java
int counter = 102;
```

We can now reuse the variable `counter` to access the value 102 whenever we need it. If the value of `counter` changes,
that change will be reflected when we access `counter` again.

In the above example, we utilized the primitive datatype `int` to store a whole number. There are 8 primitive 
datatypes in java. You can read more about them [here](https://www.w3schools.com/java/java_data_types.asp)

## Methods

A method is a block of reusable code. A method can return a variable, which means that it
produces some variable. For instance, if you think of a search engine as a method, that method 'returns' a 
list of search results every time it is used. Returning a value ends a method instantly.

#### General Syntax

```java
public return_type methodName(int argument1, String argument2){
    //code will be written here
}
```

Two terms we need to understand with methods:

- **return type**: This identifies the data we would like to return to the user that called it. This may be `int`, 
for instance.

- **parameters**: This is a variable that will to a method when it is called. Parameters allow methods
to act differently depending on what vales are provided.

#### Example

Let's say we wanted to write a method that receives a whole number, and returns that whole number plus one.

```java
public int increment(int val){
    val = val + 1;
    return val;
}
```

The return type of the method is an `int`. because we defined this in the method signature, 
it must return an `int`. If we do not want to return anything from a method, we would write `void` as the return type. 

#### Calling a method

To trigger the increment method, we type the following:

```java
increment(10); 
```

We are triggering the `increment()` method above and setting the variable `val` within the method to 10. This will 
execute the logic within the increment method and return the value 11. To store the returned value of the method, 
we can write the following instead:

```java
int num = increment(10); //the variable num will now equal 11
```

We could then output the value of num using the line
```java
System.out.println(num);
```

## Classes

We mentioned earlier that there are 8 primitive datatypes. One Java's most powerful features is that it 
allows us to define our own custom datatypes, which we can refer to as Classes. We can add variables and methods 
inside of classes.

```java
public class ClassName{
    //declaring variables
    int var1;
    int var2;

    //declaring methods
    public void method1(){
    }

    public void method2(){
    }
    
}
```

You can define as many variables and methods as you want inside of classes. 

#### Example

If I wanted to create an entity that represents the behaviors of a dog, I could create the following class:

```java
public class Dog{
    int age;
    String nameOfDog;

    public void bark(){
        System.out.println("BARK"); // prints BARK to the console
    }

    public void printNameAndAge(){
        System.out.println("My name is " + nameOfDog + " and I am " + age + " years old.");
    }
}
```

Now we can declare a variable with datatype `Dog` that we defined above.

```java
Dog dog1 = new Dog();
dog1.age = 8;
dog1.nameOfDog = "Max";
dog1.printNameAndAge(); // will print "My name is Max and I am 8 years old." to the console
```

Notice above we declared a variable `dog1` . Since we defined the datatype as `Dog`, we can utilize the variables and 
methods within the `Dog` class that we previously defined.

Classes are often used to model real data, but they are used so thoroughly in Java that every piece of code in Java is 
actually part of a Class. This is unintuitive to start, but becomes a very powerful feature for experienced 
professionals.

#### Summary

The three entities we need to get familiar with in java:

- **Variables**: A container for storing values
- **Methods**: block of reusable code that we call as many times as we want
- **Class**: An entity that allows us to define our own datatypes with variables and methods inside

#### What Next?
To complete this lab, review the "SuperHero" class and answer the questions that are in the "Questions" class.