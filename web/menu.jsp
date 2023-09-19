    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16"  style="color: #ffffff;">
        <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5V.5ZM2 11h1v1H2v-1Zm2 0h1v1H4v-1Zm-1 2v1H2v-1h1Zm1 0h1v1H4v-1Zm9-10v1h-1V3h1ZM8 5h1v1H8V5Zm1 2v1H8V7h1ZM8 9h1v1H8V9Zm2 0h1v1h-1V9Zm-1 2v1H8v-1h1Zm1 0h1v1h-1v-1Zm3-2v1h-1V9h1Zm-1 2h1v1h-1v-1Zm-2-4h1v1h-1V7Zm3 0v1h-1V7h1Zm-2-2v1h-1V5h1Zm1 0h1v1h-1V5Z"/>
      </svg>
      <a class="navbar-brand"href="#" style="--color: #ff1867"><span>Imobiliária </span><i></i></a>
      
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault" >
        <ul class="navbar-nav mr-auto ">
          <li class="nav-item active">
            <a class="nav-link" href="#" id="Home" style="--color: #FF3333"><span>Home </span><span class="sr-only">(atual)</span><i></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="TipoImvovel" onclick="Listar(this)"
            style="--color: #FF9933"><span>Tipo Imóvel</span><i></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="Tipo Desconto" onclick="Listar(this)"
            style="--color: #FFFF33"><span>Tipo Desconto</span><i></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="Locador" onclick="Listar(this)"
            style="--color: #6eff3e"><span>Locador</span><i></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="Locatário" onclick="Listar(this)"
            style="--color: #9933FF"><span>Locatário</span><i></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" id="Imovel" onclick="Listar(this)"
            style="--color: #1e9bff"><span>Imóvel</span><i></i></a>
          </li>
          <%--
          <div class="container">
            <a href="#" style="--color: #1e9bff"><span>Telegarm </span><i></i></a>
            <a href="#" style="--color: #ff1867"><span>Instagram </span><i></i></a>
            <a href="#" style="--color: #6eff3e"><span>Snap Chat </span><i></i></a>
          </div>
          --%>
      </div>
    </nav>
          
          <script>
    function Listar(botao){
        console.log("aqui");
        switch(botao.id){
            
            case "Home":
                window.location.href = "./index.jsp";
            break;
            
            case "TipoImvovel":
                window.location.href = "TipoImovelListar";
            break;

            case "Tipo Desconto":
                window.location.href = "./cadastros/tipoDesconto/tipoDesconto.jsp";
            break;

            case "Locador":
                window.location.href = "./cadastros/locador/locador.jsp";
            break;

            case "Locatário":
                window.location.href = "./cadastros/locatario/locatario.jsp";
            break;

            case "Imovel":
                window.location.href = "./cadastros/imovel/imovel.jsp";
            break;
            
            default:
                window.alert("Erro no Link");
        };
    };
</script>
    