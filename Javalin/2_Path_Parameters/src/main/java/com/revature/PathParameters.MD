# Javalin Lab: Retrieving Data from Path Parameters

Now that we have learned how to create a webserver and define endpoints with Javalin, we need to learn how to retrieve data from the HTTP requests.

The most common ways to retrieve data from the HTTP requests:
- Path parameters
- HTTP Request body

For this lab we will be looking at Path Parameters

## Path Parameters

Path parameters are variables that are in the URL path.

For example: Lets say we define the following endpoint:

```java
    app.get("/lastname/{name}", ctx -> {

    });
```

The curly braces in the url above defines a variable. A client can now send a request to the above endpoint in the following ways:

- http://localhost:9000/lastname/Jones
- http://localhost:9000/lastname/Smith
- etc...

Now we will use the `ctx.pathParam()` method to retrieve this variable in java:

```java
app.get("/lastname/{name}", ctx -> {
    String lastName = ctx.pathParam("name");
});
```

Notice above, the variable name and the value thats put in the parameter of the `ctx.pathParam()` method must be identical. In this case the variable was called `name`.
