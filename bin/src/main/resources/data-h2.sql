--------------------------------------------------------
--  DDL for Sequence BUCKET_ID_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE IF EXISTS BUCKET_ID_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  BUCKET_ID_SEQUENCE  MINVALUE 5600  INCREMENT BY 1 START WITH 5600;

DROP TABLE IF EXISTS BUCKET;
CREATE TABLE BUCKET(
	BUCKET_ID NUMBER(10) PRIMARY KEY,
	BUCKET_CATEGORY VARCHAR(30),
	BUCKET_DESCRIPTION VARCHAR(140),
	IS_ACTIVE NUMBER(1)
);

Insert into BUCKET (BUCKET_ID, BUCKET_CATEGORY, BUCKET_DESCRIPTION, IS_ACTIVE ) values (1,'CORE JAVA1','PRIORITY 1 ', true);
Insert into BUCKET (BUCKET_ID, BUCKET_CATEGORY, BUCKET_DESCRIPTION, IS_ACTIVE ) values (2,'CORE JAVA2','PRIORITY 2 ', false);
Insert into BUCKET (BUCKET_ID, BUCKET_CATEGORY, BUCKET_DESCRIPTION, IS_ACTIVE ) values (3,'CORE JAVA3','PRIORITY 3 ', true);
Insert into BUCKET (BUCKET_ID, BUCKET_CATEGORY, BUCKET_DESCRIPTION, IS_ACTIVE ) values (4,'CORE JAVA4','PRIORITY 4 ', false);
Insert into BUCKET (BUCKET_ID, BUCKET_CATEGORY, BUCKET_DESCRIPTION, IS_ACTIVE ) values (5,'CORE JAVA5','PRIORITY 5 ', true);
Insert into BUCKET (BUCKET_ID, BUCKET_CATEGORY, BUCKET_DESCRIPTION, IS_ACTIVE ) values (6,'CORE JAVA6','PRIORITY 6 ', false);
Insert into BUCKET (BUCKET_ID, BUCKET_CATEGORY, BUCKET_DESCRIPTION, IS_ACTIVE ) values (7,'CORE JAVA7','PRIORITY 7 ', true);
Insert into BUCKET (BUCKET_ID, BUCKET_CATEGORY, BUCKET_DESCRIPTION, IS_ACTIVE ) values (8,'CORE JAVA8','PRIORITY 8 ', false);


COMMIT;
