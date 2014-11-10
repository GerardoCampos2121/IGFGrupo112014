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
		
		
		
		File reportFile = new File(application.getRealPath("Reportes/ReporteBodegas.jasper"));

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