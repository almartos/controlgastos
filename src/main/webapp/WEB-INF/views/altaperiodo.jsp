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

function grabarPeriodo(){
	
	document.formAltaPeriodo.submit();
}
</script>
<body>
<h1>
	Alta de Periodo
</h1>


<form:form action="/ControlGastos/grabarperiodo" name="formAltaPeriodo" commandName="altaPeriodo">
<table>
	<tr>
		<td>
			Fecha de Inicio
		</td>
		<td>
			<input type="text" name="fecha_inicio">
		</td> 
		<td>
			Fecha de Fin
		</td>
		<td>
			<input type="text" name="fecha_fin">
		</td> 
		<td>
			Activo
		</td>
		<td>
			<SELECT name="ACTIVO">
                <option value="true">Si</option>
                <option value="false">No</option>
              </SELECT>
		</td> 
	</tr>
	<tr>
		<td>
			Total Ingresos
		</td>
		<td>
			<input type="text" name="total_ingreso">
		</td> 
		<td>
			Total Gastos
		</td>
		<td>
			<input type="text" name="total_gasto">
		</td>  
	</tr>
	<tr>
		<td>
			Plantilla Ingreso
		</td>
		<td>
			<SELECT name="plantillaIngreso">
			<c:forEach items="${listDistinctPlantillaIngreso}" var="nombrePlantilla">
			<option value="${nombrePlantilla}">${nombrePlantilla}</option>
			</c:forEach>
			</SELECT>
		</td> 
		<td>
			Plantilla Gasto
		</td>
		<td>
			<SELECT name="plantillaGasto">
			<c:forEach items="${listDistinctPlantillaGasto}" var="nombrePlantilla">
			<option value="${nombrePlantilla}">${nombrePlantilla}</option>
			</c:forEach>
			</SELECT>
		</td>  
	</tr>
</table>	
<br>
</form:form>
<td><a href="<c:url value='/' />" >Atrás</a></td>&nbsp;&nbsp;&nbsp;&nbsp;
<td><input type="button" onclick="javascript:grabarPeriodo();" value="<spring:message text="Grabar periodo"/>" /></td>
</body>
</html>
