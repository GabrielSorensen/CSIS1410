package com.yesmail.wsapiclient.util;

import org.restlet.data.Method;

import java.util.Map;


/**
 * A sample implementation to submit a Create Subscriber API request.
 *
 * @author Yesmail
 * @version 1.0
 */
public class CreateSubscriberRequest implements RequestInterface {
    private Map<String, String> subscriberMap;
    private String requestUri;
    private Method methodType;
	
	public CreateSubscriberRequest (Map<String, String> subscriberMap) {
		this.subscriberMap = subscriberMap;
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
		sb.append("\"subscriptionState\": \"").append(subscriberMap.get("subscriptionState")).append("\", ");
        sb.append("\"division\" : ");
        sb.append("{");
        sb.append("\"value\": \"").append(subscriberMap.get("division")).append("\" ");
        sb.append("}, ");
        sb.append("\"attributes\" : ");
        sb.append("{");
        sb.append("\"attributes\" : ");
        sb.append(" [ ");
        sb.append(" { \"name\" : \"email\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("email")).append("\" }, ");
        sb.append(" { \"name\" : \"firstName\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("firstName")).append("\" }, ");
        sb.append(" { \"name\" : \"lastName\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("lastName")).append("\" }, ");
        sb.append(" { \"name\" : \"postalCode\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("postalCode")).append("\" }, ");
        sb.append(" { \"name\" : \"string type\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("string type")).append("\" }, ");
        sb.append(" { \"name\" : \"numberType\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("numberType")).append("\" }, ");
        sb.append(" { \"name\" : \"floatType\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("floatType")).append("\" }, ");
        sb.append(" { \"name\" : \"dateType\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("dateType")).append("\" }, ");
        sb.append(" { \"name\" : \"booleanType\" , ");
        sb.append(" \"value\" : \"").append(subscriberMap.get("booleanType")).append("\" } ");
        sb.append( "]" );
        sb.append("}");
        sb.append("}");
		return sb.toString();
	}

	public String toXml() {
		StringBuilder sb = new StringBuilder();
        sb.append("<yesws:subscriber xmlns:yesws=\"https://services.yesmail.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"https://services.yesmail.com docs/xsd/subscriber.xsd\" schemaVersion=\"1.0\">");
		sb.append("<yesws:subscriptionState>").append(subscriberMap.get("subscriptionState")).append("</yesws:subscriptionState>");
        sb.append("<yesws:division>").append(subscriberMap.get("division")).append("</yesws:division>");
        sb.append("<yesws:attributes>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>email</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("email")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>firstName</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("firstName")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>lastName</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("lastName")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>postalCode</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("postalCode")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>stringtype</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("string type")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>numberType</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("numberType")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>floatType</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("floatType")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>dateType</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("dateType")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("<yesws:attribute>");
        sb.append("<yesws:name>booleanType</yesws:name>");
        sb.append("<yesws:value>").append(subscriberMap.get("booleanType")).append("</yesws:value>");
        sb.append("</yesws:attribute>");
        sb.append("</yesws:attributes>");
		sb.append("</yesws:subscriber>");
		return sb.toString();
	}
}
