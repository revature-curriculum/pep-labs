# Background
SQL sublanguage: DDL (Data Definition Language)


Let's say we created the following table:

|    id    |     firstname     |
|----------|-------------------|
|1         |'Kevin'            |
|2         |'Brian'            |
|3         |'Charles'          |

The site_user table when it was created, forgot to add the 'lastname' column.


We could go about solving this in 2 different ways:
- We could remove the table completely and create the table again with the correct number of columns
- We can use the `ALTER` keyword to add a new column to the existing table. (This is what we will be looking at for this lab)
The `ALTER` keyword allows us to add / remove columns and constraints on an existing table.
The syntax for the `ALTER` keyword is different depending on what we want to achieve:
     - Adding a column:
         - ```sql ALTER TABLE table_name ADD column_name data_type [constraint];```
     - Removing a column:
         - ```sql ALTER TABLE table_name DROP column_name;```

NOTE: the [] in the "Adding a column" syntax means that the constraint is optional

Additional reference material if needed: https://www.w3schools.com/sql/sql_alter.asp

- - - 

# Lab

## Problem 1
site_user table
|    id    |     firstname     |
|----------|-------------------|
|1         |'Kevin'            |
|2         |'Brian'            |
|3         |'Charles'          |

#### Problem 1: Use the ALTER keyword to add a "lastname" column to the "site_user" table, of type varchar(100).