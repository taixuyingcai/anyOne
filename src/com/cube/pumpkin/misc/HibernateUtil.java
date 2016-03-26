package com.cube.pumpkin.misc;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	public static SessionFactory dataDb;
	/**
	 * 设置mysql的sql_mode模式语句
	 */
	private static String SQL_MODE = "SET SQL_MODE='STRICT_TRANS_TABLES'";
	
	private static void setSqlMode(Session session) {
//		session.createSQLQuery(SQL_MODE).executeUpdate();
	}
	
	public static void setDb(SessionFactory sf) {
		dataDb = sf;
	}
	
	public static Session getDataDb(){
		Session session = dataDb.openSession();
		session.setCacheMode(CacheMode.IGNORE);
		setSqlMode(session);
		return session;
	}
}
