# Foreign Key Constraint
We know how to create simple tables. 
Now we need to relate these tables to each other. This is a crucial part
of relational databases. Foreign keys are used to link tables together, and
to enforce referential integrity.

A foreign key is a column in a table which matches another column in another table.
The most common way this is done is to match the foreign key column to the primary 
key in another table.

For example we have two tables, artists and songs.  

<table>
<tr><th> artist </th><th> song </th></tr>
<tr><td>

| id | artist |
| ---- | -------- |
| 1 | The Beatles |
| 2 | The Eagles |
| 3 | Led Zeppelin |

</td><td>

| id | song |
| ---- | ------- |
| 1 | Let It Be |
| 2 | The Eagles |
| 3 | Kashmir |

</td></tr> </table>

These two tables could be related. 'Let It Be' and 'Imagine' are both by The Beetles.
'Kashmir' is Led Zeppelin. One of the two tables will need a foreign key column which
will match the primary key in the other table. Let's add this column to the songs table 
so they look like this:

<table>
<tr><th> artist </th><th> song </th></tr>
<tr><td>

| id | artist       |
| ---- | --------     |
| 1 | The Beatles  |
| 2 | The Eagles   |
| 3 | Led Zeppelin |

</td><td>

| id | song | artist_fk |
| ---- | ------- | ---- |
| 1 | Let It Be | 1 |
| 2 | Imagine | 1 |
| 3 | Kashmir | 3 |

</td></tr> </table>

Note how the artist_fk column's values link the songs with the artists in the other table.
With this column and a foreign key constraint in place the tables are linked. If we tried
to add a new song to the songs table that did not first have a matching artist in the 
artist table we would be unable to insert that record. This is referential integrity. The 
foreign key constraint stops us from violating that integrity.

To create a table with a foreign key constraint we add the constraint after the column
definition. For example:
```SQL
CREATE TABLE song (
    id SERIAL PRIMARY KEY,
    song VARCHAR(100),
    artist_fk INT REFERENCES artist(id)
);
```
Note that this syntax isn't uniform across all flavors of SQL. The line
`artist_fk INT REFERENCES artist(id)` adds our foreign key constraint. The column,
artist_fk holds INT type data and REFERENCES the id column of the artists table.

## Additional Reference Material
 - [Foreign Keys](https://www.w3schools.com/sql/sql_foreignkey.asp)

# Lab
For the following problems, consider the site_user table below:
<table><tr><th> site_user </th></tr><tr><td>

| id | firstname | lastname |
| ----- | -------------------- | ---------------------- |
|1      |'Steve'               |'Garcia'                |
|2      |'Alexa'               |'Smith'                 |
|3      |'Steve'               |'Jones'                 |
|4      |'Brandon'             |'Smith'                 |
|5      |'Adam'                |'Jones'                 |

</td></tr></table>

### Problem 1
Create a new table in the file problem1.sql named Post. This table will contain posts
linked to specific users. It should have three columns: id (which is of type serial, and is a primary key), 
post (of type varchar(255)), and user_fk (which is of type int, but is also a foreign key referencing the id column
of the table site_user).

Be sure that user_fk column should be an int foreign key that references the id column in the 
site_user table. The table will look like this:

<table><tr><th> post </th></tr><tr><td>

| id | post | user_fk |
| -- | ---- | ------- |
| ... | ... | ... |

</td></tr>
</table>