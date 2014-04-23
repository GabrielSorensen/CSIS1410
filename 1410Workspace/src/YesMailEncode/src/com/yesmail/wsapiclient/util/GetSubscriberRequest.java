package com.yesmail.wsapiclient.util;

import org.restlet.data.Method;


/**
 * A sample implementation to submit a Get Subscriber API request.
 *
 * @author Yesmail
 * @version 1.0
 */
public class GetSubscriberRequest implements RequestInterface {
	private String email;
    private String requestUri;
    private Method methodType;

	public GetSubscriberRequest(String email) {
		this.email = email;
	}

    public void setRequestUri(String uri) {
        this.requestUri = uri;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setMethodType(Method methodType) {
        this.methodType = methodType;
    }

    public Method getMethodType(){
        return methodType;
    }

	public String toJson() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}
	
	public String toXml() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}
}
