package com.cube.pumpkin.misc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RequestFilter implements Filter {
	private static final Logger log = Logger.getRootLogger();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.debug("dofilter===========");
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String log4j = filterConfig.getServletContext().getRealPath("WEB-INF/classes") + "/GameServerLog4j.properties";
		PropertyConfigurator.configureAndWatch(log4j);
		log.debug("log4j ===========config file watched:" + log4j);
	}

}
