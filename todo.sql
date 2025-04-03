Hibernate:
create table member (
    created_at datetime(6),
    id bigint not null auto_increment,
    modified_at datetime(6),
    email varchar(255) not null,
    name varchar(255) not null,
    password varchar(255) not null,
    primary key (id)
) engine=InnoDB

Hibernate:
create table todo (
    created_at datetime(6),
    id bigint not null auto_increment,
    member_id bigint,
    modified_at datetime(6),
    contents longtext,
    title varchar(255) not null,
    primary key (id)
) engine=InnoDB

