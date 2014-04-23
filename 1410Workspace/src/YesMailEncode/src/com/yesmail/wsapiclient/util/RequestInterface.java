package com.yesmail.wsapiclient.util;

import org.restlet.data.Method;


/**
 * A sample interface that specifies the required methods for any
 * API request type.
 *
 * @author Yesmail
 * @version 1.0
 */
public interface RequestInterface {
    public String toJson();
    public String toXml();
    public String getRequestUri();
    public void setRequestUri(String uri);
    public Method getMethodType();
    public void setMethodType(Method methodType);
}
