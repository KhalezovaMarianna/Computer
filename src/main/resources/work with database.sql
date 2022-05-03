use Service_station;
insert TimeToWork(TimeToWork) values (1.5);
insert Clients(Name, FirstName, TelefonNumber) values ('Masha','Khalezova', '+375293435382');
insert Masters(Name , FirstName , TelefonNumber) values ('German','Grozny','+375293423223');
insert Auto(StateNumber, Model) values (1234, 'audi 80');
insert Employeers(Employeer) values ('master');
insert Diagnosts(Name , FirstName , TelefonNumber) values ('Egor','Kiseleu','+3753333332');
insert Admins(Name , FirstName , TelefonNumber) values ('Natalia','Shevc','+375293838492');
insert Costs(Services, Cost) values ('Tire change',20);
insert Sales(Service, Conditions, Sale) values ('Tire change','4 tires at the moment',12);
insert Garage(Adress) values ('Lenina 20');
insert Salaries(Employeer , Salary) values ('Master', 450.50);
insert Suppliers(Supplier,Country) values ('Audi','USA');
insert Materials(Materials , Supplier) values ('Tire','Audi');
insert Services(Services) values ('Tire change');
UPDATE Autos SET Model='audi 80' WHERE Model='Audi';
UPDATE Clients SET Name='Masha' WHERE Name = 'Marianna';
UPDATE Masters SET Name='German' WHERE TelefonNumber='+375293423223' ;
UPDATE Garage SET Adress='Lenina 20' WHERE Adress='Lenina 22' ;
UPDATE Salaries SET Salary='450.50' WHERE '451';
UPDATE Diagnosts SET Name='Egor' WHERE Name='Egore' ;
UPDATE Costs SET Cost= 20 WHERE Cost= 25 ;
UPDATE Materials SET Supplier='Audi' WHERE Supplier = 'BMW' ;
UPDATE Suppliers SET Country='USA' WHERE Country='Germany';
UPDATE Admins SET FirstName='Shevc' WHERE FirstName='Shevcova';
DELETE FROM Autos WHERE Model='Renaut';
DELETE FROM Masters WHERE Name=null;
DELETE FROM Diagnosts WHERE TelefonNumber=null;
DELETE FROM Garage WHERE Adress=null;
DELETE FROM Costs WHERE Cost=null AND Price > 60000;
DELETE FROM Suppliers WHERE Country = null and Supplier= null;
DELETE FROM Services WHERE Services=null;
DELETE FROM TimeToWork WHERE TimeToWork=null or TimeToWork>10000;
DELETE FROM Admins WHERE TelefonNumber='+36524564632';
DELETE FROM Employeers WHERE Employeers != 'Masters' or Employeers!='Diagnosts' or Employeers != 'Admins';
ALTER TABLE Garage ADD MaxWorkers int;
ALTER TABLE Garage ALTER COLUMN MaxWorkers SET DEFAULT 22;
ALTER TABLE Garage DROP COLUMN MaxWorkers;
ALTER TABLE Admins MODIFY COLUMN FirstName CHAR(100) NULL;
ALTER TABLE Employeers ADD MinAge int;
SELECT Garage.Adress FROM Garage JOIN Masters ON Masters.idMasters = Garage.idGarage;
SELECT FirstName, Name, TelefonNumber FROM Diagnosts LEFT outer JOIN Clients ON Clients.TelefonNumber = Diagnosts.TelefonNumber;
SELECT FirstName, Name, TelefonNumber FROM Masters right outer JOIN Clients ON Clients.TelefonNumber = Masters.TelefonNumber and Clients.FirstName=Masters.FirstName;
SELECT Admins.FirstName, Clients.Name
FROM Admins, Clients
WHERE Admins.TelefonNumber = Clients.TelefonNumber;
SELECT Masters.FirstName, Admins.FirstName 
FROM Masters, Admins
WHERE Masters.TelefonNumber=Admins.TelefonNumber;
SELECT Name,FirstName
FROM Clients
GROUP BY Name
HAVING TelefonNumber ='+375293435382';
SELECT Name, FirstName
FROM Deagnosts
GROUP BY FirstName
HAVING TelefonNumber = null;
SELECT Model
FROM Auto
GROUP BY Model
HAVING StateNumber='1234';
SELECT Name,FirstName
FROM Masters
GROUP BY FirstName
HAVING idMasters > 2 ;
SELECT Adress, idGarage
FROM Garage
GROUP BY Adress
HAVING Adress != null;
SELECT Salary
FROM Salaries
GROUP BY Salary
HAVING Salary>200;
SELECT Cost
FROM Costs
GROUP BY Cost
HAVING Cost < 1995;

   