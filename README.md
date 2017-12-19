# Mysql Assignment
The program has been done in DAO pattern.
## Run the program as
### Steps:
- You need to ```import``` the database Students.csv in your local db server
- create a user: ```user77``` with password: ```pa$$77```
- then run the jar file as
```bash
java -jar db_extractor.jar 
```
## sample output
```bash
Selection without indexing
the query took 6 ms
User [id=null, first_name=art, last_name=miller, address=doncaster east, class_no=2]
User [id=null, first_name=art, last_name=miller, address=kallista, class_no=5]
User [id=null, first_name=art, last_name=miller, address=rolling meadows, class_no=5]
User [id=null, first_name=art, last_name=miller, address=waterford, class_no=6]
User [id=null, first_name=khloe, last_name=miller, address=durham downs, class_no=3]
User [id=null, first_name=khloe, last_name=miller, address=new york, class_no=9]
User [id=null, first_name=don, last_name=miller, address=richmond, class_no=6]
User [id=null, first_name=khloe, last_name=miller, address=phoenix, class_no=10]
User [id=null, first_name=sean, last_name=miller, address=anchorage, class_no=1]
...



*******************
Selection with indexing
the query took 1 ms
User [id=null, first_name=art, last_name=miller, address=doncaster east, class_no=2]
User [id=null, first_name=art, last_name=miller, address=kallista, class_no=5]
User [id=null, first_name=art, last_name=miller, address=rolling meadows, class_no=5]
User [id=null, first_name=art, last_name=miller, address=waterford, class_no=6]
User [id=null, first_name=khloe, last_name=miller, address=durham downs, class_no=3]
User [id=null, first_name=khloe, last_name=miller, address=new york, class_no=9]
User [id=null, first_name=don, last_name=miller, address=richmond, class_no=6]
User [id=null, first_name=khloe, last_name=miller, address=phoenix, class_no=10]
User [id=null, first_name=sean, last_name=miller, address=anchorage, class_no=1]
User [id=null, first_name=art, last_name=miller, address=san carlos, class_no=8]
User [id=null, first_name=khloe, last_name=miller, address=richland, class_no=7]
User [id=null, first_name=art, last_name=miller, address=runnymede, class_no=1]
User [id=null, first_name=khloe, last_name=miller, address=north dandalup, class_no=5]
User [id=null, first_name=khloe, last_name=miller, address=yallah, class_no=2]
User [id=null, first_name=art, last_name=miller, address=manjimup, class_no=7]
...
```
- clearly, the selection with indexing is much faster 
