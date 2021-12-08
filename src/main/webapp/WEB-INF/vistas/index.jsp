<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styleIndex.css">
    <link rel="stylesheet" href="css/styleIndex.css">
    <title>Hospital Florencia</title>
</head>

<body>
    <div class="section">
        <img src="img/hosp4k.png" class="img_hosp">
        <nav>
            <a href="#" class="logo">Hospital Florencia</a>
            <ul>
                <li><a href="" style="--i:1;">HOME</a></li>
                <li><a href="#" style="--i:2;">CONTACTO</a></li>
                <li><a href="#" style="--i:3;">SERVICIOS</a></li>
                <li><a href="registro" style="--i:4;" class="active">LOGIN</a></li>
            </ul>
        </nav>

        <div class="content">
            <div class="content_text">
                <h2>Tu salud,
                    <h2 class="auto-input"></h2>
                </h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vitae eaque facilis a. Dolorum maiores ut saepe veritatis quisquam consequatur quaerat aliquam, quod labore! A consequatur cupiditate dolore odit, exercitationem cum.</p>
                <a href="registro">INGRESAR</a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/typed.js@2.0.12"></script>
    <script>
        var typed = new Typed(".auto-input", {
            strings: ["Nuestra Prioridad", "Nos IMPORTA", "Con los mejores profesionales", "En el hospital Nº1 De Argentina"],
            typeSpeed: 100,
            backSpeed: 70,
            loop: true,
            showCursor: false
        });
    </script>
</body>

</html>