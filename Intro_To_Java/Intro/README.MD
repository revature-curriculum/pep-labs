<h1>Intro to Java</h1>

Welcome to your first Java lab! Before we dive into writing code, we need to identify what kind of constructs we will be working with. 
There are 3 basic entities that we will encounter very early in java:

- ##### Variables

- ##### Methods

- ##### Classes

We utilize all the entities above to create our java applications. This lab will NOT explain everything about these entities however before we get into the weeds regarding java, we need to be able to identify the above constructs and explain what they are.

## Variables
A variable is a container that we can store data into.


#### General Syntax

```java
datatype variableName = value;
```



#### Example

If we wanted to store the numerical value 102 into a variable called `counter`, we would write:

```java
int counter = 102;
```

This is valuable because we can now reutilize the variable `counter` to access the value 102 whenever we need instead of hardcoding this value throughout our entire application.

Different types of data have different datatypes in java. In the above example, we utilized the primitive datatype `int` to store a whole number.

There are 8 primitive datatypes in java and you can read more about them [here](https://www.w3schools.com/java/java_data_types.asp)

## Methods

A method is a block of reusable code that ccalled and then return a vaan be executed whenever it is called.



#### General Syntax

```java
public return_type methodName(int arg1, String arg2, ...etc){
    //code will be written inside
}
```

Two terms we need to understand with methods:

- **return type**: This identifies the data we would like to return to the user that called it.

- **parameters**: this is data that we can pass to a method when it is called

#### Example

Lets say we wanted to write a method that can increment a whole number passed to it by 1 and return that value, we can write the following method:

```java
public int increment(int val){
    val = val + 1;
    return val;
}
```

Note: The return type of the method is an `int` and because we defined this in the method signature, we must return an `int`. If we dont want to return anything from our method we would write `void` instead in the return type. 

#### Calling a method

To trigger the increment method so it will execute, we type the following:

```java
increment(10); 
```

Above we are triggering the `increment()` method and setting the variable `val` to 10. This will execute the logic within the increment method and return the value 11. To store the return value of the method, we can write the following instead

```java
int num = increment(10); //the variable num will equal 11
```

## Classes

We mentioned earlier that there are 8 primitive datatypes. Well classes allows us to create our own datatypes. We can add variables and methods inside of classes.



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

You can define as many variables and methods as you want inside of classes. We utilize classes to repesent real life entities

#### Example

If I wanted to create an entity that represents the behaviors of a dog, I would create the following class

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
dog1.printNameAndAge();
```

Notice above we declared a variable `dog1` . Since we defined the datatype as `Dog`, we can utilize the variables and methods within the `Dog` class that we previous defined.



NOTE: Java requires that all logic are within a class.



#### Summary

The three entites we need to get familiar with in java:

- **Variables**: A container for storing values

- **Methods**: block of reusable code that we call as many times as we want

- **Class**: An entity that allows us to define our own datatypes with variables and methods inside


#### What Next?
To complete this lab, review the "SuperHero" class and answer the questions that are in the "Questions" class.