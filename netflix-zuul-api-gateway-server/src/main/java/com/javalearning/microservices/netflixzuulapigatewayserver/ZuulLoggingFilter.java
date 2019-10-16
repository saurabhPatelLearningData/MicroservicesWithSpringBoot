package com.javalearning.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// whether to execute this filter or not
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request,request.getRequestURL());
		logger.info("Hello Let me check zull");
		return null;
	}

	@Override
	public String filterType() {
		return "pre"; //it can be pre,post,error
	}

	@Override
	public int filterOrder() {
		// this will help in case when we have multiple filter for ordering like security filter
		return 1;
	}

}
