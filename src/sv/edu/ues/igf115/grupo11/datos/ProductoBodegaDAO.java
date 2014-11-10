package sv.edu.ues.igf115.grupo11.datos;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.grupo11.dominio.ProductoBodega;
import sv.edu.ues.igf115.grupo11.utilidades.HibernateUtil;

public class ProductoBodegaDAO {

	// Atributos de la clase
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;

	// Metodos de la clase
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}

	// Insertar y actualizar
	public void guardaActualiza(ProductoBodega productoBodega) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(productoBodega);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	// Eliminar
	public void eliminar(ProductoBodega productoBodega) {
		try {
			iniciaOperacion();
			sesion.delete(productoBodega);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	// Metodos para el control de los elementos de la tabla TipoVta

	//Se realiza la busqueda unicamente por el Id del producto
	public ProductoBodega daProductoBodegaByIds(String idProducto, String idBodega) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("ProductoBodega.findByIdProdYIdBod");
		query.setParameter("idProducto", idProducto);
		query.setParameter("idBodega", idBodega);
		ProductoBodega prodBod = (ProductoBodega) query.uniqueResult();
		sesion.close();
		return prodBod;
	}	

}
