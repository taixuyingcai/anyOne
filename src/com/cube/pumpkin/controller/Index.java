package com.cube.pumpkin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Index extends AbstractController {
	private static final Logger log = Logger.getRootLogger();
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		log.info("anyOne index ...................................");
		log.info("arg0="+req.getAttribute("arg0"));
		return new ModelAndView("index");
	}

}
