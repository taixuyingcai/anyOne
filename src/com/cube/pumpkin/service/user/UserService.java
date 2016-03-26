package com.cube.pumpkin.service.user;

import javax.servlet.http.HttpServletRequest;

import com.cube.pumpkin.dao.UserDAO;
import com.cube.pumpkin.json.JSONObject;
import com.cube.pumpkin.model.User;

public class UserService {

	public static JSONObject getUser(HttpServletRequest request) {
		JSONObject res = new JSONObject().put("cmd", "getUser");
		int id = (int) request.getAttribute("id");
		UserDAO ud = new UserDAO();
		User user = ud.getUserById(id);
		JSONObject params = new JSONObject().put("User", user.toJson());
		res.put("params", params);
		return res;
	}

}
