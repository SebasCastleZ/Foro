create table topico(
    id bigint not null auto_increment,
    tema varchar(100) not null,
    texto varchar(100) not null,
    fecha varchar(20) not null,
    activo tinyint default 1,

    primary key (id)
)