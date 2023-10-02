<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="ContratoCadastrar" action="ContratoCadastrar" method="POST">
<div class="col-md-12 fixed-top" style="height: 310px; background-color: #212529; margin-top: 50px" >
    <div class="row col-md-12" style="margin-top: 15px">
        <h3 style="background-color: #212529; color: white; text-align: center;">Contrato</h3>
    </div>
    <div class="col-md-12"></div>
    
    <div class="col-md-1" hidden="true">
            <input class="form-control" type="text" name="idContratoLocacao" id="idContratoLocacaoC" 
            value="${contratoLocacao.idContrato}" size="100" maxlength="100">
     </div>
   
     <div class="form-row">
         
         <div class="col">
            <div class=" form-group">
                <label for="DataContrato" style="color: white">Data Contrato</label>
                <input class="form-control" type="date" name="dataContratoC" id="DataContrato" 
                    value="${contratoLocacao.dataContrato}"  maxlength="100">
            </div>
         </div>  
            
            <div class="col">
                <div class=" form-group ">
                     <label for="DataInicio" style="color: white">Data Inicio</label>
                      <input class="form-control" type="date" name="dataInicioC" id="DataInicio" 
                        value="${contratoLocacao.dataInicio}" maxlength="100">
                </div>
            </div>
                
                <div class="col">
                    <div class="form-group ">
                        <label for="DataFinal" style="color: white;">Data Final</label>
                          <input class="form-control" type="date" name="dataFinalC" id="DataFinal" 
                           value="${contratoLocacao.dataFinal}" maxlength="100">
                    </div>
                </div>
                    
                    <div class="col">
                        <div class="form-group">
                            <label for="DiaRecebimento"  style="color: white;"> Dia Recebimento</label>
                            <input class="form-control" type="text" name="diaRecebimentoC" id="DiaRecebimento" 
                            value="${contratoLocacao.diaRecebimento}"  maxlength="2">
                        </div>
                    </div>
                        
                        <div class="col">
                            <div class="form-group">
                                <label for="DiaPagamento" style="color: white;">Dia Pagamento</label>
                                 <input class="form-control" type="text" name="diaPagamentoC" id="DiaPagamento" 
                                 value="${contratoLocacao.diaPagamento}"  maxlength="2">
                            </div>
                        </div>
                            
                            <div class="col">
                                <div class="form-group">
                                    <label for="Imovel" style="color: white;">Imovel</label>
                                    <select  class="form-control" name="Imovel" id="Imovel" onchange="GetInfoImovel(this)">
                                        <option value="">[Nenhum]</option>
                                        <c:forEach var="imovel" items="${imoveis}">
                                            <option value="${imovel.idImovel}"
                                                    ${contratoLocacao.imovel.idImovel  ==  imovel.idImovel ? "selected" : ""}>
                                                    ${imovel.descricao} 
                                            </option>
                                        </c:forEach>
                                </select>
                                </div>
                            </div>
                            
                            <div class="col">
                                <div class="form-group">
                                    <label for="Locatario" style="color: white;">Locatario</label>
                                    <select class="form-control"  type="text" name="Locatario" id="Locatario">
                                        <option value="">[Nenhum]</option>
                                        <c:forEach var="locatario" items="${locatarios}">
                                            <option value="${locatario.idLocatario}" 
                                                    ${contratoLocacao.locatario.idLocatario ==  locatario.idLocatario ? "selected" : ""}>
                                                    ${locatario.nome}
                                            </option>
                                        </c:forEach>
                                </select>
                                </div>
                            </div> 
     </div>
<div class="col-md-12"></div>

<div class="form-row">
    
    <div class="col">
        <div class="form-group"> 
        <label for="Locador" style="color: white;">Locador</label>
        <select class="form-control"  type="text" name="Locador" id="Locador" >
                <option value="">[Nenhum]</option>
                <c:forEach var="locador" items="${locadores}">
                    <option value="${locador.idLocador}" 
                            ${contratoLocacao.locador.idLocador == locador.idLocador ? "selected" : ""}>
                            ${locador.nome}
                    </option>
                </c:forEach>
            </select>
        </div>
    </div>
    
    <div class="col">
        <div class="form-group">
            <label for="MesesContrato" style="color: white;">Meses</label>
             <input class="form-control  text-center" type="text" name="mesesContratoC" id="mesesContratoC" 
                    value="${contratoLocacao.mesesContrato}0" maxlength="100" disabled="true">
        </div>
    </div>
        
        <div class="col">
            <div class="form-group">
                <label for="ValorTotalContrato" style="color: white;"> Valor Total</label>
                <input class="form-control  text-center" name="ValorTotalContrato" id="ValorTotalContrato"  value=" <fmt:formatNumber value='${contratoLocacao.ValorTotalContrato}0' type='currency'/>" disabled="true">
            </div>
        </div>
            
         <div class="col">
            <div class="form-group">
                <label for="ValorRecebido" style="color: white;"> Valor Recebido</label>
                <input class="form-control  text-center" type="currency" name="ValorRecebido" id="ValorRecebido" value="${contratoLocacao.valorRecebido}0" disabled="true">
            </div>
        </div>
            
         <div class="col">
            <div class="form-group">
                <label for="ValorDescontos" style="color: white;"> Valor Descontos</label>
                <input class="form-control  text-center" type="currency" name="ValorDescontos" id="ValorDescontos" value="${contratoLocacao.valorDescontos}0" disabled="true">
            </div>
        </div>
            
        <div class="col">
            <div class="form-group">
                <label for="ValorPago" style="color: white;"> Valor Pago</label>
                <input class="form-control text-center" type="currency" name="ValorPago" id="ValorPago" value="${contratoLocacao.valorPago}0" disabled="true">
            </div>
        </div>
            
