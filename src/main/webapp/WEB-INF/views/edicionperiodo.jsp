<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Editar Periodo Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<script type="text/javascript">
function editarIngresos(periodoId){
	window.open('/ControlGastos/listaringresoasociadoperiodo/'+periodoId,'','height=690,width=800,scrollbars=no,top=80,left=90');
}

function editarGastos(periodoId){
	
	window.open('/ControlGastos/listargastoasociadoperiodo/'+periodoId,'','height=690,width=800,scrollbars=no,top=80,left=90');
}

</script>
<body>
<h1>
	Editar Periodo
</h1>

<c:url var="addAction" value="/periodo/add" ></c:url>

<form:form action="${addAction}" commandName="periodo">

<table>
	<c:if test="${!empty periodo.id}">
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
			<form:label path="fechaIni">
				<spring:message text="Fecha de inicio"/>
			</form:label>
		</td>
		<td>
			<form:input type="date" path="fechaIni" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="fechaFin">
				<spring:message text="Fecha de fin"/>
			</form:label>
		</td>
		<td>
			<form:input type="date" path="fechaFin" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="activo">
				<spring:message text="Activo"/>
			</form:label>
		</td>
		<td>
			<form:input path="activo" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty periodo.id}">
				<input type="submit"
					value="<spring:message text="Editar Periodo"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista Periodos </h3>
<c:if test="${!empty listPeriodo}">
	<table class="tg">
	<tr>
		<th width="80">Periodo ID</th>
		<th width="120">F. Inicio</th>
		<th width="60">F. Fin</th>
		<th width="60">Editar</th>
		<th width="60">Borrar</th>
		<th width="60">Ingreso</th>
		<th width="60">Gasto</th>
		<th width="60">Balance</th>
	</tr>
	<c:forEach items="${listPeriodo}" var="periodo">
		<tr>
			<td>${periodo.id}</td>
			<td>${periodo.fechaIni}</td>
			<td>${periodo.fechaFin}</td>
			<td><a href="<c:url value='/editperiodo/${periodo.id}' />" >Editar</a></td>
			<td><a href="<c:url value='/removeperiodo/${periodo.id}' />" >Borrar</a></td>
			<td><a href="<c:url value='javascript:editarIngresos(${periodo.id})' />" >Editar ingresos</a></td>
			<td><a href="<c:url value='javascript:editarGastos(${periodo.id})' />" >Editar gastos</a></td>
			
			<c:choose>		
			<c:when test="${periodo.ingresosPeriodo > periodo.gastosPeriodo}"><td style="background: #66FF33">${periodo.ingresosPeriodo - periodo.gastosPeriodo}</td></c:when>
			<c:when test="${periodo.ingresosPeriodo == periodo.gastosPeriodo}"><td style="background: #FFFF00">${periodo.ingresosPeriodo - periodo.gastosPeriodo}</td></c:when>
			<c:when test="${periodo.ingresosPeriodo < periodo.gastosPeriodo}"><td style="background: #FF3300"><font style="color: #FFFFFF">${periodo.ingresosPeriodo - periodo.gastosPeriodo}</font></td></c:when> 
			</c:choose>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
<td><a href="<c:url value='/' />" >Atras</a></td>
</body>
</html>
