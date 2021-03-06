use Service;
INSERT Auto(StateNumber,Model) 
VALUES (1111, 'Audi 80');
insert Clients(idClients,Name,FirstName,TelefonNumber,Auto_StateNumber) 
values (1,'Masha','Khalezova','+375293435382',1111);
insert Masters(idMasters,Name,FirstName,TelefonNumber,Employeers_idEmployeers) 
values (1,'Egor','Kisel','+34532647576',1);
insert Diagnosts(idDiagnosts,Name,FirstName,TelefonNumber,Employeers_idEmployeers) values (1,'German','Groza','+3456575765',2);
insert Garages (idGarage,Adress,MaxWorkers) values (1,'Lenina 20', 5);
insert Admins(idAdmins, Name,FirstName,TelefonNumber,Employeers_idEmployeers) values (1,'Natasha','Svar','+345678987',1);
insert Services(idServices, Service,TimeToWork) values (1,'tire change', 20);
insert TimeToWork(idTime,TimeToWork, Services_idServices ) values (1,20, 1);
insert Materials(idMaterials,Materials,Supplier) values (1,'tire', 'Audi');
insert Suppliers(idSuppliers,Supplier,Country)values (1,'Audi','Germany');


UPDATE Auto SET Model = 'Audi 80c' WHERE StateNumber = 1111;
UPDATE Garages SET MaxWorkers = 10 where Adress='Lenina 20';
UPDATE Clients SET Name='Marianna'WHERE TelefonNumber = '+375293435382';
UPDATE Admins SET FirstName = 'Scvarc' WHERE idAdmins = 1;
UPDATE Suppliers SET Country='USA' WHERE Supplier = 'Audi';
UPDATE Materials Set Materials='Tires' Where Supplier='Audi';
UPDATE TimeToWork SET TimeToWork = 30 WHERE Services_idServices=1;
UPDATE Diagnosts SET Name = 'Nikita' WHERE idDiagnosts = 1;
UPDATE Services Set Service='Tires change' Where idServices =1;
UPDATE Masters Set Name='Egore' Where TelefonNumber='+34532647576';


DELETE FROM Diagnosts WHERE TelefonNumber=null;
DELETE FROM Auto WHERE Model='Renaut';
DELETE FROM Masters WHERE Name=null;
DELETE FROM Garages WHERE Adress=null;
DELETE FROM Costs WHERE Costs=null AND Costs > 60000;
DELETE FROM Suppliers WHERE Country = null and Supplier= null;
DELETE FROM Services WHERE Service=null;
DELETE FROM TimeToWork WHERE TimeToWork=null or TimeToWork>10000;
DELETE FROM Admins WHERE TelefonNumber='+36524564632';
DELETE FROM Employeers WHERE Employeer != 'Masters' or Employeer!='Diagnosts' or Employeer != 'Admins';

ALTER TABLE Garages ADD MinWorkers int;
ALTER TABLE Garages ALTER COLUMN MaxWorkers SET DEFAULT 22;
ALTER TABLE Garages DROP COLUMN MinWorkers;
ALTER TABLE Admins MODIFY COLUMN FirstName CHAR(100) NULL;
ALTER TABLE Employeers ADD MinAge int;
ALTER TABLE Employeers ALTER COLUMN MinAge SET DEFAULT 17;


SELECT Garages.Adress FROM Garages JOIN Masters ON Masters.idMasters = Garages.idGarage;
SELECT  idClients FROM Diagnosts LEFT  JOIN Clients ON Clients.TelefonNumber = Diagnosts.TelefonNumber;
SELECT idMasters FROM Masters right JOIN Clients ON Clients.idClients = Masters.idMasters;
select * from Costs inner join TimeToWork on  Costs.TimeToWork_idTime=TimeToWork.idTime;
select * from Auto left outer join Clients on  Auto.StateNumber=Clients.Auto_StateNumber;


select Name, max(FirstName) from Clients group by Name ;
select Name, min(FirstName) from Masters group by Name;
select count(*) from ActiveTasks group by Clients_idClients ;
SELECT AVG(TimeToWork) FROM TimeToWork group by TimeToWork;
SELECT SUM(MaxWorkers) FROM Garages group by Adress;
select max(Salary) from Salaries group by Employeer;
select min(distinct Name) from Admins group by TelefonNumber;

SELECT Services, COUNT(*) AS Costs FROM Costs GROUP BY Services HAVING COUNT(*) > 1;
select Adress, max(MaxWorkers) from Garages group by Adress having max(MaxWorkers)!=null;
select Name, min(FirstName) from Masters group by idMasters having min(FirstName)!=null;
select TelefonNumber, Name, max(Name) from Admins group by idAdmins having Max(Name)<2;
select Model, StateNumber, count(*) from Auto group by StateNumber having Max(StateNumber)!=null;
select Services_idServices, AVG(TimeToWork) FROM TimeToWork group by idTime having max(TimeToWork)>0;
select * , max(MaxWorkers) from Garages group by idGarage having max(MaxWorkers)>0;



