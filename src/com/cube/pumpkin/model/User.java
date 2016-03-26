package com.cube.pumpkin.model;

import com.cube.pumpkin.json.JSONObject;

public class User {
	
	public static String TAB_NAME = "user";
	public static String COL = "id,name";
	public static int LEN = COL.split(",").length;
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public User(Object[] obj) {
		if (obj.length < LEN) {
			return;
		}
		id = (int) obj[0];
		name = (String) obj[1];
	}
	
	public JSONObject toJson() {
		JSONObject res = new JSONObject();
		res.put("id", id);
		res.put("name", name);
		return res;
	}
	
}
