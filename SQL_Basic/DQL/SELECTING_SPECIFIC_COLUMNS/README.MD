# Background
SQL sublanguage: DQL (Data Query Language)

We have learned how to query all records from a table as well as filter the amount of records we get back utilizing the `WHERE` keyword.

In this lab we are going to learn how to filter the amount of columns that we want returned.

Let's take a look at the syntax to return an entire table again:
```sql
 SELECT * FROM table_name;
```

In the statement above, the * is the wildcard to retrieve all the columns in this specific table.
However, we can specify the columns that we want to display by the following syntax:
```sql
 SELECT col_1, col_2, ...col_N FROM table_name;
 ```

Additional reference material if needed: https://www.w3schools.com/sql/sql_select.asp
- - - 

# Lab

## Problem 1
site_user table
|   id  |     firstname        |        lastname        |
|-------|----------------------|------------------------|
|1      |'Steve'               |'Garcia'                |
|2      |'Alexa'               |'Smith'                 |
|3      |'Steve'               |'Jones'                 |
|4      |'Brandon'             |'Smith'                 |
|5      |'Adam'                |'Jones'                 |

#### Problem 1: Write the SQL statement to return only the 'firstname' column from the site_user table
