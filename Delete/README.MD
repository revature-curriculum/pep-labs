# Background
SQL sublanguage: DML (Data Manipulation Language)

The `DELETE` keyword is utilized to remove records based on a condition.

The syntax for deleting records from a table is as follows:
```sql
 DELETE FROM table_name WHERE condition;
 ```

NOTE: Whenever you execute a `DELETE` statement, have a `WHERE` condition that identifies exactly what records you would like to delete.
Leaving this out will remove ALL records from the table.

Additional resource if needed: https://www.w3schools.com/sql/sql_delete.asp

- - - 

# Lab

## Problem 1
site_user table:
```
|   id  |     firstname        |
|-------|----------------------|
|1      |'Steve'               |
|2      |'Alexa'               |
|3      |'Steve'               |
|4      |'Brandon'             |
|5      |'Adam'                |
```

#### Problem 1: Delete everyone named "Steve" from the site_user table in problem1.sql

- - -
