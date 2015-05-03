<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Editar Gasto Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<script type="text/javascript">

function pulsadoApunte(idGasto){
	
	window.open('/ControlGastos/listarapuntesasociadogasto/'+idGasto,'','height=690,width=800,scrollbars=no,top=80,left=90');
}

function pulsadoCerrar(){
	window.opener.location.reload(false);
	window.close();
}


</script>
<body>
<h1>
	Editar Gasto
</h1>

<c:url var="addAction" value="/editargastoperiodo2" ></c:url>

<form:form action="${addAction}" commandName="gasto">

<table>
	<c:if test="${!empty gasto.id}">
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
			<form:label path="nombreGasto">
				<spring:message text="Nombre gasto"/>
			</form:label>
		</td>
		<td>
			<form:input path="nombreGasto" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="importeGasto">
				<spring:message text="Importe"/>
			</form:label>
		</td>
		<td>
			<form:input path="importeGasto" />
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
			<form:label path="idGastoGlobal">
				<spring:message text="ID Gasto Global"/>
			</form:label>
		</td>
		<td>
			<form:input path="idGastoGlobal" />
		</td> 
	</tr>
	</c:if>
	
		<td colspan="2">
			<c:if test="${!empty gasto.id}">
				<input type="submit"
					value="<spring:message text="Editar Gasto"/>" />
			</c:if>
		</td>
		
		<c:choose>		
			<c:when test="${gasto.fijo==false}"><td><a href="javascript: pulsadoApunte(${gasto.id});" >Apunte</a></td></c:when>
			<c:when test="${gasto.fijo==true}"><td></td></c:when> 
		</c:choose>
		
		
	</tr>
</table>	
</form:form>
<br>
<td><a href="javascript: pulsadoCerrar();" >Cerrar</a></td>
</body>
</html>
