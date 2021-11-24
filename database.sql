create database final; 
 
insert into especialidad (especialidad, fotoEspecialidad)
values ("Oftalmologia", "oftalmologia"),("Cardiologia", "cardiologia"),("Pediatria", "pediatria")
,("Odontologia", "odontologia"),("Gastroenterologia" , "gastroenterologia");

insert into dias (dias)
values ("Lunes"),("Martes"),("Miercoles"),("Jueves"),("Viernes"),("Sabado"),("Domingo");

insert into plansalud (descuento, nombre, precioDelPlan)
values (30,"Plan Basico",1000),(60,"Plan Silver",1700),(100,"Plan Gold",2500);

insert into ambulancia (disponible, patenteAmbulancia)
values (true, "AAA000"),(true, "AAA111"),(true, "AAA222");

select * from usuario;
select * from turnomedico;
select * from plansalud;
insert into usuario (contrasenia, fechaNacimiento, email, nombre, numeroDeTipoDeUsuario)
values (123456789, 19980507,"admin@gmail.com", "Admin", 3);

insert into usuario (contrasenia, fechaNacimiento, email, nombre, numeroDeTipoDeUsuario)
values (123456789, 19900507,"cris@gmail.com", "Cris", 1);

insert into usuario (contrasenia, fechaNacimiento, email, nombre, numeroDeTipoDeUsuario)
values (123456789, 19900507,"Hori@gmail.com", "Hori", 1);

insert into usuario (contrasenia, fechaNacimiento, email, nombre, numeroDeTipoDeUsuario, especialidad_idEspecialidad,telefono, paginaPersonal, avatar)
values (123456789, 19800505,"Maria@gmail.com", "Maria", 2,1,46515676,"Maria.com", "F"),(123456789, 19700205,"Roberto@gmail.com", "Roberto", 2,2,11654684,"Roberto.com", "M"),
(123456789, 19950421,"Camila@gmail.com", "Camila", 2,3,114141225,"Camila.com", "F"),(123456789, 19910112,"Joel@gmail.com", "Joel", 2,4,1158565525,"Joel.com", "M"),
(123456789, 19641212,"Carlos@gmail.com", "Carlos", 2,5,154654654,"Carlos.com","M"),(123456789, 20001205,"Lucas@gmail.com", "Lucas", 2,1,12101010,"Lucas.com","M"),
(123456789, 19500704,"Paul@gmail.com", "Paul", 2,2,1145458585,"Paul.com","M"),(123456789, 19890505,"Esteban@gmail.com", "Esteban", 2,3,14151212,"Esteban.com","M"),
(123456789, 19780310,"Julian@gmail.com", "Julian", 2,4,442525125,"Julian.com","M"),(123456789, 19980815,"Marcos@gmail.com", "Marcos", 2,5,46515676,"Marcos.com","M"),
(123456789, 19800505,"Mauricio@gmail.com", "Mauricio", 2,1,46515555,"Mauricio.com","M"),(123456789, 19970205,"Isaias@gmail.com", "Isaias", 2,2,44252525,"Isaias.com","M"),
(123456789, 19800505,"Sergio@gmail.com", "Sergio", 2,3,45465465,"Sergio.com","M"),(123456789, 19990205,"Ezequiel@gmail.com", "Ezequiel", 2,4,46515676,"Ezequiel.com","M"),
(123456789, 19800505,"Yuya@gmail.com", "Yuya", 2,5,44258956,"Yuya.com","F"),(123456789, 19700205,"Alfredo@gmail.com", "Alfredo", 2,1,44852525,"Alfredo.com","M"),
(123456789, 19800505,"Josefo@gmail.com", "Josefo", 2,2,44848484,"Josefo.com","M"),(123456789, 19891111,"Josias@gmail.com", "Josias", 2,3,78495626,"Josias.com","M"),
(123456789, 19800505,"Roberta@gmail.com", "Roberta", 2,4,4848954,"Roberta.com","F"),(123456789, 19980505,"Alejando@gmail.com", "Alejandro", 2,5,11374656,"Alejandro.com","M");

select * from especialidad;
select * from dias;
SELECT * FROM USUARIO;
select * from turnomedico;

delete from turnomedico;

