create table if not exists course_users
(
    user_id bigint PRIMARY KEY,
    first_name varchar(50),
    last_name varchar(50),
    email varchar(50),
    password varchar(50),
    role anyenum
);

