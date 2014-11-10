package sv.edu.ues.igf115.grupo11.datos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.grupo11.dominio.Cliente;
import sv.edu.ues.igf115.grupo11.dominio.Factura;
import sv.edu.ues.igf115.grupo11.utilidades.HibernateUtil;

public class FacturaDAO {

	private HibernateUtil hibernateUtil = new HibernateUtil();
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

	private Session sesion;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}

	public void guardaActualiza(Factura factura) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(factura);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(Factura factura) {
		try {
			iniciaOperacion();
			sesion.delete(factura);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	
	//Todas las facturas
	@SuppressWarnings("unchecked")
	public List<Factura> daFactura() {

		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Factura.findAll");
		List<Factura> listaFacturas = query.list();
		sesion.close();
		return listaFacturas;
	}

	//Una factura en especifico por buscada por ID
	public Factura daFacturaById(String idFactura) {

		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Factura.findById");
		query.setParameter("idFactura", idFactura);
		Factura tpc = (Factura) query.uniqueResult();
		sesion.close();
		return tpc;
	}
	
//	//Una factura buscada por Id de la factura y el Id del cliente
//	public Factura daFacturaByIdCliente(String idFactura, Cliente cliente) {
//
//		sesion = sessionFactory.openSession();
//
//		Query query = sesion.getNamedQuery("Factura.findByIdCliente");
//		query.setParameter("idFactura", idFactura);
//		query.setParameter("Cliente", cliente);
//		Factura tpc = (Factura) query.uniqueResult();
//
//		sesion.close();
//		return tpc;
//	}

}
