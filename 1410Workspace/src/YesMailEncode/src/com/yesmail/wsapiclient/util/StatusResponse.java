package com.yesmail.wsapiclient.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * A sample implementation that represents the processing of the payload
 * after the asynchronous API completes.
 *
 * @author Yesmail
 * @version 1.0
 */
public class StatusResponse {
    enum State { SUBMITTED, INPROGRESS, COMPLETED, CANCELLED, ERROR };

    private State statusCode;
    private String finalResourceURI;
    private String statusMessage;
    private String statusURI;
    private String uri;
    private String uriLastVal;
    private String finalResourceUriLastVal;
    private final static Logger logger = Logger.getLogger("com.yesmail.wsapiclient.util");

    /**
     * The method that parses the completed API process.  The response
     * will be sent as an XML payload.
     *
     * @param is The <code>InputStream</code> to process from the
     * API submission.
     * @throws RuntimeException when the method failed to parse the payload.
     */
    public StatusResponse(InputStream is) {
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document document = builder.parse(is);
            NodeList nodes_i = document.getDocumentElement().getChildNodes();
            logger.info("Response XML: " + convertDocToString(document));

			for (int i = 0; i < nodes_i.getLength(); i++) {
				Node node_i = nodes_i.item(i);
				String childName = node_i.getNodeName();
                String parentName = node_i.getParentNode().getNodeName();

                if(childName.equals("yesws:finalResourceURI")) {
                    if (node_i.getFirstChild() != null) {
					    finalResourceURI = node_i.getFirstChild().getNodeValue();
                        finalResourceUriLastVal = parseLastValueFromUri(finalResourceURI);
                    } else {
                        finalResourceURI = "";
                        finalResourceUriLastVal = "";
                    }
				} else if (childName.equals("yesws:statusMessage")) {
					statusMessage = node_i.getFirstChild().getNodeValue();
				} else if (childName.equals("yesws:statusCode")) {
                    statusCode = Enum.valueOf(State.class, node_i.getFirstChild().getNodeValue());
				}  else if (childName.equals("yesws:statusURI")) {
                    statusURI = node_i.getFirstChild().getNodeValue();
                 }  else if (parentName.equals("yesws:uri")) {
                    uri = node_i.getNodeValue();
                    uriLastVal = parseLastValueFromUri(uri);
                }
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to parse the StatusResponse.", e);
		} finally {
			if(is != null)
            try {
                is.close();
            } catch(IOException ioe) {
                ioe.printStackTrace();     
            }
		}
	}

	public boolean requestCompleted() {
		return statusCode == State.COMPLETED ||
		       statusCode == State.ERROR ||
		       statusCode == State.CANCELLED;
	}

	public String getFinalResourceURI() {
		return finalResourceURI;
	}

	public String getFinalResourceUriLastVal() {
		return finalResourceUriLastVal;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

    public String getStatusURI() {
        return statusURI;
    }

    public String getUri() {
        return uri;
    }

    public String getUriLastVal() {
        return uriLastVal;
    }

    /**
     * The method that parses the URI for the last value returned by the API.
     *
     * @param responseUri The string to parse.
     * @return The last value in the URI.
     */
    public String parseLastValueFromUri(String responseUri) {
        String lastValue;
        try {
            String[] tokens = responseUri.split("/");
            int length = tokens.length;
            lastValue = tokens[length - 1];
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve the file extension.", e);
        }
        return lastValue;
    }

    /**
     * The method that prepares the <code>Document</code> for printout.
     *
     * @param doc Converts the <code>Document</code> to a string.
     * @return An XML as a String.
     */
    public String convertDocToString(Document doc) {
        try {
           DOMSource domSource = new DOMSource(doc);
           StringWriter writer = new StringWriter();
           StreamResult result = new StreamResult(writer);
           TransformerFactory tf = TransformerFactory.newInstance();
           Transformer transformer = tf.newTransformer();
           transformer.transform(domSource, result);
           return writer.toString();
        } catch(TransformerException tx) {
           tx.printStackTrace();
           return null;
        }
    }
}
