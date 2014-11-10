package sv.edu.ues.igf115.grupo11.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "factura", catalog = "grupo11", schema = "")
@NamedQueries({	
	@NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
	@NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
//	@NamedQuery(name = "Factura.findByIdCliente", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura AND f.Cliente = :Cliente")
})
public class Factura implements Serializable{
	
	public static final long serialVersionUID = 1l;
	
	@Id	
	@Column(name="id_factura")
	private String idFactura;
	
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_factura")
	private Date fechaFactura;
	
	@Basic(optional = false)
	@Column(name = "venta_total")
	private BigDecimal ventaTotal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cliente") //fk de la BD
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_TipoVta") //fk de la BD
	private TipoVta tipoVta;
			
	public Factura(){}
	
	public Factura(String idFactura, Date fechaFactura, BigDecimal ventaTotal,
			Cliente cliente, TipoVta tipoVta) {
		super();
		this.idFactura = idFactura;
		this.fechaFactura = fechaFactura;
		this.ventaTotal = ventaTotal;
		this.cliente = cliente;
		this.tipoVta = tipoVta;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public BigDecimal getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(BigDecimal ventaTotal) {
		this.ventaTotal = ventaTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoVta getTipoVta() {
		return tipoVta;
	}

	public void setTipoVta(TipoVta tipoVta) {
		this.tipoVta = tipoVta;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", fechaFactura="
				+ fechaFactura + ", ventaTotal=" + ventaTotal + ", cliente="
				+ cliente + ", tipoVta=" + tipoVta + "]";
	}
}
