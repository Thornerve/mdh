package com.thor.mdh.api.bean;

public class SessionUser {
	 
    /** ID */
    public static final String SESSION_USERID = "userid";
    
    /** User back ID */
    public static final String SESSION_BACK_USERID = "backuserid";
    
    /** cookie name */
    public static final String SSOCOOKIE = "sc_s";
    
    /** sso back cookie name */
    public static final String SSOBACKCOOKIE = "sc_s_back";

    /** cookie 有效时间 */
    public static final int AVAIL_TIME = 60 * 60 * 24 * 30;
    
    /** session id */
    public static final String SESSION_ID = "scookie0"; 
    
    /** session create time */
    public static final String SESSION_CREATE_TIME = "scookie1"; 
    
    /** session last access time */
    public static final String SESSION_LASTACCESS_TIME = "scookie2";
}
