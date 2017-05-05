
CREATE TABLE users(
   username varchar(20) NOT NULL,
   password varchar(20) NOT NULL,
   enabled boolean NOT NULL DEFAULT FALSE,
   primary key(username)
);

create table user_roles (
  user_role_id SERIAL PRIMARY KEY,
  username varchar(20) NOT NULL,
  role varchar(20) NOT NULL,
  UNIQUE (username,role),
  FOREIGN KEY (username) REFERENCES users (username)
);


INSERT INTO  users(username,password,enabled) VALUES ('sreenu','sreenu', true);
INSERT INTO  users(username,password,enabled) VALUES ('doosari','doosari', true);

INSERT INTO user_roles (username, role) VALUES ('sreenu', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('doosari', 'ROLE_ADMIN');