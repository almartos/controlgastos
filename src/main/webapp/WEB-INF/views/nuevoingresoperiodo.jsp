<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Editar Ingreso Page</title>
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

function pulsadoCerrar(){
	window.opener.location.reload(false);
	window.close();
}

</script>
<body>
<h1>
	Editar Ingreso
</h1>

<c:url var="addAction" value="/editaringresoperiodo2" ></c:url>

<form:form action="${addAction}" commandName="ingreso">

<table>
	<c:if test="${!empty ingreso.id}">
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
	<tr>
		<td>
			<form:label path="nombreIngreso">
				<spring:message text="Nombre ingreso"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombreIngreso" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="importeIngreso">
				<spring:message text="Importe"/>
			</form:label>
		</td>
		<td>
			<form:input path="importeIngreso" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="fijo">
				<spring:message text="Fijo"/>
			</form:label>
		</td>
		<td>
			<form:input path="fijo" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="idIngresoGlobal">
				<spring:message text="ID Ingreso Global"/>
			</form:label>
		</td>
		<td>
			<form:input path="idIngresoGlobal" />
		</td> 
	</tr>
	</c:if>
	
		<td colspan="2">
			<c:if test="${!empty ingreso.id}">
				<input type="submit"
					value="<spring:message text="Editar Ingreso"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<td><a href="javascript: pulsadoCerrar();" >Cerrar</a></td>
</body>
</html>
