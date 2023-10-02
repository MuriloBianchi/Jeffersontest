<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Contrato Locação</h1>
    <p class="mb-4">Detalhes do Contrato</p>

    <a class="btn btn-secondary mb-4" href="${pageContext.request.contextPath}/ContratolocacaoListar">
        <i class="fas fa-undo-alt"></i>
        <strong>Voltar</strong>
    </a>
    <div class="card shadow">
        <div class="card-body">
            <table id="datatable" class="display">
                <thead>
                    <tr>
                        <td align="left"><b>ID:</b> ${contratolocacao.idContrato}</td>
                        <td align="left" colspan="3"><b>Locatario:</b> ${contratolocacao.locatario.nome}</td>
                        <td align="left" colspan="5"><b>Imovel(Endereço):</b> ${contratolocacao.imovel.rua}, ${contratolocacao.imovel.numero} - ${contratolocacao.imovel.bairro}</td>
                    </tr>
                    <tr>
                        <td align="left" colspan="3"><b>Locador:</b> ${contratolocacao.locador.nome}</th>
                        <td align="left" colspan="2"><b>Data Contrato:</b> <fmt:formatDate pattern="dd/MM/yyyy" value="${contratolocacao.datacontrato}" /></td>
                        <td align="left" colspan="2"><b>Data Inicio:</b> <fmt:formatDate pattern="dd/MM/yyyy" value="${contratolocacao.datainicio}" /></td>
                        <td align="left" colspan="2"><b>Data Fim:</b> <fmt:formatDate pattern="dd/MM/yyyy" value="${contratolocacao.datafinal}" /></td>
                    </tr>
                    <tr>
                        <td align="left" colspan="2"><b>Meses Contrato:</b> ${contratolocacao.mescontrato}</td>
                        <td align="left" colspan="2"><b>Dia Recebimento:</b> ${contratolocacao.diarecebimento}</td>
                        <td align="left" colspan="2"><b>Dia Pagamento:</b> ${contratolocacao.diapagamento}</td>
                        <td align="left" colspan="3"><b>Valor Total Contrato:</b> <fmt:formatNumber value="${contratolocacao.valortotalcontrato}" type="currency"/></td>
                    </tr>
                    <tr>   
                        <td colspan="3" align="left"><b>Valor Pago:</b> <fmt:formatNumber value="${contratolocacao.valorpago}" type="currency"/></td>                        
                        <td colspan="3" align="left"><b>Valor Juros/Multa Pago:</b> <fmt:formatNumber value="${contratolocacao.valorjurosmultapago}" type="currency"/></td>
                        <td colspan="3" align="left"><b>Valor Descontos:</b> <fmt:formatNumber value="${contratolocacao.valordescontos}" type="currency"/></td>
                    </tr>
                    <tr>
                        <td colspan="3" align="left"><b>Valor Recebido:</b> <fmt:formatNumber value="${contratolocacao.valorrecebido}" type="currency"/></td>
                        <td colspan="3" align="left"><b>Valor Juros/Multa Recebido:</b> <fmt:formatNumber value="${contratolocacao.valorjurosmultarecebido}" type="currency"/></td>
                        <td colspan="3" align="left"><b>Saldo Contrato:</b> <fmt:formatNumber value="${contratolocacao.saldocontrato}" type="currency"/></td>
                    </tr>                    
                    <tr>
                        <td colspan="9" align="center"><b>#####&nbsp;&nbsp;&nbsp;PARCELAS PAGAR&nbsp;&nbsp;&nbsp;#####</b></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th align="left">ID</th>
                        <th align="left">Nro. Parcela</th>
                        <th align="left">Data Vencimento</th>
                        <th align="left">Data Pagamento</th>
                        <th align="left">Valor Pagar</th>
                        <th align="left">Valor Descontos</th>
                        <th align="left">Valor Pago</th>
                        <th align="left">Valor Juros/Multa</th>
                        <th align="right">Situação</th>
                    </tr>
                    <c:forEach var="parcelapagar" items="${parcelapagars}">
                        <tr> 
                            <td align="left">${parcelapagar.idparcelapagar}</td>
                            <td align="left">${parcelapagar.nroparcela}</td>
                            <td align="left"><fmt:formatDate pattern="dd/MM/yyyy" value="${parcelapagar.datavencimento}" /></td>
                            <td align="left"><fmt:formatDate pattern="dd/MM/yyyy" value="${parcelapagar.datapagamento}" /></td>
                            <td align="right"><fmt:formatNumber value="${parcelapagar.valorpagar}" type="currency"/></td>
                            <td align="right"><fmt:formatNumber value="${parcelapagar.valordescontos}" type="currency"/></td>
                            <td align="right"><fmt:formatNumber value="${parcelapagar.valorpago}" type="currency"/></td>
                            <td align="right"><fmt:formatNumber value="${parcelapagar.valorjurosmulta}" type="currency"/></td>
                            <td align="left">${parcelapagar.situacao}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="9" align="center"><b>#####&nbsp;&nbsp;&nbsp;PARCELAS RECEBER&nbsp;&nbsp;&nbsp;#####</b></td>
                    </tr>
                    <tr>
                        <th align="left">#</th>
                        <th align="left">Nro. Parcela</th>
                        <th align="left">Data Vencimento</th>
                        <th align="left">Data Recebimento</th>
                        <th align="left">Valor Parcela</th>
                        <th align="left">Valor Recebido</th>
                        <th align="left">Valor Juros/Multa</th>
                        <th align="right" colspan="2">Situação</th>
                    </tr>
                    <c:forEach var="parcelareceber" items="${parcelarecebers}">
                        <tr> 
                            <td align="left">#</td>
                            <td align="left">${parcelareceber.nroparcela}</td>
                            <td align="left"><fmt:formatDate pattern="dd/MM/yyyy" value="${parcelareceber.datavencimento}" /></td>
                            <td align="left"><fmt:formatDate pattern="dd/MM/yyyy" value="${parcelareceber.datarecebimento}" /></td>
                            <td align="right"><fmt:formatNumber value="${parcelareceber.valorparcela}" type="currency"/></td>
                            <td align="right"><fmt:formatNumber value="${parcelareceber.valorrecebido}" type="currency"/></td>
                            <td align="right"><fmt:formatNumber value="${parcelareceber.valorjurosmulta}" type="currency"/></td>
                            <td align="left" colspan="2">${parcelareceber.situacao}</td>
                        </tr>
                    </c:forEach>
                      <tr>
                        <td colspan="9" align="center"><b>#####&nbsp;&nbsp;&nbsp;PARCELAS DESCONTOS&nbsp;&nbsp;&nbsp;#####</b></td>
                    </tr> 
                    <tr>
                        <th align="left">ID</th>
                        <th align="left">Nro. Parcela</th>
                        <th align="left" colspan="2">Tipo Desconto</th>
                        <th align="left">Data Lançamento</th>
                        <th align="left">Valor</th>
                        <th align="left" colspan="3">Descrição</th>
                    </tr>
                    <c:forEach var="parceladesconto" items="${parceladescontos}">
                        <tr> 
                            <td align="left">${parceladesconto.idparceladesconto}</td>
                            <td align="left">${parceladesconto.nroparcela}</td>
                            <td align="left" colspan="2">${parceladesconto.tipodesconto.descricao}</td>
                            <td align="left"><fmt:formatDate pattern="dd/MM/yyyy" value="${parceladesconto.datalancamento}" /></td>
                            <td align="right"><fmt:formatNumber value="${parceladesconto.valordesconto}" type="currency"/></td>
                            <td align="left" colspan="3">${parceladesconto.descricao}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>     

<script>
    $(document).ready(function () {
        console.log('entrei ready');
        //Carregamos a datatable
        //$("#datatable").Datatable({});
        $('#datatable').DataTable({
            "oLanguage": {
                "sProcessing": "Processando...",
                "sLenghtMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "Nenhum registro encontrado",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                "sInfoFiltered": "",
                "sInfoPostFix": "",
                "sSearch": "Buscar",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "Ultimo"

                }
            }
        });
        $('#datatable2').DataTable({
            "oLanguage": {
                "sProcessing": "Processando...",
                "sLenghtMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "Nenhum registro encontrado",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                "sInfoFiltered": "",
                "sInfoPostFix": "",
                "sSearch": "Buscar",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "Ultimo"

                }
            }
        });
    });

</script>

<%@include file="/footer.jsp"%>

