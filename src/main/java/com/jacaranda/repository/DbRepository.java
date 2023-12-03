package com.jacaranda.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jacaranda.utility.DbConnection;

public class DbRepository {
	
	public static <T> List<T> findAll(Class <T> c) throws Exception {
		Session session; 
		List<T> result = null;
		try {
			session = DbConnection.getSessionFactory().openSession();
		}catch (Exception e) {
			throw new Exception("Error en la base de datos");
		}
		try {
			result = (List<T>) session.createSelectionQuery("From " + c.getName()).getResultList();
		}catch (Exception e) {
			throw new Exception("Error al obtener la entidad");
		}
		session.close();
		return result;
	}
	
	
	public static <T> T findString(Class<T> c, String name) throws Exception {
		Session session; 
		T result = null;
		try {
			session = DbConnection.getSessionFactory().openSession();
		}catch (Exception e) {
			throw new Exception("Error en la base de datos");
		}
		try {
			result = session.find(c, name);
		}catch (Exception e) {
			throw new Exception("Error al obtener la entidad");
		}
		return result;
	}
	
	public static <T> T findObject(Class<T> c, T o) throws Exception{
		Session session; 
		T result = null;
		try {
			session = DbConnection.getSessionFactory().openSession();
		}catch (Exception e) {
			throw new Exception("Error en la base de datos");
		}
		try {
			result = session.find(c, o);
		}catch (Exception e) {
			throw new Exception("Error al obtener la entidad");
		}
		return result;
	}
	
	public static <T> T findInt(Class<T> c, int id) throws Exception {
		Session session; 
		T result = null;
		try {
			session = DbConnection.getSessionFactory().openSession();
		}catch (Exception e) {
			throw new Exception("Error en la base de datos");
		}
		try {
			result = session.find(c, id);
		}catch (Exception e) {
			throw new Exception("Error al obtener la entidad");
		}
		return result;
	}
	
	
	public static <T> T delete(T emp) {
		Transaction transaction = null;
		Session session = DbConnection.getSessionFactory().openSession();
		T result = null;
		
		transaction = session.beginTransaction();
		try {
			session.remove(emp);
			transaction.commit();
			
		}catch (Exception e) {
			transaction.rollback();
		}
		
		session.close();
		return result;
	}
	
	public static <T> T add(T emp) throws IllegalStateException {
		Transaction transaction = null;
		Session session = DbConnection.getSessionFactory().openSession();
		T result = null;
		
		
		transaction = session.beginTransaction();
		try {
			session.persist(emp);
			transaction.commit();
			
		}catch (Exception e) {
			transaction.rollback();
		}
		
		session.close();
		return result;
	}
	
	public static <T> T update(T emp) throws IllegalStateException {
		Transaction transaction = null;
		Session session = DbConnection.getSessionFactory().openSession();
		T result = null;
		
		
		transaction = session.beginTransaction();
		try {
			session.merge(emp);
			transaction.commit();
			
		}catch (Exception e) {
			transaction.rollback();
		}
		
		session.close();
		return result;
	}
	
	
}
