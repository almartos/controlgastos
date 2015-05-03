<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Tipo Ingreso Page</title>
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

function grabarPlantilla(){
	
	document.formPlantilla.submit();
}
</script>
<body>
<h1>
	Seleccionar Gastos
</h1>


<form:form action="/ControlGastos/grabarplantillagastos" name="formPlantilla" commandName="tipoGasto">
<table>
	<tr>
		<td>
			Nombre plantilla
		</td>
		<td>
			<input type="text" name="nombre_plantilla">
		</td> 
	</tr>
</table>	
<br>
<h3>Lista de Tipos de Gasto </h3>
<c:if test="${!empty listTipoGasto}">
	<table class="tg">
	<tr>
		<th width="80">Tipo de Gasto ID</th>
		<th width="120">Nombre</th>
	</tr>
	<c:forEach items="${listTipoGasto}" var="tipoGasto">
		<tr>
			<td><input type="checkbox" name="${tipoGasto.name}" value="${tipoGasto.name}" ></td>
			<td>${tipoGasto.name}</td>

		</tr>
	</c:forEach>
	</table>
</c:if>
</form:form>
<td><a href="javascript:pulsadoCerrar()" >Cerrar</a></td>
<td><input type="button" onclick="javascript:grabarPlantilla();" value="<spring:message text="Grabar plantilla"/>" /></td>
</body>
</html>
