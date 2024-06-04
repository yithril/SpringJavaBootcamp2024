SELECT COUNT(*) AS num_of_units, SupplierID
FROM Products
GROUP BY SupplierID;

#AVG, GROUP BY CategoryID
SELECT CategoryID, AVG(UnitPrice) AS Avg_Price
FROM Products
GROUP By CategoryID;

SELECT COUNT(*) AS num_of_units, SupplierID
FROM Products
GROUP BY SupplierID
HAVING num_of_units >= 5;

SELECT ProductID, ProductName, UnitPrice * UnitsInStock AS inventory_value
FROM Products
ORDER BY inventory_value DESC, ProductName;