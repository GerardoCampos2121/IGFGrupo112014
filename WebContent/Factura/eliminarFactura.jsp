<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="sv.edu.ues.igf115.grupo11.negocio.*" %>    
    
    <%
    String idFactura = request.getParameter("idFactura");
    
    CtrlFactura factura = new CtrlFactura();
    
    boolean exito = factura.eliminarFactura(idFactura);
    
    String mensaje="";
    
    if(exito){
    	mensaje="Factura eliminada";
    }else{
    	mensaje="el error te persigue";
    }
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%= mensaje %>
</body>
</html>