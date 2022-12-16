# JDBC Walkthrough

JDBC stands for Java DataBase Connnectivity. It is utilized to connect our java code with a database. JDBC will allow us to execute SQL statements from java and retrieve the result set of that query to be utilized in java.

## JDBC classes to know
### **Connection**: Creates an active connection to a database
Example:
```java
Connection connection = DriverManager.getConnection(url,username,password);

//for this lab, we created a ConnectionUtil Singleton class so you do not have to worry about the credentials to the database.
//The connection statement will look more like this for this lab
Connection connection = ConnectionUtil.getConnection();
```

### **Statement**: An object that represents an SQL statement to be executed
Example:
```java
String sqlStatement = "SELECT * FROM users WHERE username = 'user123' AND password = 'pass123'"

Statement statement = connection.createStatement();
```

### Executing the SQL Statement 
How we execute the the statement object is different based on what sublanguage of sql we are working with. For example if we are trying to execute a DML statement, then there is only one more method we have to call

```java
statement.executeUpdate(sql);
```

On the other hand, if the sql statement is a dql operation, we will call the method `executeQuery(sql);` and store the value in a ResultSet object that we can loop through

```java
ResultSet rs = statement.executeQuery(sql);
```
### **ResultSet**: object that will store your data from the query that you executed. This will only be needed for DQL operations (as shown above).

## DQL Example

Retrieving all records from table users (DQL EXAMPLE):
```java
public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try {
            //retrieve active connection to db
            Connection connection = ConnectionUtil.getConnection();
 
            String sql = "select * from users;";

            //create the Statement object
            Statement statement = connection.createStatement();

            //execute the statement and retrieve result set
            ResultSet rs = statement.executeQuery(sql);

            //loop through each record and add record to user list object
            while(rs.next()){
                users.add(new User(rs.getString(1), rs.getString(2)));
            }
            //NOTE: in the above statement, rs.getString(1) is retrieving column 1 as a string from a record. in our situation, that will get the firstname. Since lastname is in the second column in the table, we retrieve that value by using rs.getString(2);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
```

## DML Example
Inserting a Record into Table users (DML EXAMPLE):
```java
public void createUser(User user) {
        try {
            //retrieve active connection to db
            Connection connection = ConnectionUtil.getConnection();

            //SQL statement we are going to execute
            String sql = "insert into users (firstname, lastname) values ('" + user.getFirstname() + "', '" + user.getLastname() + "');";

            //create Statement object
            Statement statement = connection.createStatement();

            //execute the statement to db
            statement.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
```

