-- zad.1

CREATE TABLE  wydzialGG
(wydzial_nr char(3) PRIMARY key, 
nazwa varchar(25) NOT NULL,
budzet numeric(15,2) NOT NULL DEFAULT 50000,
lokalizacja varchar(15));

-- zad.2

CREATE TABLE PracownikGG

(pracownik_nr SMALLINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
imie varchar(15) NOT NULL, 
nazwisko varchar(20) NOT NULL, 
wydzial_nr char(3), 
data_zatrudnienia DATE NOT NULL DEFAULT CURRENT_DATE , 
zarobki numeric(15,2) NOT NULL DEFAULT 80000 CHECK (zarobki >= 0), 
kraj varchar(15) NOT NULL);

ALTER TABLE PracownikGG
ADD FOREIGN KEY (wydzial_nr) REFERENCES wydzialGG (wydzial_nr);

-- zad.3

INSERT INTO wydzialGG
SELECT DEPT_NO, DEPARTMENT, BUDGET,LOCATION
FROM DEPARTMENT;

-- ZAD.4

INSERT INTO wydzialGG(wydzial_nr, nazwa, budzet, lokalizacja)
VALUES(999,'Tukan',777777,'ZIELOILERN GORLILEN');

-- ZAD.5

INSERT INTO PracownikGG
SELECT EMP_NO, FIRST_NAME,LAST_NAME, DEPT_NO, HIRE_DATE,SALARY,JOB_COUNTRY
FROM employee;

-- zad.6

INSERT INTO PracownikGG(imie,nazwisko,wydzial_nr,kraj)
VALUES('Gracjan','Glowania',999,'Poland');

INSERT INTO PracownikGG(imie,nazwisko,wydzial_nr,kraj)
VALUES('Gracjan','Glowania1',999,'Poland');

-- zad.7

INSERT INTO PracownikGG(pracownik_nr,imie,nazwisko,wydzial_nr,kraj)
VALUES(149,'Gracjan','Glowania',999,'Poland'); 

INSERT INTO PracownikGG(imie,nazwisko,wydzial_nr,kraj)
VALUES('Gracjan','Glowania1',999,'Poland');

-- zad.8

DELETE FROM PracownikGG
WHERE nazwisko LIKE 'B%';

-- zad.9
SELECT * FROM PracownikGG WHERE wydzial_nr = (SELECT wydzial_nr FROM wydzialGG WHERE nazwa = 'Research and Development');

UPDATE PracownikGG 
SET  zarobki = ROUND (zarobki * 0.9,2) 
WHERE wydzial_nr = (SELECT wydzial_nr FROM wydzialGG WHERE nazwa = 'Research and Development');

ROLLBACK;

-- zad.10

DELETE FROM PracownikGG
WHERE wydzial_nr = (SELECT wydzial_nr FROM wydzialGG WHERE nazwa = 'Marketing'); 

DELETE FROM wydzialGG
WHERE nazwa = 'Marketing';

COMMIT;

-- zad.11

ALTER TABLE PracownikGG
ADD COLUMN potracenia NUMERIC(15,2)DEFAULT 0;

UPDATE PracownikGG
SET potracenia = 1000
WHERE kraj = 'USA';

UPDATE PracownikGG
SET potracenia = 5000
WHERE kraj != 'USA';

COMMIT;

-- zad.12

ALTER TABLE PracownikGG
ADD COLUMN zarobki_netto NUMERIC(15,2) GENERATED ALWAYS AS (zarobki - potracenia);

-- zad.13

ALTER TABLE PracownikGG
DROP zarobki_netto,
DROP potracenia;

-- zad.14
CREATE USER if NOT EXISTS 'gracjang@localhost';

-- zad.15
GRANT SELECT ON pracownikgg TO 'gracjang@localhost'; 
GRANT SELECT ON wydzialgg TO 'gracjang@localhost'; 

-- zad.16
 ZROBIŁEM;
 
 -- ZAD.17
 
CREATE role KADROWY; 


-- zad.18


GRANT SELECT, UPDATE ON pracownikgg TO KADROWY;

GRANT SELECT, UPDATE , INSERT ON wydzialgg TO KADROWY;

GRANT KADROWY TO 'gracjang@localhost';

-- ZAD.19

--SET ROLE KADROWY;

-- ZAD.20

-- SHOW GRANTS;
-- SET ROLE NONE;
-- SHOW GRANTS;
-- SELECT CURRENT_ROLE;

-- ZAD.21


-- ZAD.22
CREATE USER if NOT EXISTS 'gracjang1@localhost';

-- ZAD.23

GRANT KADROWY TO 'gracjang1@localhost';
SET DEFAULT ROLE KADROWY FOR 'gracjang1@localhost';

-- zad.24

DROP USER 'gracjang1@localhost';
DROP USER 'gracjang@localhost';












