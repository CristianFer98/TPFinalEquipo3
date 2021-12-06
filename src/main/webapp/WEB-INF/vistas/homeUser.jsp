<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styleHomeUser.css">
    <link rel="stylesheet" href="css/shadow.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer"
    />
    <link href="css/css/mobiscroll.javascript.min.css" rel="stylesheet" />

    <title>Home Hospital</title>
</head>

<body>
    <div class="section">
        <div class="section-left">
            <nav>
                <h3 class="logo">HF</h3>

                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="listarEspecialidad">Turnos</a></li>
                    <li><a href="centralAmbulancia">Ambulancia</a></li>
                    <li><a href="planes">Planes</a></li>
                </ul>

            </nav>

            <div class="section-content">
                <h2>Hola, ${sessionScope.get("nombre")}.</h2>

                <div class="content-buttons">
                    <h5>Servicios</h5>


                    <div class="btns shadow-shorter">
                        <a href="listarEspecialidad">Reservar Turno</a>
                        <p>Reserva tu turno con el medico que vos desees</p>
                    </div>

                    <div class="btns shadow-shorter">
                        <a href="centralAmbulancia">Solicitar Ambulancia</a>
                        <p>Urgencia? Reserva tu ambulancia lo mas pronto posible</p>
                    </div>

                    <div class="btns shadow-shorter">
                        <a href="planes">Planes Medicos</a>
                        <p>Asociate a nuestros planes medicos y obtene los mejores beneficios</p>
                    </div>


                </div>
            </div>








        </div>

        <div class="section-right">
            <nav class="nav-right">
                <a href="index" class="info-user">
                    <div>Cerrar sesion</div>
                    <div><i class="fas fa-sign-out-alt"></i></div>
                </a>
            </nav>

            <div class="content-right">
                <div class="calendario">
                    <div id="calendar"></div>
                </div>

                <div class="lista-turnos">
                    <h3>Proximos Turnos - ${lista.size()} </h3>

<c:forEach var="lista" items="${lista}">		
               <div class="turno-card">
                        <div>
                            <div>  Dr. ${lista.medicoAsignado.nombre}  - ${lista.medicoAsignado.especialidad.especialidad} </div>
                            <div>  Hora: ${lista.fecha.hour}:${lista.fecha.minute}</div>
                            <c:if test="${lista.pagado == null}">
	        					<div style="background-color: yellow; color: black"> Pendiente De Pago</div> 
	        				</c:if>
	        			    <c:if test="${lista.pagado != null}">
	        					<div style="background-color: green; color: white" > PAGADO</div> 
	        				</c:if>
                        </div>
                        <a href="cancelarTurno?idTurno=${lista.id}">Cancelar Turno</a>
               </div>	 
</c:forEach>			  
			 

                </div>



            </div>

        </div>




        <script src="js/js/mobiscroll.javascript.min.js"></script>
        <script>
            mobiscroll.datepicker('#calendar', {
                controls: ['calendar'],
                display: 'inline',
                themeVariant: 'light',
            });
        </script>
</body>

</html>