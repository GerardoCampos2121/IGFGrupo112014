<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="sv.edu.ues.igf115.grupo11.negocio.CtrlTipoCliente"%>
    <%@ page import="sv.edu.ues.igf115.grupo11.dominio.TipoCliente"%>
    <%@ page import="java.math.BigDecimal;" %>
    
    <%
    /*Capturar datos*/
    String id_tipocliente = request.getParameter("id_tipocliente");
    String descripcion = request.getParameter("descripcion");
    BigDecimal descuento = new BigDecimal(request.getParameter("descuento"));
    
    CtrlTipoCliente tp = new CtrlTipoCliente();
    
    boolean exito = tp.modificarTipoCliente(id_tipocliente, descripcion, descuento);
    String mensaje="";
    if(exito){
    	mensaje ="Actualizado!";
    }else{
    	mensaje ="El error te persigue!";
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