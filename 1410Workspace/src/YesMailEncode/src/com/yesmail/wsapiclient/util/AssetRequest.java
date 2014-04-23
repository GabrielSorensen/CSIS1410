package com.yesmail.wsapiclient.util;

import org.restlet.data.Method;


/**
 * A sample implementation to submit an Asset API request.
 *
 * @author Yesmail
 * @version 1.0
 */
public class AssetRequest implements RequestInterface {
    private String name;
    private String base64Data;
    private String requestUri;
    private Method methodType;
	
	public AssetRequest(String name, String base64Data) {
		this.name = name;
		this.base64Data = base64Data;
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
		sb.append("\"assetName\":\"").append(name);
		sb.append("\", \"assetBase64Data\":\"").append(base64Data);
		sb.append("\"");
		sb.append("}");
		return sb.toString();
	}
	
	public String toXml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<yesws:asset xmlns:yesws=\"https://services.yesmail.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"https://services.yesmail.com docs/xsd/asset.xsd\" schemaVersion=\"1.0\">");
		//sb.append("<yesws:asset xsi:schemaLocation=\"https://services.yesmail.com docs/xsd/asset.xsd\" xmlns:yesws=\"https://services.yesmail.com\"xmlns: xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		sb.append("<yesws:assetName>").append(name).append("</yesws:assetName>");
		sb.append("<yesws:assetBase64Data>").append(base64Data).append("</yesws:assetBase64Data>");
		sb.append("</yesws:asset>");
		return sb.toString();
	}
}
