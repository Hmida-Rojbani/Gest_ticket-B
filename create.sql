create table client_entity (id integer not null auto_increment, courriel varchar(255) not null, date_de_naissance date, nom varchar(50), prenom varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB
create table compose (tickets_numero bigint not null, mets_id integer not null) engine=InnoDB
create table met_entity (dtype varchar(31) not null, id integer not null auto_increment, name varchar(255), prix double precision not null, val integer, primary key (id)) engine=InnoDB
create table table_entity (numero bigint not null auto_increment, nb_couverts integer not null, supplement double precision not null, type varchar(255), primary key (numero)) engine=InnoDB
create table ticket_entity (numero bigint not null auto_increment, addition double precision not null, date_time datetime, nb_couvert integer not null, client_id integer, table_numero bigint, primary key (numero)) engine=InnoDB
alter table client_entity add constraint UK_k99ygrwcvyenrkbj5rjg5dc5m unique (courriel)
alter table compose add constraint FKh8k52lx2yffwf20l6nkbrce4l foreign key (mets_id) references met_entity (id)
alter table compose add constraint FK8l05vc2kbopnwx0i8becv7e2e foreign key (tickets_numero) references ticket_entity (numero)
alter table ticket_entity add constraint FKbm6arj6b0xbh1o60jbue3vw6u foreign key (client_id) references client_entity (id)
alter table ticket_entity add constraint FKijlgpe3j3aw917448id23646m foreign key (table_numero) references table_entity (numero)
