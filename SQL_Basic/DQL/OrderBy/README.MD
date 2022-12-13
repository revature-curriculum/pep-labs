# Background
SQL sublanguage: DQL (Data Query Language)

When we query a database for information, that information is not necessarily ordered. Physically,
that information is serialized in some order, but it is not necessarily the order you might expect, and the
order is subject to change. When querying for information we usually want to indicate the order for our results.
This is done with the ORDER BY clause.

Example:
```sql
SELECT * FROM table_name ORDER BY column1 [, column2, column3, etc...] [ASC|DESC]
```

When ordering by multiple columns, the priority is from left to right.

We can order by columns in ascending or descending order. By default, `ORDER BY` is in ascending order. Ascending
order places lesser values before greater values. Descending order is the opposite, greatest values first.

For example, one might add the `ORDER BY` clause after the `WHERE` clause of a query to order employees from highest to
lowest salary:
```sql
SELECT * FROM employee_table WHERE current = true ORDER BY salary DESC
```

Additional reference material if needed: https://www.w3schools.com/sql/sql_orderby.asp

- - - 

# Lab

## Problem 1
character table
| id |  first_name  |  last_name  |
|----|--------------|-------------|
|1   |'Leto'        |'Atreides'   |
|2   |'Vladimir'    |'Harkonnen'  |
|3   |'Jessica'     |'Atreides'   |
|4   |'Paul'        |'Atreides'   |
|5   |'Feyd-Rautha' |'Harkonnen'  |

#### Problem 1: Write a statement below to query the database for all characters. Make sure the results are in ascending order by last name, and first name as a tie-breaker.
