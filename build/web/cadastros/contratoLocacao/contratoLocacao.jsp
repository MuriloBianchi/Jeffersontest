<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="contratoCadastrar" action="contratoCadastrar" method="POST">
<div class="col-md-12 fixed-top" style="height: 400px; background-color: #212529; margin-top: 50px" >
    <div class="row col-md-12" style="margin-top: 15px">
        <label class="col-md-12" style="background-color: #212529; color: white; font-size: 16px">Casdastro Contrato Locação</label>
    </div>
    <div class="col-md-12 row" id="Linha1">
        <div class="col-md-2" style="color: white" hidden="true">
            <label>Id</label>
        </div>
        <div class="col-md-2" style="color: white">
            <label>Data Contrato</label>
        </div>
        <div class="col-md-2" style="color: white">
            <label>Data Inicio</label>
        </div>
        <div class="col-md-2" style="color: white">
            <label>Data Final</label>
        </div>
         <div class="col-md-2" style="color: white">
            <label>Meses Contrato</label>
        </div>
        <div class="col-md-2" style="color: white">
            <label>Dia Recebimento</label>
        </div>
        <div class="col-md-2" style="color: white">
            <label>Dia Pagamento</label>
        </div>
    </div>
    <div class="col-md-12 row">
        <div class="col-md-2" hidden="true">
            <input class="form-control" type="text" name="idContratoLocacao" id="idContratoLocacaoC" 
            value="${contratoLocacao.idContrato}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="dataContratoC" id="dataContratoC" 
            value="${contratoLocacao.dataContrato}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="dataInicioC" id="dataInicioC" 
            value="${contratoLocacao.dataInicio}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="dataFinalC" id="dataFinalC" 
            value="${contratoLocacao.dataFinal}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="mesesContratoC" id="mesesContratoC" 
            value="${contratoLocacao.mesesContrato}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="diaRecebimentoC" id="diaRecebimentoC" 
            value="${contratoLocacao.diaRecebimento}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="diaPagamentoC" id="diaPagamentoC" 
            value="${contratoLocacao.diaPagamento}" size="100" maxlength="100">
        </div>
    </div>
    <div class="col-md-12 row" id="Linha2">
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Valor Total</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Valor Recebido</label>
        </div>
        <div class="col-md-1" style="color: white; margin-top: 12px">
            <label>Valor Descontos</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Valor Pago</label>
        </div>
        <div class="col-md-1" style="color: white; margin-top: 12px">
            <label>Valor Juros Multa</label>
        </div>
        <div class="col-md-1" style="color: white; margin-top: 12px">
            <label>Valor Juros Pago</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Saldo Contrato</label>
        </div>
    </div>
    <div class="col-md-12 row" style="margin-top: 10px">
        <div class="col-md-2">
            <input class="form-control" type="text" name="valorTotalRecebidoC" id="valorTotalRecebidoC" 
            value="${contratoLocacao.valorTotalRecebido}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="valorRecebidoC" id="valorRecebidoC" 
            value="${contratoLocacao.valorRecebido}" size="100" maxlength="100">
        </div>
        <div class="col-md-1">
            <input class="form-control" type="text" name="valorDescontosC" id="valorDescontosC" 
            value="${contratoLocacao.valorDescontos}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="valorPagoC" id="valorPagoC" 
            value="${contratoLocacao.valorPago}" size="100" maxlength="100">
        </div>
        <div class="col-md-1">
            <input class="form-control" type="text" name="valorJurosMultaRecebidoC" id="valorJurosMultaRecebidoC" 
            value="${contratoLocacao.valorJurosMultaRecebido}" size="100" maxlength="100">
        </div>
        <div class="col-md-1">
            <input class="form-control" type="text" name="valorJurosMultaPagoC" id="valorJurosMultaPagoC" 
            value="${contratoLocacao.valorJurosMultaPago}" size="100" maxlength="100">
        </div>
        <div class="col-md-2">
            <input class="form-control" type="text" name="saldoContratoC" id="saldoContratoC" 
            value="${contratoLocacao.saldoContrato}" size="100" maxlength="100">
        </div>
    </div>
        <div class="col-md-12 row" id="Linha3">
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Imovel</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Locador</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Locatario</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>N° Parcela</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Pacela Pagar</label>
        </div>
        <div class="col-md-2" style="color: white; margin-top: 12px">
            <label>Parcela Desconto</label>
        </div>
    </div>
    <div class="col-md-12 row" style="margin-top: 10px">
        <div class="col-md-2">
            <select class="form-control"  type="text" name="ImovelC" id="ImovelC">
                <option value="">[Nenhum]</option>
                <c:forEach var="imovel" items="${imoveis}">
                    <option value="${imovel.idImovel}"
                            ${contratoLocacao.imovel.idImovel == Imovel.idImovel ? "selected" : ""}>
                            ${imovel.descricao} 
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-2">
            <select class="form-control"  type="text" name="locadorC" id="locadorC">
                <option value="">[Nenhum]</option>
                <c:forEach var="locador" items="${locadores}">
                    <option value="${locador.idLocador}" 
                            ${contratoLocacao.locador.idLocador == locador.idLocador ? "selected" : ""}>
                            ${locador.nome}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-2">
            <select class="form-control"  type="text" name="locatarioC" id="locatarioC">
                <option value="">[Nenhum]</option>
                <c:forEach var="locatario" items="${locatarios}">
                    <option value="${locatario.idLocatario}" 
                            ${contratoLocacao.locatario.idLocatario == locatario.idLocatario ? "selected" : ""}>
                            ${locatario.nome}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-2">
            <select class="form-control"  type="text" name="ParcelaC" id="ParcelaC">
                <option value="">[Nenhum]</option>
                
            </select>
        </div>
        <div class="col-md-2">
            <select class="form-control"  type="text" name="ParcelaPagarC" id="ParcelaPagarC">
                <option value="">[Nenhum]</option>
                
            </select>
        </div>
        <div class="col-md-2">
            <select class="form-control"  type="text" name="ParcelaDescontoC" id="ParcelaDescontoC">
                <option value="">[Nenhum]</option>
                
            </select>
        </div>
        <div class="col-md-12 row" style="margin-top: 25px">
            <div align="right" class="col-md-12">
            <div>
                <button class="btn btn-success" type="submit" id="submit">Incluir</button>
                <button class="btn btn-success" type="submit" id="submit"onclick="">Alterar</button>
            </div>
        </div>
        </div>
    </div>
