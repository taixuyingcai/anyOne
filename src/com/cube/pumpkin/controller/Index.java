package com.cube.pumpkin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Index extends AbstractController {
	private static final Logger log = Logger.getRootLogger();
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		log.info("anyOne index ...................................");
		return new ModelAndView("index");
	}

}
