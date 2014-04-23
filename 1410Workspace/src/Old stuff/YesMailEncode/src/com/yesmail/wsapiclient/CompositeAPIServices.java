package com.yesmail.wsapiclient;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Preference;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.data.Status;

import com.yesmail.wsapiclient.util.AssetRequest;
import com.yesmail.wsapiclient.util.Base64Utility;
import com.yesmail.wsapiclient.util.CreateSubscriberRequest;
import com.yesmail.wsapiclient.util.GetSubscriberRequest;
import com.yesmail.wsapiclient.util.MasterEnvelopeRequest;
import com.yesmail.wsapiclient.util.RequestInterface;
import com.yesmail.wsapiclient.util.StatusResponse;
import com.yesmail.wsapiclient.util.TriggeredMessagingRequest;
import com.yesmail.wsapiclient.util.UpdateSubscriberRequest;




/**
 * A sample implementation that represents a composite API web service.
 * API calls will be made to the Masters API, the Asset API, the
 * Subscribers API, and the Trigger Message API.
 *
 * @author  Yesmail
 * @version 1.0
 */
public class CompositeAPIServices {

	private final static String CONFIG = "config";
	private final static String baseUrl = "https://enterprise7.yesmail.com/#contentBlock?id=9";
	private final static String userName = "zions/aipuser";
	private final static String password = "zBKut3649";
	private final static String XMLorJSON = "xml";
//	    private final static String CREATEorUPDATEmaster;
//	    private final static String subscriberEmail;
	private final static Logger logger = Logger.getLogger("com.yesmail.wsapiclient");
	private static final DateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");

//	    static {
//			ResourceBundle rb = ResourceBundle.getBundle (CONFIG, Locale.getDefault(), CompositeAPIServices.class.getClassLoader());
//			if(!(rb.containsKey("userName")
//					&& rb.containsKey("password")
//					&& rb.containsKey("baseUrl"))) {
//				throw new IllegalArgumentException("userName, password, and baseUrl must be defined in a properties file called:: " + CONFIG);
//			}
////			userName = rb.getString("userName");
////			password = rb.getString("password");
////			baseUrl = rb.getString("baseUrl");
////	        XMLorJSON = rb.getString("XMLorJSON");
//	        subscriberEmail = rb.getString("subscriberEmail");
//	        CREATEorUPDATEmaster = rb.getString("CREATEorUPDATEmaster");
//	       
//		}

		private final static Map<String, String> MASTER_MAP = new HashMap<String, String>();
		static {
			// Envelope
			MASTER_MAP.put("campaign", "Master Management API");
			MASTER_MAP.put("deliveryType", "AUTODETECT");
			MASTER_MAP.put("description", "Posting a Master Creation Request");
			MASTER_MAP.put("division", "DivisionOne");
			MASTER_MAP.put("friendlyFrom", "CSE Master API Test");
			MASTER_MAP.put("fromName", "email");
			MASTER_MAP.put("fromDomain", "division1.wstest.com");
			MASTER_MAP.put("keyword", "FRIDAY");
			MASTER_MAP.put("encoding", "ISO-8859-1");
			MASTER_MAP.put("masterName", "CSE_Master_API_Test_"+ new Timestamp(System.currentTimeMillis())); // Must be unique for each create master request.
			MASTER_MAP.put("subject", "CSE Master API Test");
			
			// Scheduling
			MASTER_MAP.put("allowMultipleDeliveries", "false");
			MASTER_MAP.put("compileBeforeDeliveryStart", "false");
			MASTER_MAP.put("compileStartDateTime", getFutureDateString()); // ISO 8601 format
			MASTER_MAP.put("deliverImmediately", "false");
			MASTER_MAP.put("deliveryStartDateTime", getFutureDateString()); // ISO 8601 format
			MASTER_MAP.put("maxRecipients", String.valueOf(Integer.MAX_VALUE));
			MASTER_MAP.put("obeyDeliveryLimits", "true");
			MASTER_MAP.put("priority", "1");
		}
	
