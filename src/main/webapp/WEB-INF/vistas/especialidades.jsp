<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
    <link rel="stylesheet" href="css/estilo.css">
    
    <script src="https://kit.fontawesome.com/f44bbf66b4.js" crossorigin="anonymous"></script>

    <title>Document</title>
</head>
<body>
        <header>
            <div class="header_titulo">
            <img src="css/hospital.png" alt="logoHospital" id="logo"> Hospital Andres Borgeat
            </div>
                    
            <div class="buscador">
                <input type="search" name="buscador" class="buscadorHeader" placeholder="Buscar servicios" id="">
                <input type="submit" value="Buscar" style="height: 30px;">
            </div>

        </header>

        <nav>
            <a href="" class="linkNav">Principal</a>
            <a href="" class="linkNav">Acerca del Hospital</a>
            <a href="" class="linkNav">Areas</a>
            <a href="" class="linkNav">Contacto</a>

        </nav>

        <main>

<div class="contenedorCards" style="margin-top: 30px;width: 100%;display:flex; flex-direction:column; align-items:center; justify-content:space-around;">

<div class="card text-white bg-dark mb-3" style="width: 70%">
  <div class="card-header">Cardiologia</div>
  <div class="card-body">
    <p class="card-text">Tenemos los especialistas mas avanzados en el area de la cardiologia
        <a href="http://localhost:8080/proyecto-limpio-spring/cardiologia" >Click aqui </a>
    </p>
  </div>
</div>


<div class="card text-white bg-dark mb-3" style="width: 70%">
  <div class="card-header">Pediatria</div>
  <div class="card-body">
    <p class="card-text">Tenemos los especialistas mas avanzados en el area de la pediatria
        <a href="http://localhost:8080/proyecto-limpio-spring/fisiatria" >Click aqui </a>
    </p>
  </div>
</div>



<div class="card text-white bg-dark mb-3" style="width: 70%">
  <div class="card-header">Neurologia</div>
  <div class="card-body">
    <p class="card-text">Tenemos los especialistas mas avanzados en el area de la neurologia.
         <a href="http://localhost:8080/proyecto-limpio-spring/fisiatria" >Click aqui </a>
     </p>
  </div>
</div>


<div class="card text-white bg-dark mb-3" style="width: 70%">
  <div class="card-header">Fisiatria</div>
  <div class="card-body">
    <p class="card-text">Tenemos los especialistas mas avanzados en el area de la Fisiatria. 
    <a href="http://localhost:8080/proyecto-limpio-spring/fisiatria" >Click aqui </a>
    </p>
  </div>
</div>



<div class="card text-white bg-dark mb-3" style="width: 70%">
  <div class="card-header">Oncologia</div>
  <div class="card-body">
    <p class="card-text">Tenemos los especialistas mas avanzados en el area de la oncologia.
         <a href="http://localhost:8080/proyecto-limpio-spring/fisiatria" >Click aqui </a>
     </p>
  </div>
</div> 

</div>
        </main>

        <footer>
            

        </footer>
</body>
</html>

