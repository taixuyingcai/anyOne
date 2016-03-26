package com.cube.pumpkin.misc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.SessionFactory;

public class RequestFilter implements Filter {
	private static final Logger log = Logger.getRootLogger();
	
	public void setDataDb(SessionFactory session) {
		HibernateUtil.setDb(session);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.debug("dofilter===========");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("arg0", "abcd");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String log4j = filterConfig.getServletContext().getRealPath("WEB-INF/classes") + "/GameServerLog4j.properties";
		PropertyConfigurator.configureAndWatch(log4j);
		log.debug("log4j ===========config file watched:" + log4j);
	}

}
