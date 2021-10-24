 insert into especialidad (especialidad)
values ("Cardiologia");

insert into especialidad (especialidad)
values ("Pediatria");

insert into especialidad (especialidad)
values ("Oftalmologia");

insert into especialidad (especialidad)
values ("Gastroenterologia");

insert into especialidad (especialidad)
values ("Odotologia");

select * from usuario;
select * from especialidad;
select * from turnomedico;

insert into usuario (contrasenia, edad, email, nombre, numeroDeDeTipoDeUsuario)
values (123456789, 40,"admin@gmail.com", "Jose", 3);

insert into usuario (contrasenia, edad, email, nombre, numeroDeDeTipoDeUsuario)
values (123456789, 40,"cris@gmail.com", "mario", 2);

insert into turnomedico (estado,fecha, medicoAsignado_idUsuario)
values (true,20211105082000,8);

insert into turnomedico (estado, fecha, medicoAsignado_idUsuario)
values (true,20211105083000,8);

insert into turnomedico (estado,fecha, medicoAsignado_idUsuario)
values (true,20211105084000,8);

update turnomedico
set estado = true;


