# INSERT INTO `authors` (`first_name`, `last_name`, `age`) VALUES ('Leiner', 'Laura', 36);
# INSERT INTO `authors` (`first_name`, `last_name`, `age`) VALUES ('Sara', 'Shepard', 44);
# INSERT INTO `authors` (`first_name`, `last_name`, `age`) VALUES ('Cecily von', 'Ziegesar', 51);
# INSERT INTO `authors` (`first_name`, `last_name`, `age`) VALUES ('Stephenie', 'Meyer', 47);
# INSERT INTO `authors` (`first_name`, `last_name`, `age`) VALUES ('Anna', 'Todd', 32);
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('Twilight', '2005', (SELECT id FROM authors WHERE first_name = 'Stephenie' AND last_name = 'Meyer'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('New Moon', '2006', (SELECT id FROM authors WHERE first_name = 'Stephenie' AND last_name = 'Meyer'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('Eclipse', '2007', (SELECT id FROM authors WHERE first_name = 'Stephenie' AND last_name = 'Meyer'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('Breaking Dawn', '2008', (SELECT id FROM authors WHERE first_name = 'Stephenie' AND last_name = 'Meyer'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('I Like It Like That', '2004', (SELECT id FROM authors WHERE first_name = 'Cecily von' AND last_name = 'Ziegesar'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('Because I\'m Worth It', '2003', (SELECT id FROM authors WHERE first_name = 'Cecily von' AND last_name = 'Ziegesar'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('Pretty Little Liars', '2012', (SELECT id FROM authors WHERE first_name = 'Sara' AND last_name = 'Shepard'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('Szent Johanna Gimi', '2013', (SELECT id FROM authors WHERE first_name = 'Leiner' AND last_name = 'Laura'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('Mindig Karácsony', '2019', (SELECT id FROM authors WHERE first_name = 'Leiner' AND last_name = 'Laura'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('Higgy nekem', '2021', (SELECT id FROM authors WHERE first_name = 'Leiner' AND last_name = 'Laura'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('After', '2014', (SELECT id FROM authors WHERE first_name = 'Anna' AND last_name = 'Todd'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('After We Collided', '2014',  (SELECT id FROM authors WHERE first_name = 'Anna' AND last_name = 'Todd'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('After We Fell', '2014', (SELECT id FROM authors WHERE first_name = 'Anna' AND last_name = 'Todd'));
# INSERT INTO `books` (`title`, `release_date`, `author_id`) VALUES ('After Ever Happy', '2015', (SELECT id FROM authors WHERE first_name = 'Anna' AND last_name = 'Todd'));
# INSERT INTO `users` (`email`, `username`, `password`) VALUES ('33renatafigler33@gmail.com', 'freni33', 'pass33');
# INSERT INTO `users` (`email`, `username`, `password`) VALUES ('mesebelihely@gmail.com', 'freni', 'pass');


