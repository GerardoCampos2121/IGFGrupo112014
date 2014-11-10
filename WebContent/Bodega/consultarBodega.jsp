<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlBodega"%>
<%@ page import="sv.edu.ues.igf115.grupo11.dominio.Bodega"%>

<%
    String id_bodega = request.getParameter("id_bodega");
    
    CtrlBodega bod = new CtrlBodega();
    Bodega consultado = bod.consultarBodega(id_bodega);
    
    String mensaje="";
    if(consultado!=null){
    	mensaje += "<br>Codigo: "+consultado.getId_bodega()+"<br> Nombre: "+consultado.getNombre_bodega()+"<br>Direccion: "+consultado.getDireccion();
    }else{
    	mensaje="no existe";
    }    
    
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=mensaje %>
</body>
</html>