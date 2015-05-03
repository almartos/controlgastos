<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Gastos Asociados al Periodo</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<script type="text/javascript">
function pulsadoCerrar(){
	
	window.close();
	
}

function editarGasto(id){
	window.open('http://localhost:8080/ControlGastos/editargastoperiodo/'+id,'','height=690,width=800,scrollbars=no,top=80,left=90');
}

function nuevaLinea(){
	
	
		
		document.formAltaLinea.submit();
	
	
}

</script>
<body>
<h1>
	Histórico de Gastos
</h1>



<h3>Histórico de Gastos: ${nombreGasto} </h3>
<h4>Presupuestado: ${importeGasto} / Total: ${totalGasto}</h4>
<c:if test="${!empty listApunteAsociadoGasto}">
	<table class="tg">
	<tr>
		<th width="80">Fecha</th>
		<th width="120">Concepto</th>
		<th width="120">Cantidad</th>
		<th width="120">Eliminar</th>
	</tr>
	<c:forEach items="${listApunteAsociadoGasto}" var="Gasto">
		<tr>
			<td>${Gasto.fechaGasto}</td>
			<td>${Gasto.conceptoGasto}</td>
			<td>${Gasto.importeGasto}</td>			
			<td><a href="/ControlGastos/eliminarlineahistoricogasto/${Gasto.id}" >Eliminar</a></td>
		</tr>
	</c:forEach>
	
	</table>
	
	<br>
	<br>
</c:if>

<c:url var="addAction" value="/nuevoapuntegast	o" ></c:url>

<form:form action="${addAction}"  name="formAltaLinea" commandName="historicoGasto">
<tr>

<td>Fecha: <input type="text" name="fechaGasto"></td>
<td>Concepto: <input type="text" name="conceptoGasto"></td>
<td>Importe: <input type="text" name="importeGasto"></td>	
<td><input type="hidden" name="idGasto" value="${idGasto}"></td>
<td><input type="hidden" name="acumuladoHistorico" value="${totalGasto}"></td>
<td><a href="javascript:nuevaLinea()" >Añadir</a></td>
	


	
<tr>	

</form:form>
<td><a href="javascript:pulsadoCerrar()" >Cerrar</a></td>
</body>
</html>
