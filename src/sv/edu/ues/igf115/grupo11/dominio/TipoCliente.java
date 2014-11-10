package sv.edu.ues.igf115.grupo11.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "tipocliente", catalog = "grupo11", schema = "")
@NamedQueries({	
	@NamedQuery(name = "TipoCliente.findAll", query = "SELECT e FROM TipoCliente e"),
	@NamedQuery(name = "TipoCliente.findById", query = "SELECT e FROM TipoCliente e WHERE e.idTipocliente = :idTipocliente")	
})  
public class TipoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id		
	@Column(name="id_tipocliente")
	private String idTipocliente;
	
	@Basic(optional = false)
	@Column(name="descripcion")
	private String desp;
	
	@Basic(optional = false)
	@Column(name="descuento")
	private BigDecimal desc;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipocliente")
	private List<Cliente> clientes;
		
	
	public TipoCliente() {
		
		// TODO Auto-generated constructor stub
	}
	

	public TipoCliente(String idTipocliente, String desp, BigDecimal desc) {
		
		this.idTipocliente = idTipocliente;
		this.desp = desp;
		this.desc = desc;
	}


	public String getIdTipocliente() {
		return idTipocliente;
	}


	public void setIdTipocliente(String idTipocliente) {
		this.idTipocliente = idTipocliente;
	}


	public String getDesp() {
		return desp;
	}


	public void setDesp(String desp) {
		this.desp = desp;
	}


	public BigDecimal getDesc() {
		return desc;
	}


	public void setDesc(BigDecimal desc) {
		this.desc = desc;
	}
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	
}
