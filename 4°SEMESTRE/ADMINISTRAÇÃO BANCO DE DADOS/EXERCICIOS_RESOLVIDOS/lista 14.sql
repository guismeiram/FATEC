CREATE DATABASE LISTA14;

USE LISTA14;

CREATE TABLE CUSTOMERS(
	ID_CUSTOMERS						INTEGER					NOT NULL,
    NAME_CUSTOMERS						VARCHAR(100)			NOT NULL,
    STREET_CUSTOMERS					VARCHAR(100)			NOT NULL,
	CITY_CUSTOMERS						VARCHAR(100)			NOT NULL,
    PRIMARY KEY(ID_CUSTOMERS)
);


CREATE TABLE LOCATIONS(
	ID_LOCATIONS						INTEGER					NOT NULL,
    DATE_LOCATIONS						DATE                    NOT NULL,
    PRIMARY KEY(ID_LOCATIONS)												,
	CUSTOMERS_ID						INTEGER					NOT NULL,
    CONSTRAINT 							FK_CUSTOMERS_RENTALS	FOREIGN KEY(CUSTOMERS_ID)		REFERENCES CUSTOMERS(ID_CUSTOMERS)
);

#INSERT
INSERT INTO CUSTOMERS (ID_CUSTOMERS, NAME_CUSTOMERS, STREET_CUSTOMERS, CITY_CUSTOMERS)
VALUES (1, 'GIOVANNA G. OLIVEIRA', 'RUA MATO GROSSO','CANOAS'),
	   (2, 'KAUÃ AZEVEDO RIBEIRO', 'TRAVESSA IBIÁ', 'UBERLÂNDIA'),
	   (3, 'REBECA BARBOSA SANTOS','RUA OBSERVATÓRIO METEOROLÓGICO','SALVADOR'),
	   (4, 'SARAH CARVALHO CORREIA','RUA ANTÔNIO CARLOS DA SILVA','APUCARANA'),
       (5, 'JOÃO ALMEIDA LIMA','RUA RIO TAIUVA','PONTA GROSSA'),
       (6, 'DIOGO MELO DIAS','RUA DUZENTOS E CINQÜENTA','VÁRZEA GRANDE');
       
INSERT INTO LOCATIONS (ID_LOCATIONS,   DATE_LOCATIONS , CUSTOMERS_ID)
VALUES 	(1,'2016-10-09',3),
		(2,'2016-09-02',1),
		(3,'2016-08-02',4),
		(4,'2016-09-02',2),
		(5,'2016-03-02',6),
        (6,'2016-04-04',4);
        
 SELECT * FROM CUSTOMERS WHERE( NAME_CUSTOMERS = 'JOÃO ALMEIDA LIMA');
 
 CREATE VIEW VIEW_CUSTOMERS_LOCATION AS       
SELECT ID_CUSTOMERS, NAME_CUSTOMERS FROM CUSTOMERS WHERE( ID_CUSTOMERS = 5 AND NAME_CUSTOMERS = 'JOÃO ALMEIDA LIMA');

SELECT * FROM VIEW_CUSTOMERS_LOCATION; 
 