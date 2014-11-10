package sv.edu.ues.igf115.grupo11.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Factura implements Serializable{
	
	public static final long serialVersionUID = 1l;
	
	private String idFactura;
	private Date fecha_factura;
	private BigDecimal ventaTotal;
	private Cliente cliente;
	private TipoVta tipoVta;
	
	public Factura(){}

	public Factura(String idFactura, Date fecha_factura, BigDecimal ventaTotal,
			Cliente cliente, TipoVta tipoVta) {
		super();
		this.idFactura = idFactura;
		this.fecha_factura = fecha_factura;
		this.ventaTotal = ventaTotal;
		this.cliente = cliente;
		this.tipoVta = tipoVta;
	}
	
	
	

}
