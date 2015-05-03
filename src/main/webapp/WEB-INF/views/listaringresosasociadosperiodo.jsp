<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Ingresos Asociados al Periodo</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<script type="text/javascript">
function pulsadoCerrar(){
	window.opener.location.reload(false);
	window.close();
	
}

function editarIngreso(id){
	window.open('http://localhost:8080/ControlGastos/editaringresoperiodo/'+id,'','height=690,width=800,scrollbars=no,top=80,left=90');
}

function pulsadoNuevoIngreso(){
	window.open('http://localhost:8080/ControlGastos/nuevoingresoperiodo/'+idIngresoGlobal,'','height=690,width=800,scrollbars=no,top=80,left=90');
	
	
}

</script>
<body>
<h1>
	Seleccionar Ingresos
</h1>


<form:form action="/ControlGastos/grabarplantilla" name="formPlantilla" commandName="tipoIngreso">
<h3>Lista de Ingresos </h3>
<c:if test="${!empty listIngreso}">
	<table class="tg">
	<tr>
		<th width="80">Ingreso ID</th>
		<th width="120">Nombre</th>
		<th width="120">Importe</th>
		<th width="120">Editar</th>
		<th width="120">Borrar</th>
	</tr>
	<c:forEach items="${listIngreso}" var="Ingreso">
		<tr>
			<td><input type="checkbox" name="${Ingreso.id}" value="${Ingreso.id}" ></td>
			<td>${Ingreso.nombreIngreso}</td>
			<td>${Ingreso.importeIngreso}</td>
			<td><a href="javascript:editarIngreso(${Ingreso.id})" >Editar ingreso</a></td>
			<td><a href="<c:url value='/borraringresoperiodo/${Ingreso.id}' />" >Borrar ingreso</a></td>
			
			<script>var idIngresoGlobal=${Ingreso.idIngresoGlobal};</script>

		</tr>
	</c:forEach>
	</table>
</c:if>
<table class="tg">
	<tr>
		<th width="80"></th>
		<th width="80">Total</th>
		
	</tr>
	<tr>
		<td>Ingresos</td>
		<td>${totalIngresos}</td>
	</tr>
	</table>
</form:form>
<td><a href="javascript:pulsadoCerrar()" >Cerrar</a></td>
<td><a href="javascript:pulsadoNuevoIngreso()" >Nuevo Ingreso</a></td>
</body>
</html>
