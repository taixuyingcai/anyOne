package com.cube.pumpkin.dao;

import com.cube.pumpkin.model.User;

public class UserDAO extends BaseDAO{

	public void create(User user) {
		String sql = "insert into " + User.TAB_NAME+"("+User.COL +") values("+ user.getId()+"," + user.getName() +")";
		executeSql(sql);
	}
	
	public User getUserById(int uid) {
		String sql = "select " + User.COL + " from " + User.TAB_NAME + " where id=" + uid;
		Object[] objs = getObject(sql);
		User user = new User(objs);
		return user;
	}
}
