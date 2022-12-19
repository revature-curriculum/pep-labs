# SQL Views
A VIEW in SQL is a virtual table that was created based on a SQL statement 
that was predefined. For example, lets say we had the following table:

<table><tr><th> site_user </th></tr><tr><td>

|   id  |     firstname        |        lastname        |   age   |
| ----- | ------------------ | ---------------------- | ---- |
|1      |'Steve'               |'Garcia'                |23       |
|2      |'Alexa'               |'Smith'                 |40       |
|3      |'Steve'               |'Jones'                 |29       |
|4      |'Brandon'             |'Smith'                 |50       |
|5      |'Adam'                |'Jones'                 |61       |

</td></tr></table>

If we wanted to retrieve all the records with the firstname 'Steve', we 
can do that with the following statement: SELECT * FROM site_user WHERE 
firstname = 'Steve';

<table><tr><th> steve_view </th></tr><tr><td>

|   id  |   firstname    |    lastname    | age   |
| ----- | -----------  | ---------- |-------|
| 1   | 'Steve'         | 'Garcia'  | 23    |
| 3   | 'Steve'        |  'Jones'    | 29    |

</td></tr></table>

What we can do is put this virtual table in a view, so we can query data 
based on the virtual table above instead of the actual table in the 
database.

The syntax for creating a view is as follows:
```SQL
CREATE VIEW view_name AS sql_statement;
```

So the syntax for creating the 'steve view' table above would be:
```SQL
CREATE VIEW steve_view AS SELECT * FROM site_user WHERE firstname = 'Steve';
```
This is beneficial because we can now execute SQL queries on this view 
instead of the entire table. For example if I wanted to get the average 
ages of all the steves, I can do that with this new view and the 
aggregate function AVG() like so: `SELECT AVG(age) from steve_view;`

## Additional Reference Material
 - [SQL Views](https://www.w3schools.com/sql/sql_view.asp)

# Lab
For the following problems, consider the site_user table below:
<table><tr><th> site_user </th></tr><tr><td>

|   id  |     firstname        |        lastname        |   age   |
| ----- | ------------------ | ---------------------- | ---- |
|1      |'Steve'               |'Garcia'                |23       |
|2      |'Alexa'               |'Smith'                 |40       |
|3      |'Steve'               |'Jones'                 |29       |
|4      |'Brandon'             |'Smith'                 |50       |
|5      |'Adam'                |'Jones'                 |61       |

</td></tr></table>

### Problem 1
Create a view called "firstname_lastname" from the site_user table 
that only has the firstname and lastname columns.  

NOTE: This view should NOT contain the id and age columns.

NOTE2: please write the SQL statement on one line for this lab.