# TIL (Today I Learned)
### git is fun



## Nov 14 2017
Realized git and github were two entirely different entities. Learned basic commands of git commandline and soon realized it was better to use commandline than git gui. Performed 'push' and 'pull' to and from my repo in the newly created github account. Staging, merging, branching are few other things i learned today.

Additionally, I added ssh pubpublic keys to my git account so that i did not have to write my uname and password each time I communicate to github server.

##### Summary of command used:

```bash

$ git init
$ git add -A
$ git commit -m "first commit"
$ git remote set-url origin <url- name>
$ git push origin master
$ git branch -D HEAD
$ git checkout -b hotfix

```

At the end of day learned techniques to write the TIL

## Dec 5, 2017

### check myql version:
```bash
mysqladmin - - version
```

### setup admin and password for root
```bash
myqladmin - u root password "1234"
```

### show databases
```mysql
show databases;
```

###  quit
```mysql
quit;
```

### login to the server
```mysql
mysql - u root - p
```
### to change a database
```mysql
use mysql
```

### show the tables
```mysql
show tables
```

### show the columns from user
```mysql
show columns from user
```
### creating a new user with some privileges
```mysql
 insert into user
    - > (host, user, password,
    - > select_priv, insert_priv, update_priv)
    - > values('localhost', 'raj',
    - > password('shovan2017'), 'Y', 'Y', 'Y');
```
###
```mysql
select host, user, password from user where user = 'raj';
```

```bash
+- - - - - - - - - - - +- - - - - - +- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +
| host      | user | password                                  |
+- - - - - - - - - - - +- - - - - - +- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +
| localhost | raj  | *2471A325C889DC85A02E9679496540F428372234 |
+- - - - - - - - - - - +- - - - - - +- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +
```

### another way of creating a user
```mysql
grant all privileges on *.* to 'chris'@'localhost';
```
-  flush priveleges to refresh mysql server so that the new user will be able to connect to mysql server
-  if you don't do this, you will be unable to login as raj
flush privileges

### delete a user 
```mysql
drop user 'raj'@'localhost';
```
### creating a database
```mysql
create database my_database;
```
### deleting a database
```mysql
drop database my_database;
```
### creating tables
- create table <table_name> <give_structure>

```mysql
create table teams_tbl(
team_id int not null auto_increment,
team_name varchar(100) not null,
team_captain varchar(40) not null,
establishment_date date,
primary key(team_id)
 );
```    
### delete a table
```myql
drop table teams_tbl;
```
### show columns of the table
```mysql
show columns from teams_tbl;
```
### alternative
```mysql
describe teams_tbl;
```
### inserting data into tables
```mysql
insert into teams_tbl
(team_name, team_captain, establishment_date )
values
("begaris", "swain shrestha",'2017- 10- 12');
```
- A ```CHAR``` field is a fixed length, and ```VARCHAR``` is a variable length field.

- This means that the storage requirements are different -  a ```CHAR``` always takes the same amount of space regardless of what you store, whereas the storage requirements for a VARCHAR vary depending on the specific string stored.

### inserting more data
```mysql
insert into teams_tbl (team_name, team_captain, establishment_date ) values ("new guy", "ingroj oldboy",NOW());
```
-  here the ```NOW()``` function gives the current date 

### to show all data in tables
```mysql
select * from teams_tbl;
```

### extract data from table
```mysql
select team_id, team_captain from teams_tbl;
```

### using where 
```mysql
select * from teams_tbl where team_captain = "swain shrestha";

select * from teams_tbl where establishment_date > '2017- 11- 00';

select * from teams_tbl where team_name is null;
```
-  for checking null don't use ```=``` instead use ```is``` operator

### using multiple conditions with where
```mysql
select team_name from teams_tbl where team_captain = "swain shrestha" and establishment_date > "2017- 09- 00";
```
- remember you can also extract multiple fields across multiple tables

```mysql
insert into teams_tbl (team_name, team_captain, establishment_date ) values ("hawadari", "swain shrestha",'2017- 10- 48');
```
-  if you provide invalid date like 48 here, your date will be set to 0000- 00- 00

```mysql
select * from teams_tbl where (year(now())- year(establishment_date )) <5; 
```

### using order by with limit
```mysql
select * from teams_tbl order by establishment_date asc limit 1;
```
- here the 'limit' sets the number of outputs to 1 i.e. only the first of the ordered list is given

### group by groups having the same value in specified field
```mysql
select * from teams_tbl group by team_captain order by team_name asc;
```

