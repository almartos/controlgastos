<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Plantilla Ingreso Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<script type="text/javascript">

function nuevaPlantilla(){
	
	
	
	window.open('/ControlGastos/listargasto','','height=690,width=800,scrollbars=no,top=80,left=90');
}

</script>
<body>
<h1>
	Añadir una Plantilla de Gastos
</h1>

<c:url var="addAction" value="/plantillagasto/add" ></c:url>

<form:form action="${addAction}" commandName="plantillaGasto">
<table>
	<c:if test="${!empty plantillaGasto.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Nombre"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="nombreGasto">
				<spring:message text="Nombre Gasto"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombreGasto" />
		</td> 
		<td>
			<input type="button" onclick="javascript:nuevaPlantilla();" 
					value="<spring:message text="Seleccionar gastos"/>" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty plantillaGasto.name}">
				<input type="submit"
					value="<spring:message text="Editar Plantilla de Gasto"/>" />
			</c:if>
			<c:if test="${empty plantillaGasto.name}">
				<input type="submit"
					value="<spring:message text="Añadir Plantilla de Gasto"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de Plantillas de Gasto </h3>
<c:if test="${!empty listPlantillaGasto}">
	<table class="tg">
	<tr>
		<th width="80">Plantilla de Gasto ID</th>
		<th width="120">Nombre</th>
		<th width="120">Nombre Gasto</th>
		<th width="60">Editar</th>
		<th width="60">Borrar</th>
	</tr>
	<c:forEach items="${listPlantillaGasto}" var="plantillaGasto">
		<tr>
			<td>${plantillaGasto.id}</td>
			<td>${plantillaGasto.name}</td>
			<td>${plantillaGasto.nombreGasto}</td>
			<td><a href="<c:url value='/editplantillagasto/${plantillaGasto.id}' />" >Editar</a></td>
			<td><a href="<c:url value='/removeplantillagasto/${plantillaGasto.id}' />" >Borrar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<td><a href="<c:url value='/' />" >Atrás</a></td>
</body>
</html>
