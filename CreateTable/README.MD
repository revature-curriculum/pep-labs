# Background
As of right now, all of the data that we are storing into variables in java are lost when the application ends. We need a tool that will 
allow us to persist data permanently. This tool is called a database.
The specific type of database we will be utilizing uses a language called SQL.

SQL stands for Structured Query Language.

Before we store or retrieve any data, we need to define the format in which it is stored. SQL utilizes tables as its format.
This follows a similar format to a spreadsheet. The tables will have rows and columns.

A column defines one attribute of a table.
A row defines a one complete item in the table.

Let's create our first SQL table.
The syntax for Creating a table is as follows:
```roomsql
CREATE TABLE table_name(
     variable_name datatype constraint,
     ...
);
```
Note: there are two terms above that we need clarity on:
- `datatype`:
     - A datatype defines what type of data we will be storing into this specific column.
     - Common datatypes:
         - `int`: stores whole numbers
         - `double precision`: stores decimal numbers
         - `varchar(100)`: stores a string of 100 characters maximum
         - `boolean`: stores true and false values
- `constraint`:
     - a constraint is a rule we can add to a column that anyone who wants to insert records into this table must follow
     - Common Constraints:
         - `NOT NULL`: the column must have a value when inserting a record
         - `UNIQUE`: every record in a specific column must have a unique value
     - If a constraint that was defined is not met when inserting a record, a SQLException will be thrown.


Additional reference material if needed:
- https://www.w3schools.com/sql/sql_create_table.asp
- https://www.w3schools.com/sql/sql_constraints.asp

- - - 

# Lab

## Problem 1
song table
| title     | artist  |    	    
|-----------|---------|
| Let it be | Beatles |          
| Imagine   | Beatles |

#### Problem 1: Create a new table in the "problem1.sql" file called "song" with 2 columns "Title" and "Artist" (shown above). Both columns should have the datatype varchar(255), which represents a String of up to 255 characters.