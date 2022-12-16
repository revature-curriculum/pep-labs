# Background
SQL sublanguage: DQL (Data Query Language)

Aggregate functions in SQL are functions which preform operations on multiple rows to produce a single output.
For instance, `COUNT()` is an aggregate function. Count will return the number of rows of data in the result set.
So if we query a table with 12 rows using a statement like this:
```sql
SELECT COUNT(*) FROM table_name;
```
We should get the value 12

Aggregate functions "aggregate" data, combining and changing it into some output based on the input. Regardless of
how large that input is, the output will always be a single value. If we repeated the above query but the table had
10,000 rows, the result would still be a single value: 10,000.

There are many aggregate functions built into SQL, some commonly used ones include:
- `SUM()` - outputs the sum of the values in a single column from the result set
- `AVG()` - outputs the average (mean) value of the values in a single column from the result set
- `MIN()` - outputs the least value among the values in a single column from the result set
- `MAX()` - similar to MIN but outputs the greatest value
- `FIRST()` - outputs the first value found in a column of the result set
- `LAST()` - outputs the last value found in a column of the result set

Example: You might use the `SUM()` function to find the total of all employee salaries:
```sql
SELECT SUM(salary) FROM employee;
```

Additional reference material if needed:
- https://www.w3schools.com/sql/sql_count_avg_sum.asp
- https://www.postgresql.org/docs/9.5/functions-aggregate.html

- - - 

# Lab

## Problem 1
employee table
|  id  |   first_name   |   last_name   |  salary  |
|------|----------------|---------------|----------|
|1     |'Steve'         |'Garcia'       |67400.00  |
|2     |'Alexa'         |'Smith'        |42500.00  |
|3     |'Steve'         |'Jones'        |99890.99  |
|4     |'Brandon'       |'Smith'        |120000    |
|5     |'Adam'          |'Jones'        |55050.50  |

#### Problem 1: use the `SUM()` aggregate function to output the total of all salaries found in the table.

Note: the output should not contain any other info but the sum.

- - -

## Problem 2 
employee table
|  id  |   first_name   |   last_name   |  salary  |
|------|----------------|---------------|----------|
|1     |'Steve'         |'Garcia'       |67400.00  |
|2     |'Alexa'         |'Smith'        |42500.00  |
|3     |'Steve'         |'Jones'        |99890.99  |
|4     |'Brandon'       |'Smith'        |120000    |
|5     |'Adam'          |'Jones'        |55050.50  |

#### Problem 2: use the `COUNT()` aggregate function to output the number of employees with the last name "Smith".

Note: the output should not contain any other info but the count

- - -

## Problem 3 
employee table
|  id  |   first_name   |   last_name   |  salary  |
|------|----------------|---------------|----------|
|1     |'Steve'         |'Garcia'       |67400.00  |
|2     |'Alexa'         |'Smith'        |42500.00  |
|3     |'Steve'         |'Jones'        |99890.99  |
|4     |'Brandon'       |'Smith'        |120000    |
|5     |'Adam'          |'Jones'        |55050.50  |

#### Problem 3: use the `MIN()` aggregate function to return the lowest salary.
Note: the output should not contain any other info but the salary.

- - -

## Problem 4 
employee table
|  id  |   first_name   |   last_name   |  salary  |
|------|----------------|---------------|----------|
|1     |'Steve'         |'Garcia'       |67400.00  |
|2     |'Alexa'         |'Smith'        |42500.00  |
|3     |'Steve'         |'Jones'        |99890.99  |
|4     |'Brandon'       |'Smith'        |120000    |
|5     |'Adam'          |'Jones'        |55050.50  |

#### Problem 4: use the `MAX()` aggregate function to return the highest salary.

Note: the output should not contain any other info but the salary.