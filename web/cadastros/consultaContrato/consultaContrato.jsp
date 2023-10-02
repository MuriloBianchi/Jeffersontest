<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="ImovelCadastrar" action="ImovelCadastrar" method="POST">
<div class="col-md-12 fixed-top" style="height: 100px; background-color: #212529; margin-top: 50px" >
    
    <div class="col-md-12 row" style="margin-top: 10px">
        <div class="col-md-12 row">
            <div class="col-md-1" style="color: white">
                <label>Id</label>
            </div>
            <div class="col-md-2" style="color: white">
                <label>Data Inicial</label>
            </div>
            <div class="col-md-2" style="color: white">
                <label>Data Final</label>
            </div>
            <div class="col-md-3" style="color: white">
                <label>Locatario</label>
            </div>
            <div class="col-md-3" style="color: white">
                <label>Locador</label>
            </div>
        </div>
        <div class="col-md-12 row">
            <div class="col-md-1">
            <select class="form-control"  type="text" name="tipoImovelC" id="tipoImovelC">
                <option value="">[Nenhum]</option>
                        <c:forEach var="imovel" items="${imoveis}">
                            <option value="${imovel.tipoImovel.idTipoImovel}"
                                    ${imovel.tipoImovel.idTipoImovel == tipoImovel.idTipoImovel ? "selected" : ""}>
                                    ${imovel.tipoImovel.descricao} 
                            </option>
                        </c:forEach>
            </select>
        </div>
        <div class="col-md-2">
            <input class="form-control" type="Date" name="valorAluguelC" id="valorAluguelC" size="100" maxlength="100"
            value="${imovel.valorAluguel}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="Date" name="taxaAdministracaoC" id="taxaAdministracaoC" 
            value="${imovel.taxaAdministracao}" size="100" maxlength="100">
        </div>
        <div class="col-md-3">
            <select class="form-control"  type="text" name="tipoImovelC" id="tipoImovelC">
                <option value="">[Nenhum]</option>
                        <c:forEach var="locatario" items="${locatarios}">
                            <option value="${locatario.idLocatario}"
                                    ${locatario.idLocatario == locatario.idLocatario ? "selected" : ""}>
                                    ${locatario.nome} 
                            </option>
                        </c:forEach>
            </select>
        </div>
        <div class="col-md-3">
            <select class="form-control"  type="text" name="locadorC" id="locadorC">
                <option value="">[Nenhum]</option>
                        <c:forEach var="locadores" items="${locadores}">
                            <option value="${locadores.idLocador}" 
                                    ${locadores.idLocador == locadores.idLocador ? "selected" : ""}>
                                    ${locadores.nome}
                            </option>
                        </c:forEach>
            </select>
        </div>
        
        </div>
    </div>
</div>
</form>

<div class="col-13 panel-body" style="margin-top: 180px">
    <div class="col-md-13 row">
        <div class="col-md-1">
            <label>Id</label>
        </div>
        <div class="col-md-2">
            <label>mesesContrato</label>
        </div>
        <div class="col-md-1">
            <label>valor Total</label>
        </div>
        <div class="col-md-1">
            <label>valor Recebido</label>
        </div>
        <div class="col-md-1">
            <label>valor Descontos</label>
        </div>
        <div class="col-md-1">
            <label>valor Pago</label>
        </div>
        <div class="col-md-1">
            <label>valor Juros</label>
        </div>
        <div class="col-md-1">
            <label>saldo Contrato</label>
        </div>
        <div class="col-md-1">
            <label>Situação</label>
        </div>
        <div class="col-md-1">
            <a href="" id="alterar" title="Alterar" onclick="" value="${imovel.idImovel}">
                <button class="btn btn-group-lg btn-success"/>Alterar</button>
            </a>
        </div>
        
        <div class="col-md-12 row">
            <c:forEach var="contrato" items="${contratos}" >
                <div class="col-md-13 row" style="margin-top: 10px">
                    <div class="col-md-1">
                        <a align="left" id="idContrato">${contrato.idImovel}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="mesesContrato">${contrato.mesesContrato}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="valorTotal">${contrato.valorTotalContrato}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="valorRecebido">${contrato.valorRecebido}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="valorDescontos">${contrato.valorDescontos}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="valorPago">${contrato.valorPago}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="valorJuros">${contrato.valorJurosMultaRecebido}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="saldoContrato">${contrato.saldoContrato}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="Situação"></a>
                    </div>
                    <div align="left" class="col-md-1" >
                        <div class="col-md-12" >
                            <button class="btn btn-success" style="width: 100px"    type="submit" id="submit"onclick="">Listar</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<script>
   function alterar(id){
       console.log(id);
    $.ajax({
       type: 'post',
       url: 'ImovelCarregar',
       data:{idImovel: id},
       success:
               function (data){
                   console.log(data);
                   const Imovel = JSON.parse(data);
                   console.log(Imovel.descricao);
                   $("#idImovelC").val(Imovel.idImovel);
                   $("#descricaoC").val(Imovel.descricao);
                   $("#ruaC").val(Imovel.rua);
                   $("#numeroC").val(Imovel.numero);
                   $("#bairroC").val(Imovel.bairro);
                   $("#valorAluguelC").val(Imovel.valorAluguel);
                   $("#taxaAdministracaoC").val(Imovel.taxaAdministracao);
                   $("#tipoImovelC").val(Imovel.idTipoImovel);
                   $("#locadorC").val(Imovel.idLocador);
               }
    }); 
   }
   /*
   function validarCampos(id, descricao){
        $.ajax({
           type: 'post',
           url: 'TipoImovelCadastrar',
           data:{idTipoImovel: id, descricao: descricao},
           success:
                   function (data){
                       console.log("data");
                   }
        }); 
   }*/
</script>

<%@ include file="/footer.jsp" %>