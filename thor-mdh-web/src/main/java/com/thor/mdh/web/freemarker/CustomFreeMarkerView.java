package com.thor.mdh.web.freemarker;

import freemarker.ext.jsp.TaglibFactory;
import freemarker.ext.servlet.HttpRequestHashModel;
import freemarker.ext.servlet.HttpRequestParametersHashModel;
import freemarker.ext.servlet.HttpSessionHashModel;
import freemarker.ext.servlet.ServletContextHashModel;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import java.lang.reflect.Field;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class CustomFreeMarkerView extends FreeMarkerView {
	  private static Logger logger = LoggerFactory.getLogger(CustomFreeMarkerView.class);
	  public static String LOOKUP_SESSION_SCOPE = "lookup.scope.session";
	  public static String LOOKUP_APPLICATION_SCOPE = "lookup.scope.application";
	  public static String LOOKUP_REQUEST_SCOPE = "lookup.scope.request";
	  public static String LOOKUP_PAGE_SCOPE = "lookup.scope.page";
	  public static String KEY_VARIABLES = "Variables";
	  private boolean applicationScope = true;
	  private boolean sessionScope = true;
	  private boolean requestScope = true;
	  private TaglibFactory _taglibFactory;
	  private ServletContextHashModel _servletContextHashModel;
	  private Configuration config;
  
	  protected void initServletContext(ServletContext servletContext)
	    throws BeansException
	  {
	    super.initServletContext(servletContext);
	    try
	    {
	      Field field = FreeMarkerView.class.getDeclaredField("taglibFactory");
	      field.setAccessible(true);
	      this._taglibFactory = ((TaglibFactory)field.get(this));
	    }
	    catch (Exception e)
	    {
	      logger.error("get taglibFactory Object error", e);
	    }
	    try
	    {
	      Field field = FreeMarkerView.class.getDeclaredField("servletContextHashModel");
	      field.setAccessible(true);
	      this._servletContextHashModel = ((ServletContextHashModel)field.get(this));
	    }
	    catch (Exception e)
	    {
	      logger.error("get servletContextHashModel Object error", e);
	    }
	    this.config = getConfiguration();
	    
	    this.sessionScope = (this.config.getSharedVariable(LOOKUP_SESSION_SCOPE) == null ? true : Boolean.valueOf(this.config.getSharedVariable(LOOKUP_SESSION_SCOPE).toString()).booleanValue());
	    this.applicationScope = (this.config.getSharedVariable(LOOKUP_APPLICATION_SCOPE) == null ? true : Boolean.valueOf(this.config.getSharedVariable(LOOKUP_APPLICATION_SCOPE).toString()).booleanValue());
	    this.requestScope = (this.config.getSharedVariable(LOOKUP_REQUEST_SCOPE) == null ? true : Boolean.valueOf(this.config.getSharedVariable(LOOKUP_REQUEST_SCOPE).toString()).booleanValue());
	  }
	  
	  protected SimpleHash buildTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
	  {
	    ScopeChoiceHashModel fmModel = new ScopeChoiceHashModel(getObjectWrapper(), getServletContext(), request);
	    fmModel.setSessionScope(this.sessionScope);
	    fmModel.setApplicationScope(this.applicationScope);
	    fmModel.setRequestScope(this.requestScope);
	    
	    fmModel.put("JspTaglibs", this._taglibFactory);
	    fmModel.put("Application", this._servletContextHashModel);
	    fmModel.put("Session", buildSessionModel(request, response));
	    fmModel.put(KEY_VARIABLES, buildVariablesModel(this.config));
	    fmModel.put("Request", new HttpRequestHashModel(request, response, getObjectWrapper()));
	    fmModel.put("RequestParameters", new HttpRequestParametersHashModel(request));
	    fmModel.putAll(model);
	    return fmModel;
	  }
	  
	  private VariablesHashModel buildVariablesModel(Configuration config)
	  {
	    return new VariablesHashModel(config);
	  }
	  
	  private HttpSessionHashModel buildSessionModel(HttpServletRequest request, HttpServletResponse response)
	  {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	      return new HttpSessionHashModel(session, getObjectWrapper());
	    }
	    return new HttpSessionHashModel(null, request, response, getObjectWrapper());
	  }
 }
