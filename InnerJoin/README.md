# INNER JOIN
Sometimes we want to query results from multiple tables. We can achieve this by doing a JOIN to include data from 
other tables. We start with SELECT FROM left_table, and we can JOIN right_table.  

There are several types of joins. We will be looking at INNER JOIN here. INNER JOIN is when we query two or more 
tables on some criteria, and only see results where there are matching rows in all tables. For example:
```sql
SELECT * FROM table_left INNER JOIN table_right 
ON table_left.column1 = table_right.column3;
```

Note: The text added to a simple select statement includes INNER, JOIN, and ON keywords. We join one table to 
another based on some condition that matches rows from both tables together. In the above example we are matching 
rows from table_left which have the same value in column 1 as those in table_right column 3. 

You can add more parts to this SQL query, for instance, you can also filter within this query. Example:
```sql
SELECT * FROM table_left INNER JOIN table_right
ON table_left.column1 = table_right.column3
WHERE table_left.column1 = value;
```

<table>
<tr><th> class </th></tr><tr><td>

| id | teacher_name  |class_title|    
| -- | ------------- | --------- |     
|1   |'Ms. Lovelace' |'Physics'  |     
|2   |'Ms. Lovelace' |'Math'     |     
|3   |'Mr. McCarthy' |'Writing'  |     
|4   |'Ms. Goodall'  |'Biology'  |
</td></tr>
</table>

<table>
<tr><th> student </th></tr><tr><td>

| id |   student_name    |class_title|
| -- | ----------------- | --------- |
|1   |'John Stewart'     |'Writing'  |
|2   |'Stephen Colbert'  |'Physics'  |
|3   |'Samantha Bee'     |'Math'     |
|4   |'Aasif Mandvi'     |'Writing'  |
|5   |'Robert Riggle'    |'Physics'  |
|6   |'Jessica Williams' |'Art'      |

</td></tr> </table>

We can query these tables with an INNER JOIN ON the "class" column in each table:
```SQL
SELECT * FROM class
INNER JOIN student ON class.class_title = students.class_title;
```

The output of the join would create the following result set:

<table><tr><th> results </th></tr><tr><td>

| class.id | class.teacher_name | class.class_title | student.id | student.student_name | student.class_title |
|--------|--------------------|-------------------|-------------|----------------------|---------------------|
| 1      | 'Ms. Lovelace'        | 'Physics'         | 2           | 'Stephen Colbert'    | 'Physics'           |
| 1      | 'Ms. Lovelace'        | 'Physics'         | 5           | 'Robert Riggle'      | 'Physics'           |
| 2      | 'Ms. Lovelace'     | 'Math'            | 3           | 'Samantha Bee'       | 'Math'              |
| 3      | 'Mr. McCarthy'     | 'Writing'         | 1           | 'John Stewart'       | 'Writing'           |
| 3      | 'Mr. McCarthy'     | 'Writing'         | 4           | 'Aasif Mandvi'       | 'Writing'           |

</td></tr></table>

NOTE: Both teacher Ms. Goodall and student Jessica Williams would not be included in the results. This is because 
there is no matching record in the opposite table for either of those records. (There is no art teacher, and there 
are no students taking biology.)

## Additional Resources
 - [SQL Inner Join](https://www.w3schools.com/sql/sql_join_inner.asp)

# Lab

Problem 1: Write a query that will return the id and student_name of each of Ms. Lovelace's students. Notice that
Ms. Lovelace teaches two classes, but which classes she teaches aren't known from the data in the student
table. This means that you will need a way to combine the data from the two tables (inner join). You will
need to simultaneously filter those results WHERE class.teacher_name = student.student_name to retrieve only her students from the resultset shown above.

Note: There should not be a wild card (*) in your statement. You will need to specify the columns in your statement by writing columns in the format table.column (for instance, student.class_title), because the column names may be ambiguous between class and student.


NOTE: please write the SQL statement on one line for this lab.