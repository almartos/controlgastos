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
	
	window.opener.location.reload(false);
	window.close();
	
}

function editarGasto(id){
	window.open('/ControlGastos/editargastoperiodo/'+id,'','height=690,width=800,scrollbars=no,top=80,left=90');
}

function pulsadoNuevoGasto(){
	window.open('/ControlGastos/nuevogastoperiodo/'+idGastoGlobal,'','height=690,width=800,scrollbars=no,top=80,left=90');
	
	
}

</script>
<body>
<h1>
	Seleccionar Gastos
</h1>


<form:form action="/ControlGastos/grabarplantilla" name="formPlantilla" commandName="tipoIngreso">
<h3>Lista de Gastos </h3>
<c:if test="${!empty listGasto}">
	<table class="tg">
	<tr>
		<th width="80">Gasto ID</th>
		<th width="120">Nombre</th>
		<th width="120">Fijo</th>
		<th width="120">Importe</th>
		<th width="120">Editar</th>
		<th width="120">Borrar</th>
		<th width="120">Balance</th>
	</tr>
	<c:forEach items="${listGasto}" var="Gasto">
		<tr>
			<td><input type="checkbox" name="${Gasto.id}" value="${Gasto.id}" ></td>
			<td>${Gasto.nombreGasto}</td>
			
			<td>
			<c:choose>		
			<c:when test="${Gasto.fijo==true}">Si</c:when>
			<c:when test="${Gasto.fijo==false}">No</c:when> 
			</c:choose> 
			</td>
			
			<td>
			<c:choose>		
			<c:when test="${Gasto.fijo==true}">${Gasto.importeGasto}</c:when>
			<c:when test="${Gasto.fijo==false}">${Gasto.importeGasto} / ${Gasto.acumuladoHistorico}</c:when> 
			</c:choose> 
			</td>
			
			<td><a href="javascript:editarGasto(${Gasto.id})" >Editar gasto</a></td>
			<td><a href="/ControlGastos/borrargastoperiodo/${Gasto.id}" >Borrar gasto</a></td>
			
			<c:choose>		
			<c:when test="${Gasto.importeGasto > Gasto.acumuladoHistorico}"><td style="background: #66FF33"></td></c:when>
			<c:when test="${Gasto.importeGasto == Gasto.acumuladoHistorico}"><td style="background: #FFFF00"></td></c:when>
			<c:when test="${Gasto.importeGasto < Gasto.acumuladoHistorico}"><td style="background: #FF3300"></td></c:when> 
			</c:choose>
			
			
			<script>var idGastoGlobal=${Gasto.idGastoGlobal};</script>

		</tr>
	</c:forEach>
	</table>
</c:if>

<table class="tg">
	<tr>
		<th width="80"></th>
		<th width="120">Totales</th>
	</tr>
	<tr>
		<td>Presupuestado</td>
		<td>${totalPresupuestado}</td>
	</tr>
	
	<tr>
		<td>Gasto real</td>
		<td>${totalGastos}</td>
	</tr>
	
	
	</table>
</form:form>
<td><a href="javascript:pulsadoCerrar()" >Cerrar</a></td>
<td><a href="javascript:pulsadoNuevoGasto()" >Nuevo Gasto</a></td>
</body>
</html>
