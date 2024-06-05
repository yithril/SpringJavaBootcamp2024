SELECT * 
FROM northwind.products;

UPDATE products
SET UnitsInStock = 75, UnitsOnOrder = 20
WHERE ProductId = 1;

#Example of a hard delete
DELETE 
FROM customers
WHERE CustomerID = 'ZODRA';

#Making Your Own Tables
CREATE TABLE pokemon(
	PokemonID INT auto_increment,
    MoveSet VARCHAR(100) NOT NULL,
    PokemonType VARCHAR(10),
    NAME VARCHAR(50) NOT NULL,
    HP INT,
    IsEvolved bit,
    PRIMARY KEY (PokemonID)
);

#To put data into a table
INSERT INTO pokemon(MoveSet, PokemonType, Name, HP, IsEvolved)
VALUES ('Blasting things with lightning', 'Electric', 'Pikachu', 50, 1),
('Hits things with water', 'Water', 'Squirtle', 65, 0),
('Creeped me outas a kid', 'Psychic', 'MewTwo', 1000, 0);

ALTER TABLE pokemon
DROP column Name;

ALTER TABLE pokemon
ADD PokemonName VARCHAR(50);

ALTER TABLE pokemon
ADD TrainerName VARCHAR(100) NOT NULL;

#Foreign Keys
CREATE Table authors(
AuthorID INT auto_increment,
AuthorName VARCHAR(100),
PRIMARY KEY (AuthorID)
);

CREATE TABLE books(
  BookID INT auto_increment,
  BookTitle VARCHAR(255),
  AuthorID INT,
  PRIMARY KEY (BookID),
  FOREIGN KEY (AuthorID) REFERENCES authors(AuthorID)
);

INSERT INTO authors(AuthorName)
VALUES('Isaac Asimov'), ('Ci LiuXin'), ('Terry Pratchett');

INSERT INTO books(BookTitle, AuthorID)
VALUES('Times End', 2);

DELETE 
FROM authors
WHERE AuthorID = 3;
