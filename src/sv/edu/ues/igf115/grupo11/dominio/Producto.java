package sv.edu.ues.igf115.grupo11.dominio;

import javax.persistence.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
//@Table: Especifica la tabla principal rela1cionada con la entidad.
@Table(name = "producto", catalog = "grupo11", schema = "")
//@NamedQueries: Especifica varios queries.
@NamedQueries({
//@NamedQuery: Especifica el nombre del objeto query utilizado junto a EntityManager.
@NamedQuery(name = "Productos.findAll", query = "SELECT e FROM Producto e"),
@NamedQuery(name = "Productos.findById", query = "SELECT e FROM Producto e WHERE e.idProducto = :idProducto"),
@NamedQuery(name = "Productos.findByDescripcion", query = "SELECT e FROM Producto e WHERE e.descripcion = :descripcion"),
@NamedQuery(name = "Productos.findByPrecio", query = "SELECT e FROM Producto e WHERE e.precioUnitario = :precioUnitario")})
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idProducto;
	private String descripcion;
	private Date fechaInicio;
	private BigDecimal  precioUnitario;
	private Proveedor proveedor;
	public Producto() {}
	public Producto(String idProducto, String descripcion, Date fechaInicio,BigDecimal precioUnitario, Proveedor proveedor) {
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.precioUnitario = precioUnitario;
		this.proveedor = proveedor;
	}
	@Id
	@Basic(optional = false)
	@Column(name = "id_producto")
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	@Basic(optional = false)
	@Column(name = "desc_producto")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Basic(optional = false)
	@Column(name = "fech_ingres")
	@Temporal(TemporalType.TIMESTAMP)
		public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	@Column(name = "precio_unitario")
		public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	// @JoinColumn: Especifica un campo de la tabla que es FK de otra tabla
		//definiendo la relación del lado propietario.
		// El Proveedor está en la tabla 'proveedor' con la clave id_proveedor
		@JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
		@ManyToOne
			
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
