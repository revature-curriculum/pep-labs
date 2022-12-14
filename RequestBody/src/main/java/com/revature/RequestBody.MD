# Javalin Lab: Retrieving Data from the body of an HTTP Request

Now that we have learned how to create a webserver and define endpoints with Javalin, we need to learn how to
retrieve data from the HTTP requests.

The most common ways to retrieve data from the HTTP requests:
- Path parameters
- HTTP Request body

We have already learned in the previous last lab how to use path parameters. This lab is going to talk about 
retrieving data from the request body.

## HTTP Request Body

Clients can send data in the body of an HTTP request. The type of data varies but in this curriculum we will be passing json strings in the body of our HTTP Requests.


## Jackson
Since Java does not understand json, we need to convert that json string into a something that java understands (like a java object). Jackson is a dependency that we can add to our project to achieve just that.

Jackson utilizes a class called `ObjectMapper` and you can instantiate it as shown below:
```java
ObjectMapper om = new ObjectMapper();
```

There are 2 methods defined in the `ObjectMapper` class that we will use:

- `om.readValue()`: converts json strings to java objects

- `om.writeValueAsString()`: converts java objects to json strings

## Steps to retrieve data from a JSON String to a Java object

Lets say we have the following POST endpoint which will send us a user json string shown above. 

```java
app.post("/user", ctx -> {

});
```

We can get the json string in a String variable by utilizing the `ctx.body()` method.

```java
app.post("/user", ctx -> {
    String jsonString = ctx.body();
});
```

this is a good start but we need to be able to utilize the fields in the json string... We need to utilze jackson to convert it into a java object.

```java
app.post("/user", ctx -> {
    //retrieve the json string from the request body
    String jsonString = ctx.body();

    //utilize jackson to convert the json string to a user object
    ObjectMapper om = new ObjectMapper();
    User user = om.readValue(jsonString, User.class);
});
```

NOTE: the `om.readValue()` method above takes in 2 arguments:

1. the json string that we are trying to convert

2. the datatype that we are trying to convert the json string to



Now that we have the data in a java object, we can manipulate anyway we see fit. Lets say I want to change the first name from "Jobs" to "Jones" and then send the data back as a json string

```java
app.post("/user", ctx -> {
    //retrieve the json string from the request body
    String jsonString = ctx.body();

    //utilize jackson to convert the json string to a user object
    ObjectMapper om = new ObjectMapper();
    User user = om.readValue(jsonString, User.class);

    //we need to let the request know we will send back json in the body
    ctx.contentType("application/json"); 

    //change the last name
    user.setLastname("Jones");
    
    //utilize jackson convert back the user object to a json string
    String jsonStringToBeReturned = om.writeValueAsString(user);

    //return the json string in the response body
    ctx.result(jsonStringToBeReturned);
```

Youre Done! 