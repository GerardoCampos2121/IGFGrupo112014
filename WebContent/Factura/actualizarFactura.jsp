<%@ page import="sv.edu.ues.igf115.grupo11.negocio.*" %>
<%@ page import="sv.edu.ues.igf115.grupo11.utilidades.*" %>
<%@ page import="sv.edu.ues.igf115.grupo11.dominio.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.text.SimpleDateFormat"%>

    
    <%
    String idFactura = request.getParameter("idFactura");
    String fechaFacturaS = request.getParameter("fechaFactura");
    BigDecimal ventaTotal = new BigDecimal(request.getParameter("ventaTotal"));
    String idCliente = request.getParameter("idCliente");
    String idTipoVta = request.getParameter("idTipoVta");
    
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaFactura = null; //iniciamos fecha
    fechaFactura = formatoDelTexto.parse(fechaFacturaS);

    
    CtrlFactura fac = new CtrlFactura();
    CtrlCliente c = new CtrlCliente();
    CtrlTipoVta t = new CtrlTipoVta();
    
    Cliente cliente = new Cliente();
    TipoVta tipoVta = new TipoVta();
    
    cliente = c.daClienteById(idCliente);
    tipoVta = t.daTipoVentaById(idTipoVta);

    boolean exito = fac.modificarFactura(idFactura, fechaFactura, ventaTotal, cliente, tipoVta);
    
    String mensaje="";
    
    if(exito){
    	mensaje ="Factura modificada exitosamente!";
    }else{
    	mensaje ="No se pudo modificar la factura";
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