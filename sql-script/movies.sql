CREATE DATABASE  IF NOT EXISTS `movies_directory`;
USE `movies_directory`;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(45) NOT NULL,
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
    This path brings him face-to-face with his alter-ego: "The Joker".'),
    (2, 'The Godfather', 1972, 9.2, 'Crime', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'),
    (3, 'The Godfather: Part II', 1974, 9, 'Crime', 'The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.'),
    (4, 'The Dark Knight', 2008, 9, 'Action', 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.'),
    (5, '12 Angry Men', 1957, 8.9, 'Drama', 'A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.');
