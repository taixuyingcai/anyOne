package com.cube.pumpkin.misc;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLInnoDBDialect;

public class MySqlDialectOverride extends MySQLInnoDBDialect {

	public MySqlDialectOverride() {
		super();
		registerHibernateType(-1, Hibernate.STRING.getName());
	}
}