</div>
</form>

<div class="col-13 panel-body" style="margin-top: 480px">
    <div class="col-md-13 row">
        <div class="col-md-1">
            <label>Id</label>
        </div>
        <div class="col-md-1">
            <label>Data Contrato</label>
        </div>
        <div class="col-md-1">
            <label>Data Inicio</label>
        </div>
        <div class="col-md-1">
            <label>Data Final</label>
        </div>
        <div class="col-md-1">
            <label>Meses Contrato</label>
        </div>
        <div class="col-md-1">
            <label>Dia Recebimento</label>
        </div>
        <div class="col-md-1">
            <label>Dia Pagamento</label>
        </div>
        <div class="col-md-1">
            <label>Valor Total</label>
        </div>
        <div class="col-md-1">
            <label>Valor Recebido</label>
        </div>
        <div class="col-md-1">
            <label>Valor Descontos</label>
        </div>
        <div class="col-md-1">
            <label>Valor Pagos</label>
        </div>
        <div class="col-md-1">
            <label>Juros Recebido</label>
        </div>
        <div class="col-md-1">
            <label>Juros Pago</label>
        </div>
        <div class="col-md-1">
            <label>Saldo Contrato</label>
        </div>
        <div class="col-md-1">
            <label>Imovel</label>
        </div>
        <div class="col-md-1">
            <label>Locador</label>
        </div>
        <div class="col-md-1">
            <label>Locatario</label>
        </div>
        <div class="col-md-12 row">
            <!--<c:forEach var="contrato" items="${contratos}" >
                <div class="col-md-13 row" style="margin-top: 10px">
                    <div class="col-md-1">
                        <a align="left" id="idImovel">${contrato.idContrato}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="descricao">${contrato.dataContrato}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="rua">${contrato.dataInicio}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="numero">${contrato.dataFinal}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="bairro">${contrato.dataFinal}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="valorAluguel">${contrato.mesesContrato}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="taxaAdministracao">${contrato.diaRecebimento}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="tipoImovelDescricao">${contrato.diaPagamento}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="taxaAdministracao">${contrato.valorTotalRecebido}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="tipoImovelDescricao">${contrato.valorRecebido}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="taxaAdministracao">${contrato.valorDescontos}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="tipoImovelDescricao">${contrato.valorPago}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="tipoImovelDescricao">${contrato.valorJurosMultaRecebido}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="tipoImovelDescricao">${contrato.valorJurosMultaPago}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="tipoImovelDescricao">${contrato.saldoContrato}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="locadorNome">${contrato.imovel.descricao}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="locadorNome">${contrato.locador.nome}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="locadorNome">${contrato.locatario.nome}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="locadorNome">${contrato.parcelaReceber.nroParcela}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="locadorNome">${contrato.pacelaPagar.idParcelaPagar}</a>
                    </div>
                    <div class="col-md-1">
                        <a align="left" id="locadorNome">${contrato.parcelaDesconto.idPArcelaDesconto}</a>
                    </div>
                    <div class="col-md-1">
                        <a href="#" id="alterar" title="Alterar" onclick="alterar(${contrato.idContrato})" value="${contrato.idContrato}">
                            <button class="btn btn-group-lg btn-success"/>Alterar</button>
                        </a>
                    </div>
                    <div class="col-md-1" style="margin-left: 20px">
                        <a href="#" id="deletar" title="Excluir" onclick="deletar(${contrato.idContrato})">
                            <button class="btn btn-group-lg btn-danger"/>Deletar</button>
                        </a>
                    </div>
                </div>
            </c:forEach>-->
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