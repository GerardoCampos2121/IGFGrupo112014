<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlTipoCliente"%>
<%@ page import="sv.edu.ues.igf115.grupo11.dominio.TipoCliente"%>

<%
	String id_tipocliente = request.getParameter("id_tipocliente");

	CtrlTipoCliente consulta = new CtrlTipoCliente();
	TipoCliente buscado = consulta.consultarTipoCliente(id_tipocliente);

	String mensaje = "";
	if (buscado != null) {
		mensaje += ("<br>Codigo: " + buscado.getIdTipocliente()
				+ "<br>Descripcion: " + buscado.getDesp()
				+ "<br>Descuento: " + buscado.getDesc());
	} else {
		mensaje="Tipo de Cliente no encontrado!";
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%=mensaje%>
</body>
</html>