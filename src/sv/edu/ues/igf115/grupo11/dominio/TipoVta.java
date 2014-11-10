package sv.edu.ues.igf115.grupo11.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Anotaciones
@Entity
@Table(name = "tipovta", catalog = "grupo11", schema = "")
@NamedQueries({ 
	@NamedQuery(name = "TipoVenta.findAll", query = "SELECT t FROM TipoVta t"),
	@NamedQuery(name = "TipoVenta.findById", query = "SELECT t FROM TipoVta t WHERE t.idTipoVenta = :idTipoVenta")})

public class TipoVta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Atributos de la clase

	@Id
	@Basic(optional = false)
	@Column(name = "id_TipoVta")
	private String idTipoVenta;
	
	@Basic(optional = false)
	@Column(name = "desc_TipoVta")
	private String descTipoVenta;
	
	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ing")
	private Date fechaIngreso;
	
	// Constructor utilizado por hibernate
	public TipoVta() {

	}

	// Constructor de la clase
	public TipoVta(String idTipoVenta, String descTipoVenta, Date fechaIngreso) {
		this.idTipoVenta = idTipoVenta;
		this.descTipoVenta = descTipoVenta;
		this.fechaIngreso = fechaIngreso;
	}

	// Metodos de la clase

	public String getIdTipoVenta() {
		return idTipoVenta;
	}

	public void setIdTipoVenta(String idTipoVenta) {
		this.idTipoVenta = idTipoVenta;
	}

	public String getDescTipoVenta() {
		return descTipoVenta;
	}

	public void setDescTipoVenta(String descTipoVenta) {
		this.descTipoVenta = descTipoVenta;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "TipoVta [idTipoVenta=" + idTipoVenta + ", descTipoVenta="
				+ descTipoVenta + ", fechaIngreso=" + fechaIngreso + "]";
	}
	
	
}
