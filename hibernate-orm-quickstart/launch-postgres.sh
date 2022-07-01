#!/usr/bin/env -S bash -e

docker run --ulimit memlock=-1:-1 -d --rm=true --memory-swappiness=0 \
    --name i25607-postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=admin \
    -e POSTGRES_DB=defaultdb -p 5432:5432 postgres:13.1
trap "docker rm -f i25607-postgresql" ERR

while ! docker exec -i i25607-postgresql pg_isready
do
	echo 2>&1 "Waiting for postgresql to be ready..."
	sleep 1
done

echo 2>&1 "Initializing database..."

docker exec -i i25607-postgresql psql -vv -U postgres <<EOF
create database db1;
create user user1 with encrypted password 'password1';
grant all privileges on database db1 to user1;

create database db2;
create user user2 with encrypted password 'password2';
grant all privileges on database db2 to user2;

\connect db1 user1
create schema DB1;
create sequence DB1.known_fruits_id_seq start 10 increment 1;

    create table DB1.known_fruits (
       id int4 not null,
        name varchar(40),
        primary key (id)
    );

    alter table if exists DB1.known_fruits
       add constraint UK_57g3m8wr3qxoj706a6hsqg6ye unique (name);

\connect db2 user2
create schema DB2;
create sequence DB2.known_fruits_id_seq start 10 increment 1;

    create table DB2.known_fruits2 (
       id int4 not null,
        name varchar(40),
        primary key (id)
    );

    alter table if exists DB2.known_fruits2
       add constraint UK_jbccn4k3y40fp9j0ygdf9oxab unique (name);
EOF

echo 2>&1 "Databases ready and initalized."
echo 2>&1 "Attaching to container."

docker attach i25607-postgresql
