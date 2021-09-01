<#macro page>
    <!doctype html>
    <html lang="en"  class="h-100">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Vyacheslav Staravoyt and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.84.0">
        <title>Cover Template · Bootstrap v5.0</title>


        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/cover/">



        <!-- Bootstrap core CSS -->
        <link href="/static/css/bootstrap.min.css" rel="stylesheet">

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="/static/cover.css" rel="stylesheet">
    </head>
    <body class="d-flex h-100 text-center text-white bg-dark">


<div class="container-fluid d-flex h-100 p-0 mx-auto flex-column">
    <header class="masthead mb-auto">

                    <#include "navbarStart.ftl">

        </header>

        <main class="px-3">
            <h1>Welcome to the site service history.</h1>
            <p class="lead">Let's create a story together serving a car in a car shop. Make our world good and friendly.</p>
            <p class="lead">
                <a href="/main" class="btn btn-lg btn-secondary fw-bold border-white bg-white">Learn more</a>
            </p>
        </main>

        <footer class="mt-auto text-white-50">
            <p>Cover template for <a href="https://getbootstrap.com/" class="text-white">Bootstrap</a>, by <a href="https://twitter.com/mdo" class="text-white">@mdo</a>.</p>
        </footer>
        <div class="container mt-5" >
            <#nested>
        </div>

    </div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    </body>
    </html>
</#macro>