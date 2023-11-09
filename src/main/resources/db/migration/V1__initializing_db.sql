CREATE TABLE IF NOT EXISTS users
(
    id serial primary key,
    name varchar(32),
    surname varchar(32),
    email varchar(32)
);

CREATE TABLE IF NOT EXISTS tasks
(
    id    serial primary key,
    title  varchar(32),
    description  varchar(32),
    status varchar(32)
);

CREATE TABLE IF NOT EXISTS user_task
(
    user_id int,
    task_id int,
    foreign key (user_id) REFERENCES users (id),
    foreign key (task_id) REFERENCES tasks (id)
);
