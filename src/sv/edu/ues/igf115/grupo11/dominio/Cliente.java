package sv.edu.ues.igf115.grupo11.dominio;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "cliente", catalog = "grupo11", schema = "")
@NamedQueries({	
	@NamedQuery(name = "Cliente.findAll", query = "SELECT d FROM Cliente d"),
	@NamedQuery(name = "Cliente.findById", query = "SELECT d FROM Cliente d WHERE d.idCliente = :idCliente")	
})
public class Cliente {
	
	private static final long serialVersionUID = 1L;
	@Id	
	@Basic(optional = false)
	@Column(name="id_cliente")
	private String idCliente;
	
	@Basic(optional = false)
	@Column(name="nomb_client")
	private String nombCliente;
	
	@Basic(optional = false)
	@Column(name="apell_client")
	private String apCliente;
	
	@Basic(optional = false)
	@Column(name="domicilio")
	private String domCliente;
	
	@Basic(optional = false)
	@Column(name="telefono")
	private String telCliente;
	
	@Basic(optional = false)
	@Column(name="email")
	private String e_mail;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipocliente") //fk de la BD
	private TipoCliente tipocliente;
	
	
	public Cliente() {
			// TODO Auto-generated constructor stub
	}


	public Cliente(String idCliente, String nombCliente, String apCliente,
			String domCliente, String telCliente, String e_mail,
			TipoCliente tipocliente) {
		
		this.idCliente = idCliente;
		this.nombCliente = nombCliente;
		this.apCliente = apCliente;
		this.domCliente = domCliente;
		this.telCliente = telCliente;
		this.e_mail = e_mail;
		this.tipocliente = tipocliente;
	}


	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombCliente() {
		return nombCliente;
	}


	public void setNombCliente(String nombCliente) {
		this.nombCliente = nombCliente;
	}


	public String getApCliente() {
		return apCliente;
	}


	public void setApCliente(String apCliente) {
		this.apCliente = apCliente;
	}


	public String getDomCliente() {
		return domCliente;
	}


	public void setDomCliente(String domCliente) {
		this.domCliente = domCliente;
	}


	public String getTelCliente() {
		return telCliente;
	}


	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
	}


	public String getE_mail() {
		return e_mail;
	}


	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	public TipoCliente getTipocliente() {
		return tipocliente;
	}


	public void setTipocliente(TipoCliente tipocliente) {
		this.tipocliente = tipocliente;
	}		

}
