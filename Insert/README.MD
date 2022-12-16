# Background
 SQL sublanguage: DML (Data Manipulation Language)

 Now that we can create and drop tables, we need to be able to insert records into the table.

 The syntax for inserting a record is as follows:
  ```sql
  INSERT INTO table_name (col_1, col_2, ...col_N) VALUES (val_1, val_2, ...val_N);
  ```

in the above statement:
      - "col_1, col_2, ...col_N"  is referring to the column name of the table.
      - "val_1, val_2, ...val_N" is referring to the data we are trying to insert into that specific column.

 Additional reference material if needed: https://www.w3schools.com/sql/sql_insert.asp

- - - 

# Lab

## Problem 1
song Table Diagram:
|      title        |        artist         |
|-------------------|-----------------------|
|'Let it be'        |'Beatles'              |
|'Hotel California' |'Eagles'               |
|'Kashmir'          |'Led Zeppelin'         |

Note: when inserting strings, you wrap the string in a single quote.

#### Problem 1: Assuming the table "song" already exists, write the sql statement in the problem1.sql file that allows us to add a new record into the table "song". It should work with any values for title and artist!

- - -
