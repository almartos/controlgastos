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

function pulsadoNuevoGasto(){
	window.open('http://localhost:8080/ControlGastos/nuevogastoperiodo/'+idGastoGlobal,'','height=690,width=800,scrollbars=no,top=80,left=90');
	
	
}

</script>
<body>
<h1>
	Histórico de Ingresos
</h1>


<form:form action="/ControlGastos/nuevoapunteingreso" name="formPlantilla" commandName="tipoIngreso">
<h3>Histórico de Ingresos: ${nombreIngreso} </h3>
<c:if test="${!empty listApunteAsociadoIngreso}">
	<table class="tg">
	<tr>
		<th width="80">Fecha</th>
		<th width="120">Concepto</th>
		<th width="120">Cantidad</th>
		<th width="120">Añadir</th>
		<th width="120">Eliminar</th>
	</tr>
	<c:forEach items="${listApunteAsociadoIngreso}" var="Ingreso">
		<tr>
			<td><input type="date" name="${Ingreso.fechaIngreso}" value="${Ingreso.fechaIngreso}" ></td>
			<td>${Ingreso.conceptoIngreso}</td>
			<td>${Ingreso.importeIngreso}</td>
			<td><a href="javascript:nuevaLinea(${Ingreso.idIngreso})" >+</a></td>
			<td><a href="/ControlGastos/eliminarlineahistoricoingreso/${Ingreso.id}" >-</a></td>

		</tr>
	</c:forEach>
	</table>
</c:if>

<table class="tg">
	<tr>
		<th width="80">Total</th>
		<th width="120">${totalIngreso}</th>
	</tr>
	</table>
	
<table class="tg">
	<tr>
		<th width="80">Presupuestado</th>
		<th width="120">${importeIngreso}</th>
	</tr>
	</table>
</form:form>
<td><a href="javascript:pulsadoCerrar()" >Cerrar</a></td>
</body>
</html>
