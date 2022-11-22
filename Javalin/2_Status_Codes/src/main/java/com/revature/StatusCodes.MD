# Javalin Lab: Changing the Status Code in a HTTP Response

As we mentioned in the first javalin lab, status codes are how we tell the client machine how successful the HTTP Request was. HTTP Responses have 5 main categories of status codes:

There are 5 categories of status code responses:
- `100`: Request was informational
- `200`: Request was successful
- `300`: Request is being redirected
- `400`: Request failed due to a client-side error
- `500`: Request failed due to a server-side error


## Changing the status code in Javalin

```java
app.get("/server-side-err", ctx -> {
    ctx.status(500);
});
```

The only line we need to add to achieve this is `ctx.status(500);` 

500 represents a server side error (as shown int the notes above)
