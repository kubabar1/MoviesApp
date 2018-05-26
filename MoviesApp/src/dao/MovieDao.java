package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import models.Movie;

@Transactional
public class MovieDao implements MovieDaoInterface {

	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SessionFactory factory) {
		MovieDao.factory = factory;
	}

	@Override
	public void addMovie(Movie movie) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			session.save(movie);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Movie getMovieById(String id) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String hql = "FROM Movie M WHERE M.id = :movie_id";
			Query query = session.createQuery(hql);
			query.setParameter("movie_id", id);
			Movie result = (Movie) query.getSingleResult();
			tx.commit();

			return result;
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Movie> getAllMovies() {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			List movies = session.createQuery("FROM Movie").list();

			tx.commit();

			return movies;
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
