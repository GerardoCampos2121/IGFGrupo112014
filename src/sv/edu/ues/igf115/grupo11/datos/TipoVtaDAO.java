package sv.edu.ues.igf115.grupo11.datos;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.grupo11.dominio.TipoVta;
import sv.edu.ues.igf115.grupo11.utilidades.HibernateUtil;

public class TipoVtaDAO {
	
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
	public void guardaActualiza(TipoVta tipoVenta) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tipoVenta);
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
	public void eliminar(TipoVta tipoVenta) {
		try {
			iniciaOperacion();
			sesion.delete(tipoVenta);
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

	public TipoVta daTipoVentaById(String id) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("TipoVenta.findById");
		query.setParameter("idTipoVenta", id);
		TipoVta tipoVenta = (TipoVta) query.uniqueResult();
		sesion.close();
		return tipoVenta;
	}
}
