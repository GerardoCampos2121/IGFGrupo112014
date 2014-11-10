<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
    <%@ page import="net.sf.jasperreports.engine.*"%>
    <%@ page import="java.io.*" %>
    <%@ page import="java.util.*" %>
    
    <%@page import="javax.servlet.*"%>
    <%@page import="javax.servlet.http.*"%>    
    
     <%@ page import="net.sf.jasperreports.view.JasperViewer" %>
   
    <%  
    
    Connection conexion=null;
	
	try  {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/grupo11", "root", "");	
		System.out.println("conectado!");
	}catch(Exception e){
		System.out.println("error de conexion "+e.getMessage());	
		
	}
	
	try{
		
		int ban = Integer.parseInt(request.getParameter("ban"));
		
		String archivo="";
		
		if(ban==1){
			archivo = "Reportes/ReporteBodegas.jasper";
		}
		
		if(ban==2)
		{
			archivo = "Reportes/ReporteClientesTipoCliente.jasper";
		}
		
		if(ban==3)
		{
			archivo = "Reportes/ReporteClientesTodos.jasper";
		}
		
		if(ban==4)
		{
			archivo = "Reportes/ReporteProducosPorBodega.jasper";
		}	
		
		if(ban==5)
		{
			archivo = "Reportes/ReporteProductos.jasper";
		}
		
		
		if(ban==6)
		{
			archivo = "Reportes/ReporteProveedores.jasper";
		}
		
		if(ban==7)
		{
			archivo = "Reportes/ReporteTiposVenta.jasper";
		}
		
		
		
		File reportFile = new File(application.getRealPath(archivo));		

	    Map parameters = new HashMap();

	    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (),parameters,conexion);

	    response.setContentType("application/pdf");
	    response.setContentLength(bytes.length);
	    ServletOutputStream ouputStream = response.getOutputStream();
	    ouputStream.write(bytes, 0, bytes.length);
	    ouputStream.flush();
	    ouputStream.close();
		
		/*
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition",  "inline filename=report.pdf");
		 
		exporter = new  JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,  jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,  ouputStream);
		JasperViewer.viewReport(imp);*/
		
		
	}catch(Exception ex){
		System.out.println("error de conexion"+ex.getMessage());
		
	}
    
    
    %>
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>