		private final static Map<String, String> NEW_SUBSCRIBER_MAP = new HashMap<String, String>();
		static {
			NEW_SUBSCRIBER_MAP.put("subscriptionState", "SUBSCRIBED");
			NEW_SUBSCRIBER_MAP.put("division", "DivisionOne");
			//NEW_SUBSCRIBER_MAP.put("email", subscriberEmail);
			NEW_SUBSCRIBER_MAP.put("firstName", "CSE Tester FirstName");
			NEW_SUBSCRIBER_MAP.put("lastName", "CSE Tester LastName");
			NEW_SUBSCRIBER_MAP.put("postalCode", "10001");
			NEW_SUBSCRIBER_MAP.put("string type", "$123456");
			NEW_SUBSCRIBER_MAP.put("numberType", "1234567890");
			NEW_SUBSCRIBER_MAP.put("floatType", "12345.67");
			NEW_SUBSCRIBER_MAP.put("dateType", "2010-04-27"); // UTC Format
			NEW_SUBSCRIBER_MAP.put("booleanType", "TRUE");
		}
	
		private final static Map<String, String> UPDATE_SUBSCRIBER_MAP = new HashMap<String, String>();
		static {
			UPDATE_SUBSCRIBER_MAP.put("subscriptionState", "UNSUBSCRIBED");
			UPDATE_SUBSCRIBER_MAP.put("division", "DivisionOne");
			//UPDATE_SUBSCRIBER_MAP.put("email", subscriberEmail);
			UPDATE_SUBSCRIBER_MAP.put("firstName", "CSE Tester FirstName");
			UPDATE_SUBSCRIBER_MAP.put("lastName", "CSE Tester LastName");
			UPDATE_SUBSCRIBER_MAP.put("postalCode", "01110");
			UPDATE_SUBSCRIBER_MAP.put("string type", "CSE Tester");
			UPDATE_SUBSCRIBER_MAP.put("numberType", "987654321");
			UPDATE_SUBSCRIBER_MAP.put("floatType", "12345.67");
			UPDATE_SUBSCRIBER_MAP.put("dateType", "2000-04-27"); // UTC Format
			UPDATE_SUBSCRIBER_MAP.put("booleanType", "FALSE");
		}