</div>
<div class="col-md-12"></div>

<div class="form-row">
    
    <div class="col">
        <div class="form-group">
            <label for="ValorJurosMultaRecebido" style="color: white;">Valor Juros Recebido</label>
             <input class="form-control text-center" type="currency" name="ValorJurosMultaRecebido" id="ValorJurosMultaRecebido" value="${contratoLocacao.valorJurosMultaRecebido}0" disabled="true">
        </div>
    </div>
        
     <div class="col">
        <div class="form-group">
            <label for="ValorJurosMultaPago" style="color: white;">Valor Juros Pago</label>
             <input class="form-control text-center" type="currency" name="ValorJurosMultaPago" id="ValorJurosMultaPago" value="${contratoLocacao.valorJurosMultaPago}0" disabled="true">
        </div>
    </div>
        
    <div class="col">
        <div class="form-group">
            <label for="SaldoContrato" style="color: white;">Saldo Contrato</label>
             <input class="form-control text-center" type="currency" name="SaldoContrato" id="SaldoContrato" value="${contratoLocacao.saldoContrato}0" disabled="true">
        </div>
    </div>
       
        <div class="col">
            <div class="form-group" style="margin-top: 25px;">
                <button class="btn btn-success btn-lg" type="button" style="margin-left:90px; margin-right: 50px;"onclick="IncluirAlterar()" >+</button>
                <button class="btn btn-danger  btn-lg" type="button"  onclick="">Excluir</button>
            </div>
        </div>
    
</div>


</div>
</form>
    
 <div class="table-responsive" style="margin-top: 360px;">
    <table class="table table-sm table-bordered"  id="datatable" class="display">
        <thead>
            <tr>
                <th scope="col " style="text-align: center">Id</th>
                <th scope="col" style="text-align: center">Data Contrato</th>
                <th scope="col" style="text-align: center">Data Inicio</th>
                <th scope="col" style="text-align: center">Data Final</th>
                <th scope="col" style="text-align: center">Meses</th>
                <th scope="col" style="text-align: center">Imovel</th>
                <th scope="col "style="text-align: center" >Locador</th>
                <th scope="col" style="text-align: center">Locatario</th>
                <th scope="col" style="text-align: center">Dia Recebimento</th>
                <th scope="col" style="text-align: center"> Dia Pagamento</th>
                <th scope="col" style="text-align: center">Total</th>
                <th scope="col" style="text-align: center">Recebido</th>
                <th scope="col" style="text-align: center">Descontos</th>
                <th scope="col" style="text-align: center">Pago</th>
                <th scope="col" style="text-align: center">Multa Recebido</th>
                <th scope="col" style="text-align: center">Multa Pago</th>
                <th scope="col" style="text-align: center">Saldo</th>
                <th scope="col"></th>
            </tr>
        </thead>
     <tbody>
         <c:forEach var="Contrato" items="${contratos}">
             <tr scope="row">
                 <td style="text-align: center">${Contrato.idContrato}</td>
                 <td style="text-align: center">${Contrato.dataContrato}</td>
                 <td style="text-align: center">${Contrato.dataInicio}</td>
                 <td style="text-align: center">${Contrato.dataFinal}</td>
                 <td style="text-align: center">${Contrato.mesesContrato}</td>
                 <td style="text-align: center">${Contrato.idImovel.descricao}</td>
                 <td style="text-align: center">${Contrato.idLocador.nome}</td>
                 <td style="text-align: center">${Contrato.idLocatario.nome}</td>
                 <td style="text-align: center">${Contrato.diaRecebimento}</td>
                 <td style="text-align: center">${Contrato.diaPagamento}</td>
                 <td style="text-align: center">${Contrato.valorTotalContrato}</td>
                 <td style="text-align: center">${Contrato.valorRecebido}</td>
                 <td style="text-align: center">${Contrato.valorDescontos}</td>
                 <td style="text-align: center">${Contrato.valorPago}</td>
                 <td style="text-align: center">${Contrato.valorJurosMultaRecebido}</td>
                 <td style="text-align: center">${Contrato.valorJurosMultaPago}</td>
                 <td style="text-align: center">${Contrato.saldoContrato}</td>
                 <td>  <a href="#" onclick="Alterar(${Contrato.idContrato})">
                            <button class="btn btn-group-sm btn-info"/>Alterar</button>
                        </a></td>
             </tr>
         </c:forEach>
     </tbody>
