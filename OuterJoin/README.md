# Outer Join
We looked previously at INNER JOIN where we will only see data from the tables where there is a match between the
columns we join ON. OUTER JOIN will return more results, including null data where the tables did not match based
on the columns used for joining. There are three types of OUTER JOIN: FULL, LEFT, and RIGHT.

Important Note: There are many implementations of Oracle's SQL standard, and they often differ slightly in grammar
and syntax. For instance, in PostGreSQL you can preform a FULL OUTER JOIN, however the H2 database engine used for
these activities does not support FULL OUTER JOIN, it only supports LEFT and RIGHT OUTER JOIN.

FULL OUTER JOIN will return results from both tables. Any rows that do not have a match between tables will have
missing data which will be shown as "null".

LEFT OUTER JOIN will return all data from table_left, and any missing data from table_right will be null.

RIGHT OUTER JOIN will return all data from table_right, and any missing data from table_left will be null.

Example:

<table>
<tr><th> table_left  </th></tr>
<tr><td>

| id | character |  species  |   
| -- | --------- | --------- |     
|1   |'Bugs'     |'Rabbit'   |     
|2   |'Daffy'    |'Duck'     |     
|3   |'Foghorn'  |'Chicken'  |

</td><td></tr></table>
<table></th><th> table_right </th></tr>
<tr><td>

| id | character | catchphrase |
| -- | ----------------- | --------- |
|1   |'Daffy' |'Youuu're deththpicable!'  |
|2   |'Elmer' |'I'm hunting wabbits.' |
|3   |'Porky' |'That's all folks!' |

</td></tr> </table>

Note that there is no record in the right table for Foghorn, and there is no record in the left table for
Porky. When we OUTER JOIN these two tables ON the character column, the missing data will be null. This is useful for finding rows where such a match does not exist, such as characters with no catchphrases, or catchphrases with no characters.

```SQL
SELECT * FROM table_left
FULL OUTER JOIN table_right ON table_left.character = table_right.character
```

Note: This example shows FULL OUTER JOIN which is valid in many databases, but recall that H2 does not support FULL 
OUTER JOIN. 

The output of the join would create the following result set:

<table><tr><th> results </th></tr><tr><td>

|  id  | character |  species  |  id  | character |        catchphrase        |
| ---- | --------------- | ---------- | ----- |-------------------|----------|
|1     |'Bugs'     |'Rabbit'   |1     |'Daffy'    |'Youuu're deththpicable!'  |
|2     |'Daffy'    |'Duck'     |2     |'Elmer'    |'I'm hunting wabbits.'     |
|3     |'Foghorn'  |'Chicken'  |null  |null       |null                       |
|null  |null       |null       |3     |'Porky'    |'That's all folks!'        |

</td></tr></table>

## Additional Resources
 - [Venn Diagram of Joins](https://stackoverflow.com/questions/13997365/sql-joins-as-venn-diagram)
 - [SQL Left Join](https://www.w3schools.com/sql/sql_join_left.asp)
 - [SQL Right Join](https://www.w3schools.com/sql/sql_join_right.asp)

# Lab
Consider the three tables below for the following problems:

<table>
<tr><th> class   </th><th> student </th><th> textbook </th></tr>
<tr><td>

| id |teacher_name   |class_title|   
| -- | ------------- | --------- |     
|1   |'Ms. Lovelace' |'Physics'  |   
|2   |'Ms. Lovelace' |'Math'     |
|3   |'Mr. McCarthy' |'Writing'  |
|4   |'Ms. Goodall'  |'Biology'  |

</td><td>

| id | student_name      |class_title|
| -- | ----------------- | --------- |
|1   |'John Stewart'     |'Writing'  |
|2   |'Stephen Colbert'  |'Physics'  |
|3   |'Samantha Bee'     |'Math'     |
|4   |'Aasif Mandvi'     |'Writing'  |
|5   |'Robert Riggle'    |'Physics'  |
|6   |'Jessica Williams' |'Art'      |

</td><td>

| id |class_title|              textbook_title        |
| -- | ----------------- | --------- |
|1   |'Physics'  |'Motion 101'                        |
|2   |'Math'     |'What Even Is Modulus Anyway?'      |
|3   |'Biology'  |'Lions, Tigers, and Organs 5th ed'  |
|4   |'Writing'  |'The Story Circle Workbook'         |
|5   |'Art'      |'Teenage Mutant Ninja Turtles #10'  |

</td></tr> </table>

## Problem 1
Problem 1: Use a LEFT OUTER JOIN to combine the class (left side) and student (right side) tables using the class column as the join on column. This means that when no student exists for a class, a row with a NULL class will be in the resulting query. Hint: You should start with `SELECT * FROM class`

## Problem 2
Problem 2: Use a RIGHT OUTER JOIN to combine the class (left side) and textbook (right side) tables using the class column as the join on column. This means that when no class exists for a textbook, a row with a NULL class will be in the resulting query. Hint: You should start with `SELECT * FROM class`


NOTE: please write the SQL statements on one line for this lab.
