CREATE DATABASE LISTA15;

USE LISTA15;

CREATE TABLE PRODUCTS(
	ID_PRODUCTS 				INTEGER(10) 						NOT NULL,
    NAME_PRODUCTS				VARCHAR(100)						NOT NULL,
    AMOUNT_PRODUCTS				INT(10)								NOT NULL,
    PRICE_PRODUCTS				FLOAT								NOT NULL,
	PRIMARY KEY(ID_PRODUCTS),
    PROVIDERS_ID 				INT(10)								NOT NULL,
    CONSTRAINT					FK_PROVIDERS_PRODUCTS     			FOREIGN KEY(PROVIDERS_ID)			REFERENCES PROVIDERS(ID_PROVIDERS)
);



CREATE TABLE PROVIDERS(
	ID_PROVIDERS				INTEGER(10)								NOT NULL,
	NAME_PROVIDERS	    		VARCHAR(100)							NOT NULL,
    STREET_PROVIDERS			VARCHAR(100) 							NOT NULL,
    CITY_PROVIDERS				VARCHAR(100)							NOT NULL,
    STATE_PROVIDERS				CHAR(10)								NOT NULL,
	PRIMARY KEY(ID_PROVIDERS)
);


INSERT INTO PRODUCTS (ID_PRODUCTS, NAME_PRODUCTS, AMOUNT_PRODUCTS, PRICE_PRODUCTS, PROVIDERS_ID)
VALUES 	(1,'Blue Chair',30,300.00,5),
		(2,'Red Chair',50,2150.00,1),
		(3,'Disney Wardrobe',400,829.50,4),
        (4,'Blue Toaster',20,9.90,3),
		(5,'Solar Panel',30,3000.25,4);
        
        
INSERT INTO PROVIDERS (ID_PROVIDERS, NAME_PROVIDERS, STREET_PROVIDERS, CITY_PROVIDERS, STATE_PROVIDERS)
VALUES 	(1,'Ajax SA','Presidente Castelo Branco','Porto Alegre','RS'),
		(2,'Sansul SA','Av Brasil','Rio de Janeiro','RJ'),
		(3,'South Chairs','Av Moinho','Santa Maria','RS'),
		(4,'Elon Electro','Apolo','São Paulo','SP'),
		(5,'Mike Electro','Pedro da Cunha','Curitiba','PR');
        
        
CREATE VIEW VIEW_PRODUCTS_PROVIDERS AS
SELECT PR.NAME_PROVIDERS, P.NAME_PRODUCTS
FROM PROVIDERS PR
JOIN PRODUCTS P ON PR.ID_PROVIDERS = P.PROVIDERS_ID
WHERE(PR.ID_PROVIDERS = 1);   

SELECT * FROM VIEW_PRODUCTS_PROVIDERS;   
        


        
        