### selecting data from multiple table linked by a foreign key
```mysql
select team_name, result_type from teams_tbl, results_tbl
where teams_tbl.team_id = results_tbl.team_id;
```

### delete with where
```mysql
delete from teams_tbl where team_id = 5;
```

### delete all
```mysql
delete from teams_tbl;
```
- no need to put '*' in delete statement

### updating fields of the table
```mysql
update teams_tbl set team_captain = 'sushila kumari' where team_id = 4;
```

### using the like clause to select elements
```mysql
select * from teams_tbl where team_captain like 's%';
```
-  here % sign is like a wildcard where it can be replcaed with any group of characters

### RegExp

Pattern	 | what the pattern matches
- - - - - - - - - -  | - - - - - - - - - 
^|beginning of string
$|end of string
.|any single character
[...]|any character listed between the square brackets
[^...]|any character not listed between the square brackets
[p1\|p2\|p3]|alternation, matchces any of the patterns p1,p2, or p3
*|zero or more instances of preceding element
+|one or more instances of preceding element
{n}|n instances of preceding element
{m, n}|m through n instances of preceding element

```mysql
select * from teams_tbl where team_name regexp '^b';
```
- select row with team_name beginning with b

```mysql
select * from teams_tbl where team_name regexp 'UTD$';
```
- team names ending with UTD

```mysql
select team_name from teams_tbl where team_name regexp '^[e]|UTD$';
```
- team whose name starts from e or ends with UTD
- it is case- insensitive so using utd or UTD is the same


### alter clause
- dropping a column 

```mysql
alter table crowds_tbl drop game_date;
```
- adding a column

```mysql
alter table crowds_tbl add date_of_date date not null;
```
- adding new column as first column

```mysql
alter table crowds_tbl add game_date not null first;
```
- adding new column in the midst of the table

```mysql
alter table crowds_tbl add game_data not null after game_id;
```
- modify the type of column ie. the field

```mysql
alter table crowds_tbl modify mycolumn varchar(10);
```

- rename the table

```mysql
alter table crowds_tbl rename to fans_tbl;
```

### creating indexes
```mysql
create unique index est_index on teams_tbl (establishment_date );
```
-  for unique index each value of the column establishment_date must have a unique value

alter table tbl_name add primary key (column_list);
- adding a primary key to the table

alter table tbl_name add unique index_name (column_list);
- removing unique make a simple index denoted as 'MUL'
- unique index are denoted as 'UNI'

### creating temporary tables
```mysql
create temporary table teams_tbl(
team_id int not null auto_increment,
team_name varchar(100) not null,
team_captain varchar(40) not null,
establishment_date date,
primary key(team_id)
 );
```
   
### cloning just  table structure
```mysql
show create table teams_tbl \G;
```
- gives the command used to create the table
- then copy and paste the command changing the table name

```mysql
create table clone_teams_tbl(
team_id int not null auto_increment,
team_name varchar(100) not null,
team_captain varchar(40) not null,
establishment_date date,
primary key(team_id)
 );
```
## Dec 12, 2017
### cloning table with its data
```mysql
insert into clone_teams_tbl (team_id, team_name, team_captain, establishment_date)
select * from teams_tbl;
```
### to write from a file to a table enable infile option as

```bash
mysql - -  local- infile=1 - u root - p
``` 

### exporting to a file
```mysql
select * from teams_tbl into outfile '/var/log/mysql/teams.txt';
```
-  this method does not work and states some error about ```file- priv```

### enable reading table from file into database
```bash
mysql - - local- infile=1 - u root - p
```
### exporting as a CSV
```mysql
select * from teams_tbl into outfile "/var/log/mysql/teams_data.txt" fields terminated by ',' enclosed by '"' lines terminated by '\r\n';
```
-  this command also does not work

### loading data
```mysql
load data local infile '/home/shovan/table.txt' into clone_teams_tbl fields terminated by ',' enclosed by '"' lines terminated by '\r\n';
```

### export a database to a txt file using mysqldump
```mysql
mysqldump - u root - p teams_db teams_tbl > ~/Desktop/teams_tbl_dump.txt;
```
- if you don't specify teams_tbl you will export the whole database into the text file

### loading data into db using mysqldump
```bash
mysql - u root - p teams_db < Desktop/teams_tbl_dump.txt 
```

### import data using mysql import
```bash
mysqlimport - u root - p - - local tmp_db ~/Desktop/teams_tbl.txt
```
-  note that you must have already created tmp_db in your server

### import data for csv file
```bash
mysqlimport - u root - p - - local - - fields- terminated- by="," - - lines- terminated- by="\r\n" database_name dump.txt
