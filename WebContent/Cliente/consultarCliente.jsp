<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlCliente" %>
    <%@ page import="sv.edu.ues.igf115.grupo11.dominio.Cliente" %>
    
    <%
        	String idCliente = request.getParameter("idCliente");
            
            CtrlCliente consulta = new CtrlCliente();
            
            Cliente buscado = consulta.daClienteById(idCliente);
            
            String mensaje="";
            
            if(buscado != null){
            			mensaje += "Codigo: " + buscado.getIdCliente()
        				+ "<br> Nombre: " + buscado.getNombCliente()
        				+ "<br>Apellido:" + buscado.getApCliente()
        				+ "<br>Domicilio:" + buscado.getDomCliente()
        				+ "<br>Telefono:" + buscado.getTelCliente()
        				+ "<br>Email:" + buscado.getE_mail()
        				+ "<br>TipoCliente:" + buscado.getTipocliente().getIdTipocliente();
        	} else {
        		mensaje ="Cliente no encontrado";
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