	/**
	 * Turn a Date into ISO 8601 date format.
	 * @param date
	 * @return
	 */
	public static String getFutureDateString() {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_YEAR, 14); // 2 weeks out
		String formattedDate = ISO_8601_FORMAT.format(cal.getTime()).trim();
		return formattedDate + "Z";
	}

	/**
	 * The <code>main</code> method that starts the web service calls.
	 * The command line will be processed if the configuration is to use
	 * an "OLD" newOrOldMaster parameter.
	 *
	 * @param args Indicates which masterId and/or asset file should get processed.
	 * @throws TimeoutException if one of the asynchronous API calls exceed 
	 * the polling period for that API to complete.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws TimeoutException, IOException {
		String masterId = null;
		String assetFileName = null;

		//        //Checking for the masterId command line argument.
//		        if(CREATEorUPDATEmaster.equals("UPDATE") && args.length > 0) {
//		            try {
//		                Integer.parseInt(args[0]);
//		                masterId = args[0];
//		                logger.info("Incoming masterId: " + masterId);
//		            } catch (NumberFormatException nfe) {
//		                throw new IllegalArgumentException("usage: java ... com.yesmail.wsapiclient.CompositeAPIServices <masterId>");
//		            }
//				} else if (CREATEorUPDATEmaster.equals("UPDATE") && args.length == 0) {
//		            throw new IllegalArgumentException("usage: java ... com.yesmail.wsapiclient.CompositeAPIServices <masterId>");
//		        }

		//Checking for the asset fileName command line argument.
		        if (args.length == 2) {
		            assetFileName = args[1];
		            logger.info("Incoming assets: " + assetFileName);
		        }

		// Handle it using an HTTP client connector
		List<Protocol> protocols = new ArrayList<Protocol>();
		protocols.add(Protocol.HTTP);
		protocols.add(Protocol.HTTPS);
		Client client;
		CompositeAPIServices svc = new CompositeAPIServices();
		String statusUri;
		StatusResponse status;

		//        //===Create Master===
//		        if (CREATEorUPDATEmaster.equals("CREATE")) {            
//		            RequestInterface masterInfo = new MasterEnvelopeRequest(MASTER_MAP);
//		            masterInfo.setMethodType(Method.POST);
//		            masterInfo.setRequestUri(baseUrl + "/masters");
//		
//		            client = new Client(protocols);
//		            statusUri = svc.asynchronousRequest(client, masterInfo);
//		            status = svc.waitUntilComplete(client, statusUri, 3);
//		            logger.info(status.getStatusMessage());
//		            masterId = status.getFinalResourceUriLastVal();
//		            logger.info("POST Master created masterId: " + masterId);
//		        } 

		//===Create Asset===
		if (assetFileName != null) {
			RequestInterface assetInfo;
			            String base64Data = Base64Utility.encode(Base64Utility.fileToByteArray(assetFileName));
			            assetInfo = new AssetRequest(assetFileName, base64Data);
			assetInfo = new AssetRequest("Test 4 Gabe", "VGVzdDE=");
			assetInfo.setMethodType(Method.POST);
			//            assetInfo.setRequestUri(baseUrl + "/masters/" + masterId + "/assets");
			assetInfo.setRequestUri(baseUrl);
			client = new Client(protocols);
			statusUri = svc.asynchronousRequest(client, assetInfo);
			status = svc.waitUntilComplete(client, statusUri, 3);
			logger.info(status.getStatusMessage());
		}

//		        //===Get Subscriber===
//		        client = new Client(protocols);
//		        RequestInterface getSubscriberInfo = new GetSubscriberRequest(subscriberEmail);
//		        getSubscriberInfo.setMethodType(Method.GET);
//		        getSubscriberInfo.setRequestUri(baseUrl + "/subscribers?email=" + subscriberEmail );
//		        String userId = svc.synchronousRequest(client, getSubscriberInfo);
//				logger.info("GET Subscriber returned userId: " + userId );
		
		        //===Subscribe User===
//		        if (userId == null) {
//		            client = new Client(protocols);
//		            RequestInterface subscriberInfo = new CreateSubscriberRequest(NEW_SUBSCRIBER_MAP );
//		            subscriberInfo.setMethodType(Method.POST);
//		            subscriberInfo.setRequestUri(baseUrl + "/subscribers" );
//		            statusUri = svc.asynchronousRequest(client, subscriberInfo);
//		            status = svc.waitUntilComplete(client, statusUri, 20);
//		            logger.info(status.getStatusMessage());
//		            userId =  status.getFinalResourceUriLastVal();
//		            logger.info("POST Subscriber created  userId: " + userId);
//		        } else {
//		            //===Update User===
//		            client = new Client(protocols);
//		            RequestInterface updateSubscriberInfo = new UpdateSubscriberRequest(UPDATE_SUBSCRIBER_MAP);
//		            updateSubscriberInfo.setMethodType(Method.PUT);
//		            updateSubscriberInfo.setRequestUri(baseUrl + "/subscribers/" + userId );
//		            statusUri = svc.asynchronousRequest(client, updateSubscriberInfo);
//		            status = svc.waitUntilComplete(client, statusUri, 20);
//		            logger.info(status.getStatusMessage());
//		        }
//		
//		         //===Trigger Message===
//		         client = new Client(protocols);
//		         RequestInterface triggeredMessagingInfo = new TriggeredMessagingRequest(masterId);
//		        triggeredMessagingInfo.setMethodType(Method.POST);
//		        triggeredMessagingInfo.setRequestUri(baseUrl + "/subscribers/" + userId + "/message");
//		        statusUri = svc.asynchronousRequest(client, triggeredMessagingInfo);
//		        status = svc.waitUntilComplete(client, statusUri, 10);
//		        logger.info(status.getStatusMessage());
//		        String messageId =  status.getFinalResourceUriLastVal();
//		        logger.info("POST Trigger Message returned messageId: " + messageId);
//		    
	}

	/**
	 * The method to submit a request to an asynchronous API.  The response
	 * will be parsed to get a status URI.  This URI will be polled until the
	 * API process completes or the API process times out.
	 *
	 * @param client  The <code>Client</code> to send the request to.
	 * @param requestInfo  Represents the API request to be submitted.
	 * @return  the status URI to be polled until the API processes the request.
	 * @throws RuntimeException when the request failed to submit to the API.
	 */
	public String asynchronousRequest(Client client, RequestInterface requestInfo) {

		if (XMLorJSON.equals("XML")) {
			logger.info("requestInfo.toXml()=" + requestInfo.toXml());
		} else if (XMLorJSON.equals("JSON")) {
			logger.info("requestInfo.toJson()=" + requestInfo.toJson());
		}

		Request request = new Request(requestInfo.getMethodType(), requestInfo.getRequestUri());

		// Provide credentials
		ChallengeResponse challengeResponse = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, userName, password);
		request.setChallengeResponse(challengeResponse);

		if (XMLorJSON.equals("XML")) {
			request.setEntity(requestInfo.toXml(), MediaType.APPLICATION_XML);
		} else if (XMLorJSON.equals("JSON")) {
			request.setEntity(requestInfo.toJson(), MediaType.APPLICATION_JSON);
		}

		logger.info("Sending payload to: " + requestInfo.getRequestUri());
		Response response = client.handle(request);
		Reference ref = response.getLocationRef();

				if(response.getStatus().getCode() != Status.SUCCESS_ACCEPTED.getCode()) {
					throw new RuntimeException("Operation has failed: " + response.getStatus().getDescription());
				} else {
					logger.info("Your job has been submitted, its status can be checked using this url: " + ref);
					return ref.toString();
				}
	}

	/**
	 * The method to submit a request to a synchronous API.  The response
	 * will be processed to get the return value.
	 *
	 * @param client  The <code>Client</code> to send the request to.
	 * @param requestInfo  Represents the API request to be submitted.
	 * @return the value returned from the synchronous API call.
	 * @throws RuntimeException when the request failed to submit to the API.
	 */
	public String synchronousRequest(Client client, RequestInterface requestInfo) {

		if (XMLorJSON.equals("XML")) {
			logger.info("requestInfo.toXml()=" + requestInfo.toXml());
		} else if (XMLorJSON.equals("JSON")) {
			logger.info("requestInfo.toJson()=" + requestInfo.toJson());
		}

		Request request = new Request(requestInfo.getMethodType(), requestInfo.getRequestUri());

		// Provide credentials
		ChallengeResponse challengeResponse = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, userName, password);
		request.setChallengeResponse(challengeResponse);

		if (XMLorJSON.equals("XML")) {
			request.setEntity(requestInfo.toXml(), MediaType.APPLICATION_XML);
		} else if (XMLorJSON.equals("JSON")) {
			request.setEntity(requestInfo.toJson(), MediaType.APPLICATION_JSON);
		}

		logger.info("Sending payload to: " + requestInfo.getRequestUri());
		Response response = client.handle(request);

		if(response.getStatus().getCode() == Status.CLIENT_ERROR_NOT_FOUND.getCode()) {
			return null;
		} else 	if(response.getStatus().getCode() != Status.SUCCESS_OK.getCode()) {
			throw new RuntimeException("Operation has failed: " + response.getStatus().getDescription());
		} else {
			StatusResponse status = null;
			try {
				status = new StatusResponse( response.getEntity().getStream());
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
			logger.info("Your job has been submitted, and the returned response is: " + status.getUriLastVal() );
			return status.getUriLastVal();
		}
	}

	/**
	 * The method that polls the status URI.
	 *
	 * @param statusUri The URI to poll until the API completes or times out.
	 * @return 
	 * @throws TimeoutException if the API doesn't complete within a specific
	 * time.
	 * @throws IOException 
	 */
	public StatusResponse waitUntilComplete(Client client, String statusUri, int pollingRetries) throws TimeoutException, IOException {
		// Prepare the request
		Request request = new Request(Method.GET, statusUri);

		// Specify preferred Content-Types
		List<Preference<MediaType>> acceptedMediaTypes = new ArrayList<Preference<MediaType>>(1);
		acceptedMediaTypes.add(new Preference<MediaType>(MediaType.APPLICATION_XML));
		request.getClientInfo().setAcceptedMediaTypes(acceptedMediaTypes);

		// Provide credentials
		ChallengeResponse challengeResponse = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, userName, password);
		request.setChallengeResponse(challengeResponse);

		Response response = null;
		int retryCount = 0;
		while(retryCount++ < pollingRetries) {
			logger.info("Checking on status of the request...");
			response = client.handle(request);
			int respHttpCode = response.getStatus().getCode();
			System.out.println(respHttpCode);
			
			 			if(respHttpCode == Status.SUCCESS_OK.getCode() | respHttpCode == Status.valueOf(202).getCode()) {
							try {
								StatusResponse status = new StatusResponse( response.getEntity().getStream());
								if(status.requestCompleted()) {
									return status;
								}
			                } catch(IOException ioe) {
			                    ioe.printStackTrace();
			                }
						} else if (respHttpCode == Status.CLIENT_ERROR_NOT_FOUND.getCode()) {
							throw new IllegalArgumentException("Bad status resource specified: " + statusUri);
						} else {
			                 throw new RuntimeException("Returned statusCode was not OK.  Stopping execution.");
			             }
					}
					throw new TimeoutException("Task failed to complete within the expected time.");
			
		}
		
		
	}

