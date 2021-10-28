

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

select * from especialidad;
select * from turnomedico;
select * from usuario;

select * from turno;
ALTER TABLE usuario MODIFY foto text ;

insert into dias (dias)
values ("Lunes"),("Martes"),("Miercoles"),("Jueves"),("Viernes"),("Sabado"),("Domingo");


insert into usuario (contrasenia, edad, email, nombre, numeroDeDeTipoDeUsuario)
values (123456789, 40,"admin@gmail.com", "Jose", 3);

insert into usuario (contrasenia, edad, email, nombre, numeroDeDeTipoDeUsuario)
values (123456789, 40,"cris@gmail.com", "mario", 2);


update turnomedico
set estado = true;


