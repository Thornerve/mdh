package com.thor.mdh.web.freemarker;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 
 * 实现静态资源自动多域名处理
 * 
 */
public class MultiDomUrl implements TemplateMethodModel {

    /** five */
    private static final int FIVE = 5;

    /** 原始域名：含新域名编号所在位置的占位符 */
    private String host;

    /** 新域名编号所在位置的占位符 */
    private String imgHostTag;

    /** 图片处理域名数量 */
    private String imgHostNumber;

    /** 域名编号起始值 */
    private int imgUrlStarNum;

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (null == arguments || arguments.size() == 0) {
            return "";
        }
        // 获取资源文件名
        String url = (String) arguments.get(0);

        int imgNumber = FIVE;

        if (!StringUtils.isBlank(imgHostNumber)) {
            imgNumber = Integer.valueOf(imgHostNumber);
        }
        if (StringUtils.isBlank(url)) {
            return "";
        }

        // 获取新域名编号
        int suffix = Math.abs(stringToInt(url) % imgNumber) + imgUrlStarNum;

        // 替换编号所在位置的占位符
        String hostName = host.replace(imgHostTag, String.valueOf(suffix));

        if (!hostName.endsWith("/")) {
            hostName = hostName + "/";
        }

        if (url.startsWith("/")) {
            url = url.substring(1);
        }
        // 组装形成新域名
        String result = hostName + url;

        return result;
    }

    /**
     * 获取资源文件名的hashcode
     * 
     * @param str 参考说明
     * @return int 返回值
     */
    private int stringToInt(String str) {
        return str.hashCode();
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @return String 返回值
     */
    public String getHost() {
        return host;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param host 参考说明
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @return String 返回值
     */
    public String getImgHostTag() {
        return imgHostTag;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param imgHostTag 参考说明
     */
    public void setImgHostTag(String imgHostTag) {
        this.imgHostTag = imgHostTag;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @return String 返回值
     */
    public String getImgHostNumber() {
        return imgHostNumber;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param imgHostNumber 参考说明
     */
    public void setImgHostNumber(String imgHostNumber) {
        this.imgHostNumber = imgHostNumber;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @return int 返回值
     */
    public int getImgUrlStarNum() {
        return imgUrlStarNum;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param imgUrlStarNum 参考说明
     */
    public void setImgUrlStarNum(int imgUrlStarNum) {
        this.imgUrlStarNum = imgUrlStarNum;
    }

}
