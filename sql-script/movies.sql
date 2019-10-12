CREATE DATABASE  IF NOT EXISTS `movies_directory`;
USE `movies_directory`;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(45) DEFAULT NULL,
  `release_year` int(4) NOT NULL,
  `rating` double default 0,
  `genre` varchar(45) DEFAULT NULL,
  `plot`varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `movie`
--

INSERT INTO `movie` VALUES 
	(1, 'Joker', 2019, 9.0, 'Crime', 'In Gotham City, mentally-troubled comedian Arthur Fleck is disregarded and mistreated by society. 
    He then embarks on a downward spiral of revolution and bloody crime.
    This path brings him face-to-face with his alter-ego: "The Joker".');

