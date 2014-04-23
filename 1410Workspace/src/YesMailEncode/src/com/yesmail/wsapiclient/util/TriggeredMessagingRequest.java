package com.yesmail.wsapiclient.util;

import org.restlet.data.Method;


/**
 * A sample implementation to submit a Trigger Message request.
 *
 * @author Yesmail
 * @version 1.0
 */
public class TriggeredMessagingRequest implements RequestInterface {
    private String masterId;
    private String requestUri;
    private Method methodType;
	
	public TriggeredMessagingRequest(String masterId) {
		this.masterId = masterId;
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
		sb.append("{");
		sb.append("\"masterId\":\"").append(masterId);
		sb.append("\"");
		sb.append("}");
		return sb.toString();
	}

	public String toXml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<yesws:subscriberMessage xmlns:yesws=\"https://services.yesmail.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"https://services.yesmail.com docs/xsd/subscribermessage.xsd\" schemaVersion=\"1.0\">");
		sb.append("<yesws:masterId>").append(masterId).append("</yesws:masterId>");
		sb.append("</yesws:subscriberMessage>");
		return sb.toString();
	}
}
