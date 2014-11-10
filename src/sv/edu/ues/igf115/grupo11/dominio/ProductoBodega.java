package sv.edu.ues.igf115.grupo11.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "productobodega", catalog = "grupo11", schema = "")
@NamedQueries({
	@NamedQuery(name = "ProductoBodega.findByIdProdYIdBod", query = "SELECT e FROM ProductoBodega e WHERE e.idProducto = :idProducto AND e.idBodega = :idBodega"),
})
public class ProductoBodega implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Atributos de la clase
	private String idProducto;
	private String idBodega;
	private BigDecimal cantidadBodega;
	
	//Constructor por defecto utilizado por hibernate
	private ProductoBodega() {
		
	}

	//Constructor de la clase
	public ProductoBodega(String idProducto, String idBodega, BigDecimal cantidadBodega) {
		this.idProducto = idProducto;
		this.idBodega = idBodega;
		this.cantidadBodega = cantidadBodega;
	}

	//Metodos de la clase
	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
	}

	public BigDecimal getCantidadBodega() {
		return cantidadBodega;
	}

	public void setCantidadBodega(BigDecimal cantidadBodega) {
		this.cantidadBodega = cantidadBodega;
	}
	
	
}
