CREATE TABLE  Person
(
    id   INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Adresse
(
    id      INT PRIMARY KEY,
    wohnort VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES Person (id)
);


INSERT INTO Person (name) VALUES ('Lukas Kristmann');
INSERT INTO Adresse (id, wohnort) VALUES (1, '4614 Marchtrenk, Dr. Renner Str. 22');