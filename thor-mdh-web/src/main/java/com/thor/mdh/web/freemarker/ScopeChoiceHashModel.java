package com.thor.mdh.web.freemarker;

import freemarker.template.ObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ScopeChoiceHashModel extends SimpleHash {
	private static final long serialVersionUID = -2585281068763945233L;
	
	private final ServletContext context;
	  private final HttpServletRequest request;
	  private final Map<String,TemplateModel> unlistedModels = new HashMap<String,TemplateModel>();
	  private boolean applicationScope = true;
	  private boolean sessionScope = true;
	  private boolean requestScope = true;
	  
	  public ScopeChoiceHashModel(ObjectWrapper wrapper, ServletContext context, HttpServletRequest request)
	  {
	    setObjectWrapper(wrapper);
	    this.context = context;
	    this.request = request;
	  }
	  
	  public void putUnlistedModel(String key, TemplateModel model)
	  {
	    this.unlistedModels.put(key, model);
	  }
	  
	  public TemplateModel get(String key)
	    throws TemplateModelException
	  {
	    TemplateModel model = super.get(key);
	    if (model != null) {
	      return model;
	    }
	    model = (TemplateModel)this.unlistedModels.get(key);
	    if (model != null) {
	      return model;
	    }
	    if (this.requestScope)
	    {
	      Object obj = this.request.getAttribute(key);
	      if (obj != null) {
	        return wrap(obj);
	      }
	    }
	    if (this.sessionScope)
	    {
	      HttpSession session = this.request.getSession(false);
	      if (session != null)
	      {
	        Object obj = session.getAttribute(key);
	        if (obj != null) {
	          return wrap(obj);
	        }
	      }
	    }
	    if (this.applicationScope)
	    {
	      Object obj = this.context.getAttribute(key);
	      if (obj != null) {
	        return wrap(obj);
	      }
	    }
	    return wrap(null);
	  }
	  
	  public boolean isApplicationScope()
	  {
	    return this.applicationScope;
	  }
	  
	  public void setApplicationScope(boolean applicationScope)
	  {
	    this.applicationScope = applicationScope;
	  }
	  
	  public boolean isSessionScope()
	  {
	    return this.sessionScope;
	  }
	  
	  public void setSessionScope(boolean sessionScope)
	  {
	    this.sessionScope = sessionScope;
	  }
	  
	  public boolean isRequestScope()
	  {
	    return this.requestScope;
	  }
	  
	  public void setRequestScope(boolean requestScope)
	  {
	    this.requestScope = requestScope;
	  }
 }

