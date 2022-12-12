# Background
SQL sublanguage: DDL (Data Definition Language)


The `TRUNCATE` keyword allows us to remove all records from a table but doesn't delete the table itself.

The syntax for truncating a table:
```sql
TRUNCATE TABLE table_name;
```
Additional reference material if needed: https://www.w3schools.com/sql/sql_drop_table.asp


NOTE: The documentation in W3 schools has a TRUNCATE demo under the DROP TABLE demo.

- - - 

# Lab

## Problem 1
users table
|   id  |     firstname        |        lastname        |
|-------|----------------------|------------------------|
|1      |'Steve'               |'Garcia'                |
|2      |'Alexa'               |'Smith'                 |
|3      |'Steve'               |'Jones'                 | 
|4      |'Brandon'             |'Smith'                 |
|5      |'Adam'                |'Jones'                 |

#### Problem1: remove all the records from the table "users"

- - -

## Problem 2 
Songs Table Diagram:
|      title        |        artist         |
|-------------------|-----------------------|
|'Let it be'        |'Beatles'              |
|'Imagine'          |'Beatles'              |
|'Kashmir'          |'Led Zeppelin'         |

#### Problem 2: remove all the records from the table "songs"
