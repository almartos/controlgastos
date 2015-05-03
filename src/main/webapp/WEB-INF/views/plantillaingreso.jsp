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
	
	
	
	window.open('http://localhost:8080/ControlGastos/listaringreso','','height=690,width=800,scrollbars=no,top=80,left=90');
}

</script>
<body>
<h1>
	Añadir una Plantilla de Ingresos
</h1>

<c:url var="addAction" value="/plantillaingreso/add" ></c:url>

<form:form action="${addAction}" commandName="plantillaIngreso">
<table>
	<c:if test="${!empty plantillaIngreso.name}">
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
			<form:label path="nombreIngreso">
				<spring:message text="Nombre Ingreso"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombreIngreso" />
		</td> 
		<td>
			<input type="button" onclick="javascript:nuevaPlantilla();" 
					value="<spring:message text="Seleccionar ingresos"/>" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty plantillaIngreso.name}">
				<input type="submit"
					value="<spring:message text="Editar Plantilla de Ingreso"/>" />
			</c:if>
			<c:if test="${empty plantillaIngreso.name}">
				<input type="submit"
					value="<spring:message text="Añadir Plantilla de Ingreso"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de Plantillas de Ingresos </h3>
<c:if test="${!empty listPlantillaIngreso}">
	<table class="tg">
	<tr>
		<th width="80">Plantilla de Ingreso ID</th>
		<th width="120">Nombre</th>
		<th width="120">Nombre Ingreso</th>
		<th width="60">Editar</th>
		<th width="60">Borrar</th>
	</tr>
	<c:forEach items="${listPlantillaIngreso}" var="plantillaIngreso">
		<tr>
			<td>${plantillaIngreso.id}</td>
			<td>${plantillaIngreso.name}</td>
			<td>${plantillaIngreso.nombreIngreso}</td>
			<td><a href="<c:url value='/editplantillaingreso/${plantillaIngreso.id}' />" >Editar</a></td>
			<td><a href="<c:url value='/removeplantillaingreso/${plantillaIngreso.id}' />" >Borrar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<td><a href="<c:url value='/' />" >Atrás</a></td>
</body>
</html>
