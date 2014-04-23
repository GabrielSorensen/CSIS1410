package com.yesmail.wsapiclient.util;

import org.restlet.data.Method;

import java.util.Map;


/**
 * A sample implementation to create or update a master envelope.  This is
 * part of the Master API.
 *
 * @author Yesmail
 * @version 1.0
 */
public class MasterEnvelopeRequest implements RequestInterface {
    private Map<String, String> masterMap;
    private String requestUri;
    private Method methodType;

	public MasterEnvelopeRequest(Map<String, String> masterMap) {
		this.masterMap = masterMap;
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
		// Envelope
		sb.append("\"envelope\":");
        sb.append("{");
        sb.append("\"campaign\" : \"").append(masterMap.get("campaign")).append("\" , ");
        sb.append("\"deliveryType\" : \"").append(masterMap.get("deliveryType")).append("\" , ");
        sb.append("\"description\" : \"").append(masterMap.get("description")).append("\" , ");
        sb.append("\"division\" : \"").append(masterMap.get("division")).append("\" , ");
        sb.append("\"friendlyFrom\" : \"").append(masterMap.get("friendlyFrom")).append("\" , ");
        sb.append("\"fromName\" : \"").append(masterMap.get("fromName")).append("\" , ");
        sb.append("\"fromDomain\" :  \"").append(masterMap.get("fromDomain")).append("\" , ");
        //sb.append("\"keywords\" : ");
        //sb.append("{");
        //sb.append("\"keyword\": \"").append(masterMap.get("keyword")).append("\" ");
        //sb.append("}, ");
        sb.append("\"encoding\": \"").append(masterMap.get("encoding")).append("\" , ");
        sb.append("\"masterName\": \"").append(masterMap.get("masterName")).append("\" , ");
        sb.append("\"subject\": \"").append(masterMap.get("subject")).append("\" ");
		sb.append("}, ");
		// Scheduling
		sb.append("\"scheduling\":");
		sb.append("{");
		sb.append("\"allowMultipleDeliveries\": \"").append(masterMap.get("allowMultipleDeliveries")).append("\" , ");
		sb.append("\"compileBeforeDeliveryStart\": \"").append(masterMap.get("compileBeforeDeliveryStart")).append("\" , ");
		sb.append("\"compileStartDateTime\": \"").append(masterMap.get("compileStartDateTime")).append("\" , ");
		sb.append("\"deliverImmediately\": \"").append(masterMap.get("deliverImmediately")).append("\" , ");
		sb.append("\"deliveryStartDateTime\": \"").append(masterMap.get("deliveryStartDateTime")).append("\" , ");
		sb.append("\"maxRecipients\": \"").append(masterMap.get("maxRecipients")).append("\" , ");
		sb.append("\"obeyDeliveryLimits\": \"").append(masterMap.get("obeyDeliveryLimits")).append("\" , ");
		sb.append("\"priority\": \"").append(masterMap.get("priority")).append("\"");
		sb.append("}");
        sb.append("}");
		return sb.toString();
	}

	public String toXml() {
		StringBuilder sb = new StringBuilder();
        sb.append("<yesws:master xmlns:yesws=\"https://services.yesmail.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"https://services.yesmail.com docs/xsd/master.xsd\" schemaVersion=\"1.0\">");
		// Envelope
        sb.append("<yesws:envelope>");
        sb.append("<yesws:campaign>").append(masterMap.get("campaign")).append("</yesws:campaign>");
		sb.append("<yesws:deliveryType>").append(masterMap.get("deliveryType")).append("</yesws:deliveryType>");
        sb.append("<yesws:description>").append(masterMap.get("description")).append("</yesws:description>");
        sb.append("<yesws:division>").append(masterMap.get("division")).append("</yesws:division>");
        sb.append("<yesws:friendlyFrom>").append(masterMap.get("friendlyFrom")).append("</yesws:friendlyFrom>");
        sb.append("<yesws:fromName>").append(masterMap.get("fromName")).append("</yesws:fromName>");
        sb.append("<yesws:fromDomain>").append(masterMap.get("fromDomain")).append("</yesws:fromDomain>");
        sb.append("<yesws:keywords>");
        sb.append("<yesws:keyword>").append(masterMap.get("keyword")).append("</yesws:keyword>");
        sb.append("</yesws:keywords>");
        sb.append("<yesws:encoding>").append(masterMap.get("encoding")).append("</yesws:encoding>");
        sb.append("<yesws:masterName>").append(masterMap.get("masterName")).append("</yesws:masterName>");
        sb.append("<yesws:subject>").append(masterMap.get("subject")).append("</yesws:subject>");
        sb.append("</yesws:envelope>");
        // Scheduling
        sb.append("<yesws:scheduling>");
		sb.append("<yesws:allowMultipleDeliveries>").append(masterMap.get("allowMultipleDeliveries")).append("</yesws:allowMultipleDeliveries>");
		sb.append("<yesws:compileBeforeDeliveryStart>").append(masterMap.get("compileBeforeDeliveryStart")).append("</yesws:compileBeforeDeliveryStart>");
		sb.append("<yesws:compileStartDateTime>").append(masterMap.get("compileStartDateTime")).append("</yesws:compileStartDateTime>");
		sb.append("<yesws:deliverImmediately>").append(masterMap.get("deliverImmediately")).append("</yesws:deliverImmediately>");
		sb.append("<yesws:deliveryStartDateTime>").append(masterMap.get("deliveryStartDateTime")).append("</yesws:deliveryStartDateTime>");
		sb.append("<yesws:maxRecipients>").append(masterMap.get("maxRecipients")).append("</yesws:maxRecipients>");
		sb.append("<yesws:obeyDeliveryLimits>").append(masterMap.get("obeyDeliveryLimits")).append("</yesws:obeyDeliveryLimits>");
		sb.append("<yesws:priority>").append(masterMap.get("priority")).append("</yesws:priority>");
		sb.append("</yesws:scheduling>");
		sb.append("</yesws:master>");
		return sb.toString();
	}
}
