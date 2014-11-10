package sv.edu.ues.igf115.grupo11.dominio;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name = "bodega", catalog = "grupo11", schema = "")
@NamedQueries({	
	@NamedQuery(name = "Bodega.findAll", query = "SELECT f FROM Bodega f"),
	@NamedQuery(name = "Bodega.findById", query = "SELECT f FROM Bodega f WHERE f.id_bodega = :id_bodega")	
})
public class Bodega {
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name="id_bodega")
	private String id_bodega;
	
	@Basic(optional = false)
	@Column(name="nombre_bodega")
	private String nombre_bodega;
	
	@Basic(optional = false)
	@Column(name="direccion")
	private String direccion;
	
	public Bodega() {	
		// TODO Auto-generated constructor stub
	}

	public Bodega(String id_bodega, String nombre_bodega, String direccion) {
		
		this.id_bodega = id_bodega;
		this.nombre_bodega = nombre_bodega;
		this.direccion = direccion;
	}

	public String getId_bodega() {
		return id_bodega;
	}
	
	public void setId_bodega(String id_bodega) {
		this.id_bodega = id_bodega;
	}
	
	public String getNombre_bodega() {
		return nombre_bodega;
	}
	
	public void setNombre_bodega(String nombre_bodega) {
		this.nombre_bodega = nombre_bodega;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
