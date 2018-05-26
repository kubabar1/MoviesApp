CREATE TABLE Movies(
	ID VARCHAR(50) NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	author NVARCHAR(255) NOT NULL,
	genre NVARCHAR(50) NOT NULL,
	productionYear YEAR(4) NOT NULL,
	filename VARCHAR(50) NOT NULL
);