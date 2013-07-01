--
-- Table structure for table `SPELARE`
-- using java.util.UUID as a PK
-- UUID = Static factory to retrieve a type 4 (pseudo randomly generated) UUID.  ->
-- -> The UUID is generated using a cryptographically strong pseudo random number generator. 
--

DROP TABLE IF EXISTS `SPELARE`;
CREATE TABLE `SPELARE` (
  `ID` varchar(64) NOT NULL,
  `LASTNAME` varchar(15) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `JERSEYNUMBER` int(11) DEFAULT NULL,
  `LASTSPOKENWORDS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