</table>
</div>
  
 <script>
       $(document).ready(function(){
            console.log('entrei ready');
           
             $("#ValorTotalContrato").maskMoney({
            prefix: 'R$',
            suffix: '',
            allowZero: false,
            allowNegative: true,
            allowEmpty: false,
            doubleClickSelection: true,
            selectAllOnFocus: true,
            thousands: '.',
            decimal: ",",
            precision: 2,
            affixesStay: true,
            bringCareAtEndOnFocus: true
        });
        
        $("#ValorRecebido").maskMoney({
            prefix: 'R$',
            suffix: '',
            allowZero: false,
            allowNegative: true,
            allowEmpty: false,
            doubleClickSelection: true,
            selectAllOnFocus: true,
            thousands: '.',
            decimal: ",",
            precision: 2,
            affixesStay: true,
            bringCareAtEndOnFocus: true
        });
        
         $("#ValorDescontos").maskMoney({
            prefix: 'R$',
            suffix: '',
            allowZero: false,
            allowNegative: true,
            allowEmpty: false,
            doubleClickSelection: true,
            selectAllOnFocus: true,
            thousands: '.',
            decimal: ",",
            precision: 2,
            affixesStay: true,
            bringCareAtEndOnFocus: true
        });
        
         $("#ValorPago").maskMoney({
            prefix: 'R$',
            suffix: '',
            allowZero: false,
            allowNegative: true,
            allowEmpty: false,
            doubleClickSelection: true,
            selectAllOnFocus: true,
            thousands: '.',
            decimal: ",",
            precision: 2,
            affixesStay: true,
            bringCareAtEndOnFocus: true
        });
        
         $("#ValorJurosMultaRecebido").maskMoney({
            prefix: 'R$',
            suffix: '',
            allowZero: false,
            allowNegative: true,
            allowEmpty: false,
            doubleClickSelection: true,
            selectAllOnFocus: true,
            thousands: '.',
            decimal: ",",
            precision: 2,
            affixesStay: true,
            bringCareAtEndOnFocus: true
        });
        
         $("#ValorJurosMultaPago").maskMoney({
            prefix: 'R$',
            suffix: '',
            allowZero: false,
            allowNegative: true,
            allowEmpty: false,
            doubleClickSelection: true,
            selectAllOnFocus: true,
            thousands: '.',
            decimal: ",",
            precision: 2,
            affixesStay: true,
            bringCareAtEndOnFocus: true
        });
        
         $("#SaldoContrato").maskMoney({
            prefix: 'R$',
            suffix: '',
            allowZero: false,
            allowNegative: true,
            allowEmpty: false,
            doubleClickSelection: true,
            selectAllOnFocus: true,
            thousands: '.',
            decimal: ",",
            precision: 2,
            affixesStay: true,
            bringCareAtEndOnFocus: true
        });
        
        });
        
        
        var idImovel = 0;
    function IncluirAlterar(){
        console.log("AAAAAAAAAAAA");
        var id = $('idContratoLocacaoC').val();
        var idContrato = 0;
        
        if(id > 0){
           idContrato = id;
        }
        
        console.log($('#ValorTotalContrato').val());
        
       $.ajax({
       type:'post',
       url: 'ContratoCadastrar',
       data:{
           idContrato:  idContrato,
           DataContrato: $('#DataContrato').val(),
           DataInicio: $('#DataInicio').val(),
           DataFinal: $('#DataFinal').val(),
           MesesContrato: $('#mesesContratoC').val(),
           DiaRecebimento: $('#DiaRecebimento').val(),
           DiaPagamento: $('#DiaPagamento').val(),
           ValorTotal: $('#ValorTotalContrato').val(),
           ValorRecebido: $('#ValorRecebido').val(),
           ValorDesconto: $('#ValorDescontos').val(),
           ValorPago: $('#ValorPago').val(),
           ValorJurosMultaRecebido: $('#ValorJurosMultaRecebido').val(),
           ValorJurosMultaPago: $('#ValorJurosMultaPago').val(),
           SaldoContrato: $('#SaldoContrato').val(),
           Imovel: idImovel,
           Locador:  $('#Locador').val(),
           Locatario: $('#Locatario').val()
       },
       success:
               function (data){
                   console.log("data");
                   console.log(data);
               }
    }); 
    }
    
    function GetInfoImovel(element){
        const id = element.value;
        idImovel = id;
        console.log(id);
       $.ajax({
       type:'post',
       url: 'ImovelCarregar',
       data:{idImovel: id},
       success:
               function (data){
                   const Imovel = JSON.parse(data);
                   $('#ValorTotalContrato').val(Imovel.valorAluguel);
                    $('#Locador').val(Imovel.idLocador).change();
                     
               }
    }); 
    }
    
    function Alterar(id){
        $.ajax({
           type:'post',
           url:'ContratoLocacaoCarregar',
           data:{idContrato: id},
           success:
                   function(data){
                       console.log(data);
                       const C = JSON.parse(data);
                       console.log(C.locatario);
                   }
                
        });
    }
</script>
             
<%@ include file="/footer.jsp" %>

