INSERT INTO IDENTITIES (IDENTITY_DISPLAYNAME, IDENTITY_EMAIL, IDENTITY_UID)
    VALUES ('Quentin Deca', 'qdeca@qdeca.com', '5678');
    
    
    select * from IDENTITIES
    
    UPDATE IDENTITIES SET IDENTITY_DISPLAYNAME = 'arun', IDENTITY_EMAIL = 'arun@email' WHERE IDENTITY_UID = '3'
    
    
    select IDENTITY_DISPLAYNAME, IDENTITY_EMAIL, IDENTITY_UID from IDENTITIES where IDENTITY_DISPLAYNAME like '' or IDENTITY_EMAIL like 'ARUN@EMAIL'