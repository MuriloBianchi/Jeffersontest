<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="TipoImovelCadastrar" action="TipoImovelCadastrar" method="POST">
<div class="col-md-12 fixed-top" style="height: 205px; background-color: #212529; margin-top: 50px" >
    <div class="row col-md-12" style="margin-top: 15px">
        <label class="col-md-12" style="background-color: #212529; color: white; font-size: 16px">Casdastro De Tipo Im�vel</label>
    </div>
    <div class="col-md-12 row">
        <div class="col-md-4" style="color: white">
            <label>Id</label>
        </div>
        <div class="col-md-8" style="color: white">
            <label>Decri��o</label>
        </div>
    </div>
    <div class="col-md-12 row">
        <div class="col-md-4">
            <input class="form-control" type="text" name="idtipoimovelC" id="idtipoimovelC"> 
            value="${tipoImovel.idTipoImovel}" size="100" maxlength="100">
        </div>
        <div class="col-md-8">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${tipoImovel.descricao}" size="100" maxlength="100">
        </div>
    </div>
    <div class="col-md-12 row" style="margin-top: 10px">
        <div class="col-md-8"></div>
        <div align="right" class="col-md-4">
            <div>
                <button class="btn btn-success" type="submit" id="cadastrar" onclick="">Incluir</button>
                <button class="btn btn-success" type="submit" id="submit"onclick="">Alterar</button>
            </div>
        </div>
    </div>
</div>
</form>

<div class="col-12 panel-body" style="margin-top: 275px">
    <div class="col-md-12 row">
        <div class="col-md-1">
            <label>Id</label>
        </div>
        <div class="col-md-8">
            <label>Descri��o</label>
        </div>
    
        <div class="col-md-12 row">
            <c:forEach var="tipoImovel" items="${tipoImoveis}" >
                <div class="col-md-13 row" style="margin-top: 10px">
                    <div class="col-md-1">
                        <a align="left" id="idtipoimovel">${tipoImovel.idTipoImovel}</a>
                    </div>
                    <div class="col-md-8">
                        <a align="left" id="descricao">${tipoImovel.descricao}</a>
                    </div>
                    <div class="col-md-1">
                        <a href="#" id="alterar" title="Alterar" onclick="alterar(${tipoImovel.idTipoImovel})" value="${tipoImovel.descricao}">
                            <button class="btn btn-group-lg btn-success"/>Alterar</button>
                        </a>
                    </div>
                    <div class="col-md-1" style="margin-left: 20px">
                        <a href="${pageContext.request.contextPath}/TipoImovelExcluir?idTipoImovel=${tipoImovel.idTipoImovel}" id="deletar" title="Excluir">
                            <button class="btn btn-group-lg btn-danger"/>Deletar</button>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
   
<script>
   function alterar(id){
    $.ajax({
       type: 'post',
       url: 'TipoImovelCarregar',
       data:{idTipoImovel: id},
       success:
               function (data){
                   console.log("data");
                   console.log(data);
                   const TipoImovel = JSON.parse(data);
                   console.log(TipoImovel.descricao);
                   $("#descricaoC").val(TipoImovel.descricao);
                   $("#idtipoimovelC").val(TipoImovel.idTipoImovel);
               }
    }); 
   }
</script>
    
<%@ include file="/footer.jsp" %>


