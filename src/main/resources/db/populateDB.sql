DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;



ALTER SEQUENCE global_seq RESTART WITH 100000;
-- ALTER SEQUENCE global_seqmeal RESTART WITH 1;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES ('1', '100000', '2017-07-06 08:00:00.000000', 'Завтрак', '1000');
INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES ('2', '100000', '2017-07-06 13:00:00.000000', 'Обед', '902');
INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES ('4', '100001', '2017-07-06 08:00:00.000000', 'Завтрак', '500');
INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES ('5', '100001', '2017-07-06 13:00:00.000000', 'Обед', '510');
INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES ('6', '100001', '2017-07-06 22:00:00.000000', 'Ужин', '502');
INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES ('7', '100000', '2017-07-07 08:00:00.00000', 'Завтрак', '600');
INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES ('8', '100000', '2017-07-07 14:00:00.000000', 'Обед', '310');
INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES ('9', '100000', '2017-07-07 21:00:00.000000', 'Ужин', '202');


