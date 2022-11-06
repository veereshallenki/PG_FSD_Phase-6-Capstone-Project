/*
create table Teachers (tid int primary key, tname  varchar(30));

--  insert into Teachers values(1, "ABC"); //this is to test in MYSQL 
-- insert into Teachers values(?, ?);  //this is to plug in java class

create table Subjects (subid int primary key, subname  varchar(30));

--  insert into Subjects values(1, "ABC"); //this is to test in MYSQL 
-- insert into Subjects values(?, ?);  //this is to plug in java class
/*
create table classroomteacher (sno int primary key, classroomid  int, subid int, 
index par_ind(subid),  FOREIGN KEY (subid) references Subjects(subid),
tid int, index tea_ind(tid),FOREIGN KEY (tid) references Teachers(tid)  );
*/
/*
create table classroomteacher (sno INT UNSIGNED NOT NULL AUTO_INCREMENT,
     PRIMARY KEY (sno), classroomid  int, subid int, 
index par_ind(subid),  FOREIGN KEY (subid) references Subjects(subid),
tid int, index tea_ind(tid),FOREIGN KEY (tid) references Teachers(tid)  );

*/

-- this table holds users details
create table MedicareUsers(id int UNSIGNED NOT NULL AUTO_INCREMENT,
     PRIMARY KEY (id), name  varchar(30), email  varchar(30), country varchar(30));
	 
create table medicare_users (
       id integer not null auto_increment,
        country varchar(255),
        email varchar(255),
        name varchar(255),
        password varchar(255),
        primary key (id)
    );

create table medicines (
       id integer not null auto_increment,
        category varchar(255),
        enable_flag char(1) not null,
        name varchar(255),
        price float not null,
        url varchar(255),
        primary key (id)
    );	