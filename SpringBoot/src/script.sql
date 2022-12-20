--create database  oneday;
--drop database oneday;
CREATE TABLE Admin
(
    idAdmin         SERIAL PRIMARY KEY NOT NULL,
    login           VARCHAR(50) NOT NULL,
    pwd        VARCHAR(50) NOT NULL
);
INSERT INTO Admin
VALUES
    (1,'0348289682','0000');



CREATE TABLE Avion
(
    idAvion         SERIAL PRIMARY KEY NOT NULL,
    nom             VARCHAR(50) NOT NULL,
    model           VARCHAR(50) NOT NULL

);
INSERT INTO Avion

VALUES
    (1,'Basy','200'),
    (2,'Bosy','900');

CREATE TABLE Sary
(
    idSary          SERIAL PRIMARY KEY NOT NULL,
    idAvion         int,
    lien            VARCHAR(50) NOT NULL,
    foreign key (idAvion) references Avion(idAvion)
);
INSERT INTO Sary

VALUES
    (1,1,'B.png'),
    (2,2,'C.png');


CREATE TABLE Kilometrage
(

    idKilometrage        SERIAL PRIMARY KEY NOT NULL,
    idAvion              int,
    daty                 Date,
    debut                double precision,
    fin                  double precision,
    foreign key (idAvion) references Avion(idAvion)
);
CREATE TABLE TypeAssurance
(
    idType          SERIAL PRIMARY KEY NOT NULL,
    Type            int
);
CREATE TABLE Assurance
(

    idAssurance     SERIAL PRIMARY KEY NOT NULL,
    idAvion         int,
    daty            Date,
    idType            int,
    foreign key (idAvion) references Avion(idAvion),
    foreign key (idType)  references TypeAssurance(idType)
);



INSERT INTO Sary

VALUES
    (3,1,'Bb.png'),
    (4,2,'Cc.png');

INSERT INTO Kilometrage

VALUES
    (1,1,'12-20-2022',100,200),
    (2,2,'12-20-2022',300,400),
    (3,1,'5-10-2022',200,600),
    (4,2,'4-2-2022',300,700)
;

INSERT INTO TypeAssurance

VALUES
    (1,1),
    (2,3);


INSERT INTO Assurance

VALUES
    (1,1,'2-2-2022',1),
    (2,2,'3-3-2022',2),
    (3,1,'1-6-2022',1),
    (4,2,'5-3-2022',2);
create or replace view v_profil as  Select avion.idAvion,avion.nom,avion.model,sary.lien as path,sary.idSary as idSary from Avion JOIN Sary  on Sary.idAvion= Avion.idAvion where idSary in (select Min(idSary) from sary group by idavion ) GROUP BY  Avion.idAvion,avion.idAvion,avion.nom,avion.model,path,idSary;
create or replace  view v_assurance as select A.idAvion,model,nom,daty,Type, daty+(Type*30) as datefin,  daty+(Type*30)- date (now()) as restant  from assurance join Avion A on Assurance.idAvion = A.idAvion join TypeAssurance TA on TA.idType = Assurance.idType where daty in (select max(daty) from Assurance join Avion A2 on A2.idAvion = Assurance.idAvion group by A2.idAvion);
