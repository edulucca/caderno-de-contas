create table divida (id integer not null auto_increment, data_de_pgto datetime(6), data_final datetime(6), desc varchar(255), nome varchar(255), tipo_divida_enum varchar(255), valor float(53) not null, divida_mes_id integer not null, primary key (id)) engine=InnoDB;
create table divida_mes (id integer not null auto_increment, num_mes integer not null, primary key (id)) engine=InnoDB;
alter table divida add constraint FKhw5grl4lp6gp8j3u6dwlbde7 foreign key (divida_mes_id) references divida_mes (id);
create table divida (id integer not null auto_increment, data_de_pgto datetime(6), data_final datetime(6), desc varchar(255), nome varchar(255), tipo_divida_enum varchar(255), valor float(53) not null, divida_mes_id integer not null, primary key (id)) engine=InnoDB;
create table divida_mes (id integer not null auto_increment, num_mes integer not null, primary key (id)) engine=InnoDB;
alter table divida add constraint FKhw5grl4lp6gp8j3u6dwlbde7 foreign key (divida_mes_id) references divida_mes (id);
