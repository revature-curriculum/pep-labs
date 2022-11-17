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
<tr><th> artists </th><th> songs </th></tr>
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



| id | artist       |
| ---- | --------     |
| 1 | The Beatles  |
| 2 | The Eagles   |
| 3 | Led Zeppelin |

| id | song | artist_fk |
| ---- | ------- | ---- |
| 1 | Let It Be | 1 |
| 2 | Imagine | 1 |
| 3 | Kashmir | 3 |

Note how the artist_fk column's values link the songs with the artists in the other table.
With this column and a foreign key constraint in place the tables are linked. If we tried
to add a new song to the songs table that did not first have a matching artist in the 
artist table we would be unable to insert that record. This is referential integrity. The 
foreign key constraint stops us from violating that integrity.

To create a table with a foreign key constraint we add the constraint after the column
definition. For example:
```SQL
CREATE TABLE songs (
    id SERIAL PRIMARY KEY,
    song VARCHAR(100),
    artist_fk INT REFERENCES artists(id)
);
```
Note that this syntax isn't uniform across all flavors of SQL. The line
`artist_fk INT REFERENCES artists(id)` adds our foreign key constraint. The column,
artist_fk holds INT type data and REFERENCES the id column of the artists table.
