package br.com.senior.hotelproj.model.baserepository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import br.com.senior.hotelproj.model.baseinterface.IBaseDaoInterface;

public class BaseDaoRepository<T> implements IBaseDaoInterface<T> {
	private final Class<T> tipoClasse;
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoRepository() throws Exception {
		this.tipoClasse = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.setUp();
	}

	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@Override
	public void inserir(T model) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(model);
			session.getTransaction().commit();

		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@Override
	public void alterar(T model) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(model);
			session.getTransaction().commit();

		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
			session.close();
			// session.disconnect();
		}
	}

	@Override
	public void excluir(T model) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(model);
			session.getTransaction().commit();

		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@Override
	public T obterPorChave(int parametros) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			T model = (T)session.get (tipoClasse, parametros);
			session.getTransaction().commit();

			return model;
		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@Override
	public List<T> obter(Object parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> obterTodos() {
		Session session = this.sessionFactory.openSession();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criterio = builder.createQuery(tipoClasse);
			Root<T> variableRoot = criterio.from(tipoClasse);
			criterio.select(variableRoot);			
			
			return session.createQuery(criterio).getResultList();
		} catch (Exception e) {
			return new ArrayList<>();
		} finally {
			session.close();
		}
	}

}
