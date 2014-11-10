<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlCliente" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlTipoCliente" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.dominio.TipoCliente" %>
    
    <% 
    
    String idCliente = request.getParameter("idCliente");
    String nombCliente = request.getParameter("nombCliente");
    String apCliente = request.getParameter("apCliente");
    String domCliente = request.getParameter("domCliente");
    String telCliente = request.getParameter("telCliente");
    String e_mail = request.getParameter("e_mail");
    
    /*recuperamos tipo cliente*/
    String tipoc = request.getParameter("tipocliente");
    CtrlTipoCliente tipo = new CtrlTipoCliente();
    TipoCliente tipocliente = tipo.consultarTipoCliente(tipoc);
    
    /*vamos a programar guardar cliente*/
    CtrlCliente nuevoCliente = new CtrlCliente();
    
    
    String mensaje ="";
    boolean exito = nuevoCliente.ModificarCliente(idCliente, nombCliente, apCliente, domCliente, telCliente, e_mail, tipocliente);
    
    
    if(exito){
    	mensaje = "El nuevo Cliente ha sido modificado";
    }else{
    	mensaje = "El error te persigue";
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