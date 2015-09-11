package com.thor.mdh.web.freemarker;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thor.mdh.api.util.StringUtil;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 截取字符串，对于截取过的串在结尾添加"…"符号<br>
 */
public class OmitString implements TemplateMethodModel {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (null == arguments || arguments.size() == 0) {
            return StringUtils.EMPTY;
        }
        
        // 获取字符串
        String string = (String) arguments.get(0);
        if (StringUtils.isBlank(string)) {
            return StringUtils.EMPTY;
        }
        
        // 获取截取长度
        String length = (String) arguments.get(1);
        if (StringUtils.isBlank(string)) {
            return StringUtils.EMPTY;
        }
        
        return StringUtil.omitString(string, Integer.parseInt(length));
    }

}
