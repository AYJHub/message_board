    create database messageBoard  
 
    use messageBoard  
      
    create table users  
    (  
        id int not null primary key,  
        name varchar(20) not null,  
        password varchar(20) not null,  
        role int not null  
    )  
      
    create table messagess  
    (  
        id int not null,  
        name varchar(20) not null,  
        time datetime not null,  
        title varchar(20) not null,  
        message varchar(50) not null  
    )  