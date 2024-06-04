#Aggregate Functions
#SUM, COUNT, AVG, MIN, MAX

#How much inventory do we have on hand?
SELECT SUM(UnitsInStock) AS Inventory_On_Hand
FROM Products;

#What is the average price of our products?
SELECT AVG(UnitPrice) AS Avg_Price
FROM Products;

#What is the price of the most expensive product?
SELECT MAX(UnitPrice) AS Most_Expensive
FROM PRoducts;

#What is the price of the least expensive product?
SELECT MIN(UnitPrice) AS Least_Expensive
FROM PRoducts;

#How many products do we sell that are beverages? CategoryID 1 means its a beverage
SELECT COUNT(*)
FROM Products
WHERE CategoryID = 1;

#A Breakdown of average freight by country
SELECT AVG(Freight) AS Avg_Freight, ShipCountry
FROM Orders
WHERE ShipCountry IN ('UK', 'Germany', 'Belgium', 'Sweden')
GROUP BY ShipCountry
HAVING Avg_Freight > 50
ORDER BY Avg_Freight;

SELECT * 
FROM Orders
ORDER BY ShipCountry;