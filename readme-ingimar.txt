http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/RESTfulWebServices/RESTfulWebservices.htm
http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/RESTfulWebServices_Part2/RESTfulWebservicesPart2.htm

maven is used.
ejb is used.

(0) Conerning database; Mysql or Derby.
- both of them have a setting in the persistence.xml.
- use the playerDB.sql for creating databases.
- see the tutorial for creating a Derby ( Here it is db=john with psw=john )
- - or you could create a mysql-database, remember to create a jdbc-jndi within glassfish ( or any other as ).

check
(1) Architectural - thing
- now there are 2 projects ( project-A and project-B )
- - each of the projects contains a domain-model ( Player & Team )
- - - I am struggling to break out that domain-model and put in a project of its own that
- - - That domain-project could be project-C ( that project-A and project-B depends on , using archiva
as a maven-repository )




not-working
(2) The Client : OBS - får inte auto_increment att fungera ...
Lösning : Generera ett GUID såsom PK ? ( Samma namna på image-filen ? )

Setting the ID manually for the Player, though that PLAYER-tbl is updated with incremental .... ?
CREATE TABLE `PLAYER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LASTNAME` varchar(15) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `JERSEYNUMBER` int(11) DEFAULT NULL,
  `LASTSPOKENWORDS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

But i Cannot remove the  player.setId(36); - which should be able if the db autoincrements ...
        Player player = new Player();
        player.setId(36); // 
        player.setFirstname("Sugar Cane");
        player.setLastname("Erlingsson");
        player.setJerseynumber(66);
        player.setLastspokenwords("Thanks to my fans");
        client1.create_XML(player);


Step-by-step:
0) Works with a J2SE-Client
1) Testing with WEB-Client.


