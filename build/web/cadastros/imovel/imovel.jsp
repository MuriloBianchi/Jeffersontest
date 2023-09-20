<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>


<div class="col-md-12 fixed-top" style="height: 220px; background-color: #212529; margin-top: 50px" >
    <div class="row col-md-12" style="margin-top: 15px">
        <label class="col-md-12" style="background-color: #212529; color: white; font-size: 16px">Casdastro De Tipo Imóvel</label>
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
            <input class="form-control" type="text" name="idtipoimovelC" id="idtipoimovelC" 
            value="${tipoImovel.idTipoImovel}" size="100" maxlength="100">
        </div>
        <div class="col-md-4">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${tipoImovel.descricao}" size="100" maxlength="100">
        </div>
        <div class="col-md-6">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${tipoImovel.descricao}" size="100" maxlength="100">
        </div>
        <div class="col-md-1">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${tipoImovel.descricao}" size="100" maxlength="100">
        </div>
    </div>
    <div class="col-md-12 row" ">
        <div class="col-md-3" style="color: white; margin-top: 12px">
            <label>Bairro</label>
        </div>
        <div class="col-md-3" style="color: white; margin-top: 12px">
            <label>Valor Alguel</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Taxa Administação</label>
        </div>
        <div class="col-md-4"></div>
    </div>
    <div class="col-md-12 row" style="margin-top: 10px">
        <div class="col-md-3">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${tipoImovel.descricao}" size="100" maxlength="100">
        </div>
        <div class="col-md-3">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${tipoImovel.descricao}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${tipoImovel.descricao}" size="100" maxlength="100">
        </div>
        <div align="right" class="col-md-4">
            <div>
                <button class="btn btn-success" type="submit" id="submit"onclick="validarCampos()">Incluir</button>
                <button class="btn btn-success" type="submit" id="submit"onclick="">Alterar</button>
            </div>
        </div>
    </div>
</div>

<div class="col-12 panel-body" style="margin-top: 250px">
    <div class="col-md-12 row">
        <div class="col-md-1">
            <label>Id</label>
        </div>
        <div class="col-md-8">
            <label>Descrição</label>
        </div>
    
        <div class="col-md-12 row">
            <c:forEach var="imovel" items="${imoveis}" >
                <div class="col-md-13 row" style="margin-top: 10px">
                    <div class="col-md-1">
                        <a align="left" id="idtipoimovel">${imovel.idImovel}</a>
                    </div>
                    <div class="col-md-8">
                        <a align="left" id="descricao">${imovel.descricao}</a>
                    </div>
                    <div class="col-md-1">
                        <a href="#" id="alterar" title="Alterar" onclick="alterar(${imovel.idImovel})" value="${imovel.descricao}">
                            <button class="btn btn-group-lg btn-success"/>Alterar</button>
                        </a>
                    </div>
                    <div class="col-md-1" style="margin-left: 20px">
                        <a href="#" id="deletar" title="Excluir" onclick="deletar(${imovel.idTipoImovel})">
                            <button class="btn btn-group-lg btn-danger"/>Deletar</button>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<div align="center" style="margin-top: 330px">
    <buttom href=#">Novo</buttom>
    <a href="index.jsp">Voltar a pagina Inicial</a>
</div>
<script>
</script>
    
<%@ include file="/footer.jsp" %>


