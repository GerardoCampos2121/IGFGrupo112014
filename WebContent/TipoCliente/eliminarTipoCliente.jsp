<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlTipoCliente" %>
    
    <%
    
    /*parametros*/
    String id_tipocliente = request.getParameter("id_tipocliente");
    
    CtrlTipoCliente tipo = new CtrlTipoCliente();
    
    boolean exito = tipo.elminarTipoCliente(id_tipocliente);
    
    String mensaje="";
    if(exito){
    	mensaje = "El Tipo de Cliente ha sido Eliminado Exitosamente";
    }
    else{
    	mensaje = "El Tipo de cliente no existe o no se puede eliminar";    	
    }
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>
<%=mensaje %></h3>
</body>
</html>