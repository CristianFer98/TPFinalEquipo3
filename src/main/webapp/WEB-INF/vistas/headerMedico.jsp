<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style>
    @import url('https://fonts.googleapis.com/css2?family=Nunito&display=swap');
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Nunito', sans-serif;
    }
    
    nav {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 40px;
        -webkit-box-shadow: 0px 8px 7px -10px rgba(0, 0, 0, 0.65);
        -moz-box-shadow: 0px 8px 7px -10px rgba(0, 0, 0, 0.65);
        box-shadow: 0px 8px 7px -10px rgba(0, 0, 0, 0.65);
        margin-bottom: 20px;
    }
    
    nav h3 {
        font-size: 3em;
        color: #0169b2;
        font-weight: 800;
    }
    
    nav ul {
        display: flex;
        font-size: 2em;
    }
    
    nav ul li {
        list-style: none;
        margin-left: 60px;
        transition: 0.5s;
    }
    
    nav ul li a {
        text-decoration: none;
        color: black;
    }
    
    nav ul li:hover {
        -webkit-box-shadow: 0px 20px 9px -15px rgba(0, 0, 0, 0.69);
        -moz-box-shadow: 0px 20px 9px -15px rgba(0, 0, 0, 0.69);
        box-shadow: 0px 20px 9px -15px rgba(0, 0, 0, 0.69);
    }
    
    .logout {
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 1.5em;
        color: black;
        text-decoration: none;
        background-color: lightcoral;
        border-radius: 30px;
        padding: 10px;
        transition: 0.8s;
    }
    
    .logout:hover {
        background-color: red;
    }
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer"
/>


<nav>
    <div class="logo">
        <h3>HF</h3>
    </div>
    <div>
        <ul>
            <li><a href="MyPerfil">PERFIL</a> </li>
            <li><a href="FormAgenda">AGENDA</a></li>
            <li><a href="verTurnos">COMPROMISOS</a></li>
        </ul>
    </div>
    <div>
        <a href="index" class="logout">
            <div>Cerrar sesion</div>
            <div><i class="fas fa-sign-out-alt"></i></div>
        </a>
    </div>
</nav>