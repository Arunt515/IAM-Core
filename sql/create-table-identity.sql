CREATE TABLE IDENTITIES
    (IDENTITY_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY
    CONSTRAINT IDENTITY_PK PRIMARY KEY, 
    IDENTITY_DISPLAYNAME VARCHAR(55),
    IDENTITY_EMAIL VARCHAR(55),
    IDENTITY_UID VARCHAR(55)
    );
  
    
    create table login
    ( uname varchar(20), password varchar(20));
    
    delete from login where UNAME='arun'
    
    select * from login;
    
   INSERT into login values('ARUN','ARUN');
    select * from login where uname like 'ARUNn' and password like 'ARUN';
    
    select *from IDENTITIES;