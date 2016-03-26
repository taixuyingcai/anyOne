package com.cube.pumpkin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.cube.pumpkin.json.JSONArray;
import com.cube.pumpkin.json.JSONObject;
import com.cube.pumpkin.service.user.UserService;

public class Gateway extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=UTF-8");
		String data = req.getParameter("data");
		JSONArray dataJson = null;
		try {
			dataJson = new JSONArray(data);
			if (dataJson.length() == 0) {
				logger.warn("invalid parameter data=" + data);
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	private JSONArray handleCmd(JSONObject req, HttpServletRequest request) {
		String cmd = req.getString("cmd");
		JSONArray res = new JSONArray();
		switch(cmd) {
			case "getUser":
				res.put(UserService.getUser(request));
				break;
		}
		return res;
	}
}
