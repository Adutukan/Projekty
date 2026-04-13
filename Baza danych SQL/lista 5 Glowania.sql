-- zad.1
WITH ILE_DZIAL AS
(SELECT d.DEPARTMENT, d.DEPT_NO,COUNT(e.EMP_NO) AS LICZBA 
FROM employee e RIGHT JOIN department d ON (e.DEPT_NO=d.DEPT_NO)
GROUP BY d.DEPARTMENT,d.DEPT_NO)

SELECT *
FROM ILE_DZIAL
WHERE (SELECT MAX(LICZBA) FROM ILE_DZIAL) = LICZBA;

-- zad.2

WITH AVG_SAL AS 
(SELECT d.DEPARTMENT, d.DEPT_NO,AVG(SALARY) AS LICZBA 
FROM employee e RIGHT JOIN department d ON (e.DEPT_NO=d.DEPT_NO)
GROUP BY d.DEPARTMENT,d.DEPT_NO )

SELECT *
FROM AVG_SAL
WHERE (SELECT MAX(LICZBA) FROM AVG_SAL) = LICZBA;

-- ZAD.3

CREATE or REPLACE VIEW Osoby
AS 
SELECT d.DEPARTMENT, d.DEPT_NO,COUNT(e.EMP_NO) AS LICZBA 
FROM employee e RIGHT JOIN department d ON (e.DEPT_NO=d.DEPT_NO)
GROUP BY d.DEPARTMENT,d.DEPT_NO;

SELECT *
FROM Osoby
WHERE(SELECT MAX(LICZBA) FROM Osoby) = LICZBA;

-- zad.4 

CREATE or REPLACE VIEW Wynagrodzenie
AS 
SELECT d.DEPARTMENT, d.DEPT_NO,AVG(e.SALARY) AS LICZBA 
FROM employee e RIGHT JOIN department d ON (e.DEPT_NO=d.DEPT_NO)
GROUP BY d.DEPARTMENT,d.DEPT_NO;

SELECT *
FROM Wynagrodzenie
WHERE(SELECT MAX(LICZBA) FROM Wynagrodzenie) = LICZBA;

-- ZAD.5

SELECT *
FROM SZEF
WHERE (SELECT MAX(PENSJA) FROM SZEF) = PENSJA; 


-- ZAD.6

CREATE OR REPLACE VIEW STOSUNEK
AS
SELECT SUM(SALARY) AS SUMA
FROM employee
WHERE JOB_COUNTRY = 'USA';


CREATE OR REPLACE VIEW STOSUNEK1
AS
SELECT SUM(SALARY) AS SUMA
FROM employee
WHERE JOB_COUNTRY != 'USA';

SELECT s2.suma/s1.suma AS Porownanie
FROM STOSUNEK1 s1,STOSUNEK s2; 


SELECT s2.suma/s1.suma AS Porownanie
FROM (SELECT SUM(SALARY) AS SUMA
FROM employee
WHERE JOB_COUNTRY = 'USA') s2,(SELECT SUM(SALARY) AS SUMA
FROM employee
WHERE JOB_COUNTRY != 'USA')s1; 

-- zad.7
CREATE OR REPLACE VIEW NAJWIECEJ
AS 
SELECT COUNT(*), e.JOB_COUNTRY
FROM employee e 
GROUP BY e.JOB_COUNTRY
HAVING COUNT(*) >= ALL(SELECT COUNT(*) FROM employee e GROUP BY e.JOB_COUNTRY );


SELECT e.DEPT_NO,e.SALARY,e.FIRST_NAME,e.LAST_NAME
FROM employee e JOIN NAJWIECEJ n ON (e.JOB_COUNTRY =n.JOB_COUNTRY)
WHERE e.SALARY = (SELECT MAX(h.SALARY) FROM employee h WHERE h.DEPT_NO = e.DEPT_NO);

-- zad.8 

CREATE OR REPLACE VIEW SUMA1
AS 
SELECT SUM(e.SALARY) AS suma , d.DEPT_NO
FROM employee e right JOIN department d ON (d.DEPT_NO=e.DEPT_NO) 
GROUP BY d.DEPT_NO;

SELECT *
FROM SUMA1;

SELECT d.DEPT_NO,d.department, d.BUDGET - s.suma , s.suma   
FROM suma1 s join department d ON (s.DEPT_NO = d.DEPT_NO)
WHERE d.BUDGET - s.suma >= 0;

-- ZAD.9

SELECT d.DEPT_NO,d.department, d.BUDGET - s.suma , s.suma   
FROM suma1 s join department d ON (s.DEPT_NO = d.DEPT_NO)
WHERE d.BUDGET - s.suma < 0 OR s.suma IS NULL;

-- zad.10

SELECT d.DEPT_NO,d.department, d.BUDGET - s.suma , s.suma   
FROM suma1 s join department d ON (s.DEPT_NO = d.DEPT_NO)
WHERE d.BUDGET - s.suma >= 0 AND d.BUDGET - s.suma = (SELECT  MIN(d.BUDGET - s.suma)   
																		FROM suma1 s join department d ON (s.DEPT_NO = d.DEPT_NO)
																		WHERE d.BUDGET - s.suma >= 0);







