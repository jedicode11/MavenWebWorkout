INSERT INTO `webworkout`.`workout` (`title`, `creator`, `workoutRatings`, `publisher`, `tags`, `description`)
VALUES ('Calisthenics', 'Bill Morison', '200', 'Bicep and Triceps', '25', 'Fitness Workout & Conditioning.');
INSERT INTO `webworkout`.`workout` (`title`, `creator`, `workoutRatings`, `publisher`, `tags`, `description`)
VALUES ('Swimming', 'Jaden Dreams', '400', 'Crawl & BackStroke', '27', 'Agility & MuscleFibers');
INSERT INTO `webworkout`.`workout` (`title`, `creator`, `workoutRatings`, `publisher`, `tags`, `description`)
VALUES ('Snowboarding', 'Torstein Horgmo', '200', 'Slopes or Pipe', '23', 'Freestyle & Vert');

SELECT id, title, workoutRatings FROM webworkout.workout WHERE workoutRatings > 40;