package com.tres.wedding.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MappingExceptionResolver extends SimpleMappingExceptionResolver {

	private static final Logger LOG = Logger.getLogger(MappingExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
				HttpServletResponse response, Object handler, Exception ex) {

		ModelAndView retVal = null;

		String viewName = determineViewName(ex, request);

		LOG.info("View name: " + viewName);

		if (viewName != null) {
			Integer statusCode = super.determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			request.setAttribute("error", ex.getMessage());
			retVal = getModelAndView(viewName, ex, request);
		}

		return retVal;

	}
}