create table estado(
	idestado serial primary key,
	nomeestado varchar(100) not null,
	siglaestado varchar(2) not null
); 

insert into estado(nomeestado, siglaestado)
values ('São Paulo', 'SP');


create table  cidade(
idcidade serial primary key,
	nomecidade varchar(100) not null, 
	situacao varchar(1) not null,
	idestado int not null,
	constraint fk_estado FOREIGN key (idestado) references estado(idestado)
)

insert into cidade (nomecidade, situacao, idestado) values ('Fernandopolis', 'A', 8);
insert into cidade (nomecidade, situacao, idestado) values ('Jales', 'A', 8)



