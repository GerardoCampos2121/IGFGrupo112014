package sv.edu.ues.igf115.grupo11.dominio;
import java.io.*;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name = "proveedor", catalog = "grupo11", schema = "")
@NamedQueries({
@NamedQuery(name = "Proveedores.findAll", query = "SELECT d FROM Proveedor d"),
@NamedQuery(name = "Proveedores.findByIdPro", query = "SELECT d FROM Proveedor d WHERE d.idProveedor = :idProveedor"),
@NamedQuery(name = "Proveedores.findByNombre", query = "SELECT d FROM Proveedor d WHERE d.nombreProveedor = :nombreProveedor") })
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idProveedor;
	private String nombreProveedor;
	private String direccion;
	private String telefono;
	private String email;
	private List<Producto> productoList;
// @OneToMany: (1:N) Asocia varios campos con uno
// Multiplicidad 1:N Un Proveedor tiene muchos Productos
	
	private Proveedor() {
	}

	public Proveedor(String idProveedor, String nombreProveedor,
			String direccion, String telefono, String email) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	@Id
	@Column(name = "id_proveedor")
	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	@Basic(optional = false)
	@Column(name = "nomb_proveed")
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	@Basic(optional = false)
	@Column(name = "direccion")
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Basic(optional = false)
	@Column(name = "telefono")
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Basic(optional = false)
	@Column(name = "e_mail")
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "proveedor")
		public List<Producto> getProductoList() {
		return productoList;
		}
	public void setProductoList(List<Producto> productoList) {
		this.productoList = productoList;
		}
	
	
}
