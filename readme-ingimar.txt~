http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/RESTfulWebServices/RESTfulWebservices.htm
http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/RESTfulWebServices_Part2/RESTfulWebservicesPart2.htm

maven is used.
ejb is used.

(0) Conerning database; Mysql or Derby.
- both of them have a setting in the persistence.xml.
- use the playerDB.sql for creating databases.
- see the tutorial for creating a Derby ( Here it is db=john with psw=john )
- - or you could create a mysql-database, remember to create a jdbc-jndi within glassfish ( or any other as ).


(1) Architectural - thing
- now there are 2 projects ( project-A and project-B )
- - each of the projects contains a domain-model ( Player & Team )
- - - I am struggling to break out that domain-model and put in a project of its own that
- - - That domain-project could be project-C ( that project-A and project-B depends on , using archiva
as a maven-repository )
