<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>


<div class="col-md-12 fixed-top" style="height: 175px; background-color: #212529; margin-top: 50px" >
    <div class="row col-md-12" style="margin-top: 15px">
        <label class="col-md-12" style="background-color: #212529; color: white; font-size: 16px">Casdastro De Tipo Imóvel</label>
    </div>
    <div class="col-md-12 row">
        <div class="col-md-4" style="color: white">
            <label>Id</label>
        </div>
        <div class="col-md-8" style="color: white">
            <label>Decrição</label>
        </div>
    </div>
    <div class="col-md-12 row">
        <div class="col-md-4">
            <input class="form-control" type="text" name="idtipoimovelC" id="idtipoimovelC" 
            value="${tipoImovel.idtipoimovel}" size="100" maxlength="100">
        </div>
        <div class="col-md-8">
            <input class="form-control" type="text" name="descricaoC" id="descricaoC" 
            value="${despesa.descricao}" size="100" maxlength="100">
        </div>
    </div>
    <div class="col-md-12 row" style="margin-top: 10px">
        <div class="col-md-8"></div>
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
                        <a href="#" id="deletar" title="Excluir" onclick="deletar(${tipoImovel.idTipoImovel})">
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
   <%--$(document).ready(function(){
       console.log('entrei ready');
       //caregamos a datatable
       //$("#datatable").DataTable({});
       $('#datatable').DataTable({
           "OLanguage": {
               "sProcessing": "Processando...",
               "sLengthMenu": "Mostrar _MENU_ registros",
               "sZeroRecords": "Nenhum registro encontrado.",
               "sInfo": "Mostrando de _START_ até_END_de_TOTAL_registros",
               "sInfoEmpty": "Mostrando de 0 até 0 de registros",
               "sInfoFiltered": "",
               "sInfoPostFix": "",
               "sSearch": "Buscar:",
               "sUrl": "",
               "oPaginate": {
                   "sFirst": "Primeiro",
                   "sPrevious": "Anterior",
                   "sNext": "Seguinte",
                   "sLast": "Ultimo"
               }
           }
       });
   });--%>

    function validarCampos() {
        console.log("entrei na validação de campos");
        if (document.getElementById("idtipoimovelC").value === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Verifique a id do imóvel!',
                showConfirmButton: false,
                timer: 1000
            });
            $("#idtipoimovelC").focus();
        } else if (document.getElementById("descricaoC").value === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Verifique a descrição do tipo do imóvel!',
                showConfirmButton: false,
                timer: 1000
            });
            $("#descricaoC").focus();
        } else {
            gravarDados();
        }
    }

    function gravarDados() {
        console.log("Gravando dados ....");        
        $.ajax({
            type: 'post',
            url: 'TipoImovelCadastrar',
            data: {
                idtipoimovel: $('#idtipoimovelC').val(),
                descricao: $('#descricaoC').val()
            },
            success:
                    function (data) {
                        console.log("reposta servlet->");
                        console.log(data);
                        if (data === 1) {
                            Swal.fire({
                                position: 'center',
                                icon: 'success',
                                title: 'Sucesso',
                                text: 'Tipo Imóvel gravada com sucesso!',
                                showConfirmButton: true,
                                timer: 10000
                            }).then(function(){
                                window.location.href = "${pageContext.request.contextPath}/TipoImovelListar";
                            });
                        } else {
                            Swal.fire({
                                position: 'center',
                                icon: 'error',
                                title: 'Erro',
                                text: $('#descricaoC').val(),
                                showConfirmButton: true,
                                timer: 10000
                            }).then(function(){
                                window.location.href = "${pageContext.request.contextPath}/TipoImovelListar";
                            });
                        }
                    },
            error:
                    function (data) {
                        window.location.href = "${pageContext.request.contextPath}/TipoImovelListar";
                    }
        });
    }
    
    function deletar(codigo){
        var id = codigo;
        console.log(codigo);
        Swal.fire({
            title: 'Você tem certeza?',
            text: "Você não podera recuperar depois!",
            icon: 'Warning',
            showCancelbutton: True,
            confirmbuttonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sim, apague a Tipo Imovel!',
            cancelButtonText: 'Cancelar'
            }).then((result) => {
            if (result.isConfirmed){
                $.ajax({
                    type: 'post',
                    url: '${pageContext.request.contextPath}/TipoImovelExcluir',
                    data:{
                        idDespesa: id
            },
            success:
                function(data){
                    if(data === 1){
                        Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Sucesso',
                            text: 'Tipo Imovel excluida com sucesso!',
                            showConfirmButton: False,
                            timer: 2000
                        });
                    }
                        window.location.href = "${pageContext.request.contextPath}/TipoImoveListar";
                    },
                    error:
                        function(data){
                        window.location.href = "${pageContext.request.contextPath}/TipoImoveListar";
                    }
                });
            };
        });
    }
    function alterar(id){
       console.log(id);
       
    $.ajax({
       type: 'post',
       url: 'TipoImovelCarregar',
       data:{idTipoImovel: id},
       success:
               function (data){
                   console.log("data");
                   console.log(data);
                   if (data > 0 ){
                     document.getElementById("estado").innerHTML = data;
                   };
               }
    }); 
   };
</script>
    
<%@ include file="/footer.jsp" %>


