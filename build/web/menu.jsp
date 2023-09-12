<div id="menu">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="home.jsp">
                <img src="imagens/icons8-java.gif" alt="Home"/>
            </a>
            <ul class="navbar-nav me-auto grid gap-2">
                
                <li class="nav-item">
                    <button class="btn btn-outline-primary" id="Estados" onclick="Listar(this)">Estados</button>
                </li>
                
                <li class="nav-item">
                    <button class="btn btn-outline-primary" id="Cidades" onclick="Listar(this)">Cidades</button>
                </li>
                
                <li class="nav-item">
                    <button class="btn btn-outline-primary" id="Veiculos" onclick="Listar(this)">Veiculos</button>
                </li>
                
                <li class="nav-item">
                    <button class="btn btn-outline-primary" id="Modelos" onclick="Listar(this)">Modelos</button>
                </li>
                
                <li class="nav-item">
                    <button class="btn btn-outline-primary" id="Marcas" onclick="Listar(this)">Marcas</button>
                </li>
                
                <li class="nav-item">
                    <button class="btn btn-outline-primary" id="Imoveis" onclick="Listar(this)">Imoveis</button>
                </li>
               
                <li class="nav-item">
                    <button class="btn btn-outline-primary" id="Despesas" onclick="Listar(this)">Despesa</button>
                </li>
                
            </ul>
        </div>
    </nav>
</div>

<script>
    function Listar(botao){
        console.log("aqui");
        switch(botao.id){
            case "Estados":
                window.location.href = "EstadoListar";
            break;
            
            case "Cidades":
                window.location.href = "CidadeListar";
            break;
            
            case "Veiculos":
                window.location.href = "VeiculoListar";
            break;
            
            case "Modelos":
                window.location.href = "ModeloListar";
            break;
            
            case "Marcas":
                window.location.href = "MarcaListar";
            break;
            
            case "Imoveis":
                window.location.href = "ImovelListar";
            break;
            
            case "Despesas":
                window.location.href = "DespesaListar";
            break;
            
            default:
                window.alert("Erro no Link");
        };
        
    };                
                                  
</script>

