create table divida (id integer not null auto_increment, data_de_pgto date, data_final date, descricao varchar(255), nome varchar(255), tipo_divida varchar(255), valor float(53) not null, divida_mes_id integer, primary key (id)) engine=InnoDB;
alter table divida add constraint FKhw5grl4lp6gp8j3u6dwlbde7 foreign key (divida_mes_id) references divida_mes (id);