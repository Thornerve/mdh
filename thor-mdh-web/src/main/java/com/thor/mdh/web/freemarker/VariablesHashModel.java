package com.thor.mdh.web.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import java.io.Serializable;

public class VariablesHashModel implements TemplateHashModel, Serializable {
	  private static final long serialVersionUID = 1L;
	  private Configuration config;
	  
	  public VariablesHashModel(Configuration config)
	  {
	    this.config = config;
	  }
	  
	  public TemplateModel get(String key)
	    throws TemplateModelException
	  {
	    return this.config.getSharedVariable(key);
	  }
	  
	  public boolean isEmpty()
	    throws TemplateModelException
	  {
	    return false;
	  }
 }

