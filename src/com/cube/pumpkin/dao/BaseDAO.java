package com.cube.pumpkin.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.cube.pumpkin.misc.HibernateUtil;

public class BaseDAO {
	protected static final Logger logger= Logger.getRootLogger();
	
	private Session read;
	private Session write;
	protected String keyNamespace;
	
	public BaseDAO() {
		keyNamespace = getClass().getName();
	}
	
	private void getReadSession() {
		read = HibernateUtil.getDataDb();
	}
	
	private void getWriteSession() {
		write = HibernateUtil.getDataDb();
	}
	
	private void closeReadSession() {
		if (read != null || read.isOpen()) {
			read.flush();
			read.close();
		}
	}
	
	private void closeWriteSession() {
		if (write != null || write.isOpen()) {
			write.flush();
			write.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	protected List<Object> getListObject(String sql) {
		List<Object> list = null;
		try {
			getReadSession();
			list = read.createSQLQuery(sql).list();
		} catch(Exception e) {
			logger.error("database error .sql="+sql, e);
		} finally {
			closeReadSession();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	protected List<Object[]> getList(String sql) {
		List<Object[]> list = null;
		try {
			getReadSession();
			list = read.createSQLQuery(sql).list();
		} catch (Exception e) {
			logger.error("database error .sql="+sql, e);
		} finally {
			closeReadSession();
		}
		return list;
	}
	
	protected Object[] getObject(String sql) {
		Object[] res = null;
		try {
			getReadSession();
			res = (Object[]) read.createSQLQuery(sql).uniqueResult();
		} catch (Exception e) {
			logger.error("database error .sql="+sql, e);
		} finally {
			closeReadSession();
		}
		return res;
	}
	
	protected int executeSql(String sql, ArrayList<String[]> params) {
		int res = 0;
		try {
			getWriteSession();
			SQLQuery sq = write.createSQLQuery(sql);
			if (params != null && params.size() > 0) {
				for (String[] str : params) {
					sq.setString(str[0], str[1]);
				}
			}
			res = sq.executeUpdate();
		} catch (Exception e) {
			logger.error("database error .sql="+sql, e);
		} finally {
			closeWriteSession();
		}
		return res;
	}
	
	protected int executeSql(String sql) {
		int res = 0;
		try {
			getWriteSession();
			res = write.createSQLQuery(sql).executeUpdate();
		} catch (Exception e) {
			logger.error("database error .sql="+sql, e);
		} finally {
			closeWriteSession();
		}
		return res;
	}
	
	
	
}
