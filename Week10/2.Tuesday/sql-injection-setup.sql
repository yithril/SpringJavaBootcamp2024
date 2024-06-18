ALTER TABLE Employees
ADD SSN VARCHAR(11);

SET SQL_SAFE_UPDATES = 0;

UPDATE Employees
SET SSN = CONCAT(
    LPAD(FLOOR(RAND() * 900) + 100, 3, '0'), '-', 
    LPAD(FLOOR(RAND() * 90) + 10, 2, '0'), '-', 
    LPAD(FLOOR(RAND() * 9000) + 1000, 4, '0')
);

SET SQL_SAFE_UPDATES = 1;