-- Create database
DROP DATABASE  IF EXISTS `exam_booster_database`;

CREATE DATABASE  IF NOT EXISTS `exam_booster_database`;
USE `exam_booster_database`;

-- Table structure for table `user`
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `username` varchar(50) NOT NULL,
 `password` char(80) NOT NULL,
 `first_name` varchar(50) NOT NULL,
 `last_name` varchar(50) NOT NULL,
 `email` varchar(50) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Dumping data for table `user`
-- NOTE: The passwords are encrypted using BCrypt
-- Default passwords here are: fun123
INSERT INTO `user` (username,password,first_name,last_name,email)
VALUES
('regular','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Regular','User','regular@mail.com'),
('power','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Power','User','power@mail.com'),
('admin','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Admin','User','admin@mail.com');

-- Table structure for table `role`
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(50) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Dumping data for table `roles`
INSERT INTO `role` (name)
VALUES
('ROLE_REGULAR_USER'),('ROLE_POWER_USER'),('ROLE_ADMIN_USER');

-- Table structure for table `users_roles`
DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
 `user_id` int(11) NOT NULL,
 `role_id` int(11) NOT NULL,
 PRIMARY KEY (`user_id`,`role_id`),
 KEY `FK_ROLE_idx` (`role_id`),
 CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`)
 REFERENCES `user` (`id`)
 ON DELETE NO ACTION ON UPDATE NO ACTION,
 CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`)
 REFERENCES `role` (`id`)
 ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

-- Dumping data for table `users_roles`
INSERT INTO `users_roles` (user_id,role_id)
VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(3, 3);

-- Table structure for table `category`
DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(150) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `category` (name)
VALUES
('Calculus'),
('Physics'),
('Computer Science'),
('Biology'),
('Number Theory'),
('Geography');

-- Table structure for table `question`
DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `creator` varchar(90) NOT NULL DEFAULT 'developer',
 `category` varchar(90) NOT NULL,
 `answer` varchar(500) NOT NULL DEFAULT 'NO ANSWER',
 `sentence` varchar(500) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `question` (category, sentence)
VALUES
('Calculus', 'Integrate x^2 over interval [0,3]'),
('Calculus', 'Integrate x^3 over interval [-INF,+INF]'),
('Calculus', 'What is the derivative of sin(x)?'),
('Calculus', 'What is the derivative of cos(x) - sin(x)?'),
('Calculus', 'What are the Taylor Series?'),
('Physics', 'What is latent heat?'),
('Physics', 'Can a fire have a shadow?'),
('Physics', 'Can momentum be hidden to human eyes like kinetic energy can be hidden as heat?'),
('Physics', 'Can light bend around corners?'),
('Physics', 'Can sound waves generate heat?'),
('Biology', 'Are there any parts of the human body that get oxygen directly from the air and not from the blood?'),
('Biology', 'Are there nuclear reactions going on in our bodies?'),
('Biology', 'Can humans ever directly see a photon?'),
('Biology', 'Do blind people dream in visual images?'),
('Biology', 'Do koalas eat honey like other bears?'),
('Computer Science', 'Can you remove duplicates directly using a Spring built-in class?'),
('Computer Science', 'Is it possible to use a Controller class without declare them in web application context file?'),
('Computer Science', 'How many modules does Spring have?'),
('Computer Science', 'Does Google use Spring Framework?'),
('Computer Science', 'When should you use Spring Framework?'),
('Number Theory', 'Show that 2 is a primitive root mod 3^k for all positive k.'),
('Number Theory', 'Are 39 and 76 coprime?'),
('Number Theory', 'Find the lcm between 30 and 36'),
('Number Theory', 'Solve x^2 + y^2 = z^2'),
('Number Theory', 'Solve x^n + y^n = z^n'),
('Physics', 'Is electromagnetism a part of physics?'),
('Physics', 'Who was Dr. Shirley Jackson?'),
('Physics', 'What is solar physics?'),
('Physics', 'Why is the speed of light so important for astrophysics?'),
('Physics', 'What is the densest substance in the universe?'),
('Physics', 'Compare the Hawthorne Effect with the modern-day practice of Micromanagement.'),
('Physics', 'What is the difference between Bernoulli''s equation and the energy equation?'),
('Physics', 'Why is velocity in veins higher than capillaries?'),
('Physics', 'Why does blood''s velocity decrease in capillaries?'),
('Physics', 'What is stated in Bernoulli''s Theorem? What is the use of Bernoulli''s Theorem?'),
('Physics', 'Is it possible in theory to cut an object in half until it ceases to exist?'),
('Physics', 'What do you mean by stereoscope?'),
('Physics', 'Has string theory ever been proven?'),
('Physics', 'What is crystalline structure?'),
('Physics', 'What is the theory of determinism?'),
('Physics', 'What did Stephen Hawking study?'),
('Physics', 'What is fluid mechanics?'),
('Physics', 'What is the difference between resultant and equilibrium?'),
('Physics', 'What fraction of the volume of ice will be above the water when the ice is floating in water?'),
('Physics', 'Does gravity affect the speed of light?'),
('Physics', 'How do you make an Arrhenius plot?'),
('Physics', 'What is the weather temperature?'),
('Physics', 'What is electronic conduction?'),
('Physics', 'What is evaporation temperature?'),
('Physics', 'What is motion according to Galileo?');

INSERT INTO `question` (category, sentence, answer)
VALUES
('Physics', 'What is motion according to Galileo?', 'Motion is something.');

INSERT INTO `question` (category, sentence, answer)
VALUES
('Geography', 'What is an earthquake?', 'An earthquake is the shaking of the surface of the Earth resulting from a sudden release of energy in the Earth''s lithosphere that creates seismic waves.'),
('Geography', 'What are the planets of solar system?', 'The order of the planets in the solar system, starting nearest the sun and working outward is the following: Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune and then the possible Planet Nine.'),
('Geography', 'What is political geography?', 'Political geography is concerned with the study of both the spatially uneven outcomes of political processes and the ways in which political processes are themselves affected by spatial structures.'),
('Geography', 'What country has the longest coastline in the world?', 'Canada'),
('Geography', 'How many states are there in Australia?', 'Six – New South Wales, Victoria, Queensland, Western Australia, Tasmania, South Australia'),
('Geography', 'What African country has the largest population?', 'Nigeria (190 million)'),
('Geography', 'Chittagong, which is also known as Chattogram, is a city in which Asian country?', 'Bangladesh'),
('Geography', 'How many countries does the Equator pass through?', '13. Ecuador, Colombia, Brazil, Sao Tome & Principe, Gabon, Republic of the Congo, Democratic Republic of the Congo, Uganda, Kenya, Somalia, Maldives, Indonesia and Kiribati'),
('Geography', 'Describe the water cycle', 'The water cycle is a process that re-circulates Earth''s water through the stages of evaporation, condensation and collection. The water from lakes, oceans, rivers and other water bodies begins to evaporate; vapor from the water bodies condenses into clouds, later causing precipitation.'),
('Geography', 'Which European capital city is divided by canals into about 90 islands joined by about 400 bridges?', 'Amsterdam'),
('Geography', 'Which river rises in the Himalayas in India and drains into the Bay of Bengal?', 'Ganges');
