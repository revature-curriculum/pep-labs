# Background
 SQL sublanguage: DQL (Data Query Language)

 NOTE: Before attempting this activity, you should have already completed the Order By
 and Aggregate Functions activities.

 The `GROUP BY` clause allows you to group your results and can be used with the `ORDER BY` clause. `GROUP BY` is
 used in conjunction with aggregate functions. However, you cannot group by the output of the function.
 Recall that the output of an aggregate function is a single aggregate value.

employee table
|  id  |     employee   |   manager    |  salary  |
|------|----------------|--------------|----------|
|1     |'Steve'         |'Dave'        |67400.00  |
|2     |'Alexa'         |'Dave'        |42500.00  |
|3     |'Sarah'         |'Jane'        |99890.99  |
|4     |'Brandon'       |'Jane'        |120000    |
|5     |'Adam'          |'Dave'        |55050.50  |

 Example: You could query the above table with the `AVG()` aggregate function and `GROUP BY` manager to find the
 average salary of employees under that manager (then order it from greatest average salary to least):

```sql
SELECT manager, AVG(salary)
FROM employees
GROUP BY manager
ORDER BY AVG(salary) DESC;
```

 Additional Reference if needed: https://www.w3schools.com/sql/sql_groupby.asp

- - - 

# Lab

## Problem 1
song table
| id |     artist     |        album        |         song         |
|----|----------------|---------------------|----------------------|
|1   |'The Beatles'   |'Abbey Road'         |'Come Together'       |
|2   |'The Beatles'   |'Let It Be'          |'Let It Be'           |
|3   |'Led Zeppelin'  |'IV'                 |'Black Dog'           |
|4   |'Led Zeppelin'  |'Physical Graffiti'  |'Kashmir'             |
|5   |'Led Zeppelin'  |'IV'                 |'Going to California' |
|6   |'The Eagles'    |'Hotel California'   |'Hotel California'    |

#### Problem 1: Use the `GROUP BY` clause with the `COUNT()` aggregate function to query the song table for the number of songs by each artist. The result of the query should have two columns: the artist, and the count(song) of the artist.
HINT: You should avoid using the wild card (*) in your statement. All projected columns must either be used in the `GROUP BY` clause or an aggregate function.
