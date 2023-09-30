<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="ImovelCadastrar" action="ImovelCadastrar" method="POST">
<div class="col-md-12 fixed-top" style="height: 220px; background-color: #212529; margin-top: 50px" >
    <div class="row col-md-12" style="margin-top: 15px">
        <label class="col-md-12" style="background-color: #212529; color: white; font-size: 16px">Casdastro de Imóvel</label>
    </div>
    <div class="col-md-12 row">
        <div class="col-md-1" style="color: white">
            <label>Id</label>
        </div>
        <div class="col-md-4" style="color: white">
            <label>Decrição</label>
        </div>
        <div class="col-md-6" style="color: white">
            <label>Rua</label>
        </div><div class="col-md-1" style="color: white">
            <label>Numero</label>
        </div>
    </div>
    <div class="col-md-12 row">
        <div class="col-md-1">
            <input class="form-control" type="text" name="idImovelC" id="idImovelC" 
            value="${imovel.idImovel}" size="100" maxlength="100">
        </div>
        <div class="col-md-4">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${imovel.descricao}" size="100" maxlength="100">
        </div>
        <div class="col-md-6">
            <input class="form-control" type="text" name="ruaC" id="ruaC" 
            value="${imovel.rua}" size="100" maxlength="100">
        </div>
        <div class="col-md-1">
            <input class="form-control" type="text" name="numeroC" id="numeroC" 
            value="${imovel.numero}" size="100" maxlength="100">
        </div>
    </div>
    <div class="col-md-12 row">
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Bairro</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Valor Alguel</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Taxa Administação</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Tipo Imovel</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Locator</label>
        </div>
    </div>
    <div class="col-md-12 row" style="margin-top: 10px">
        <div class="col-md-2">
            <input class="form-control" type="text" name="bairroC" id="bairroC" 
            value="${imovel.bairro}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="valorAluguelC" id="valorAluguelC" 
            value="${imovel.valorAluguel}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="taxaAdministracaoC" id="taxaAdministracaoC" 
            value="${imovel.taxaAdministracao}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
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
            <select class="form-control"  type="text" name="locadorC" id="locadorC">
                <option value="">[Nenhum]</option>
                        <c:forEach var="imovel" items="${imoveis}">
                            <option value="${imovel.locador.idLocador}" 
                                    ${imovel.locador.idLocador == locador.idLocador ? "selected" : ""}>
                                    ${imovel.locador.nome}
                            </option>
                        </c:forEach>
            </select>
        </div>
        <div align="right" class="col-md-2">
            <div>
                <button class="btn btn-success" type="submit" id="submit"onclick="validarCampos()">Incluir</button>
                <button class="btn btn-success" type="submit" id="submit"onclick="">Alterar</button>
            </div>
        </div>
    </div>
</div>
</form>

<div class="col-13 panel-body" style="margin-top: 280px">
    <div class="col-md-13 row">
        <div class="col-md-1">
            <label>Id</label>
        </div>
        <div class="col-md-2">
            <label>Descrição</label>
        </div>
        <div class="col-md-1">
            <label>Rua</label>
        </div>
        <div class="col-md-1">
            <label>Numero</label>
        </div>
        <div class="col-md-1">
            <label>Bairro</label>
        </div>
        <div class="col-md-1">
            <label>Valor Aluguel</label>
        </div>
        <div class="col-md-1">
            <label>Taxa Administracao</label>
        </div>
        <div class="col-md-1">
            <label>Tipo Imovel</label>
        </div>
        <div class="col-md-1">
            <label>Locador</label>
        </div>
        <div class="col-md-12 row">
            <c:forEach var="imovel" items="${imoveis}" >
                <div class="col-md-13 row" style="margin-top: 10px">
                    <div class="col-md-1">
                        <a align="left" id="idImovel">${imovel.idImovel}</a>
                    </div>
                    <div class="col-md-2">
                        <a align="left" id="descricao">${imovel.descricao}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="rua">${imovel.rua}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="numero">${imovel.numero}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="bairro">${imovel.bairro}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="valorAluguel">${imovel.valorAluguel}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="taxaAdministracao">${imovel.taxaAdministracao}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="tipoImovelDescricao">${imovel.tipoImovel.descricao}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="locadorNome">${imovel.locador.nome}</a>
                    </div>
                    <div class="col-md-1">
                        <a href="#" id="alterar" title="Alterar" onclick="alterar(${imovel.idImovel})" value="${imovel.idImovel}">
                            <button class="btn btn-group-lg btn-success"/>Alterar</button>
                        </a>
                    </div>
                    <div class="col-md-1" style="margin-left: 20px">
                        <a href="#" id="deletar" title="Excluir" onclick="deletar(${imovel.idImovel})">
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