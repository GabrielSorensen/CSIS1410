import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
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

import com.yesmail.wsapiclient.CompositeAPIServices;
import com.yesmail.wsapiclient.util.AssetRequest;
import com.yesmail.wsapiclient.util.RequestInterface;
import com.yesmail.wsapiclient.util.StatusResponse;


public class Post2 {

	private final static String CONFIG = "config";
	private final static String baseUrl = "https://enterprise7.yesmail.com/#contentBlock?id=9";
	private final static String userName = "zions/apiuser";
	private final static String password = "zBKut3649";
	private final static String XMLorJSON = "XML";
	//    private final static String CREATEorUPDATEmaster;
	//    private final static String subscriberEmail;
	private final static Logger logger = Logger.getLogger("com.yesmail.wsapiclient");
	private static final DateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");


	public static void main(String[] args) throws ClientProtocolException, IOException, TimeoutException {
		String toEncode = "";
		String assetFileName = null;

		List<Protocol> protocols = new ArrayList<Protocol>();
		protocols.add(Protocol.HTTP);
		protocols.add(Protocol.HTTPS);
		Client client;
		CompositeAPIServices svc = new CompositeAPIServices();
		String statusUri;
		StatusResponse status;

		toEncode = grabHTML();
		//encoding happens in below line
		byte[] encodedArr = Base64.encodeBase64(toEncode.getBytes());
		//String to be passed to post
		String encodedPayload = new String(encodedArr);
		String xmlPayLoadHTML = "<?xml version='1.0'?><yesws:asset xmlns:yesws='https://services.yesmail.com' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='https://services.yesmail.com docs/xsd/asset.xsd'>"+"<yesws:assetName>html</yesws:assetName><yesws:assetBase64Data>"+new String(encodedArr)+"</yesws:assetBase64Data></yesws:asset>";
		//console readings of data
		System.out.println("Original String: " + toEncode );
		//System.out.println("Base64 Encoded String : " + new String(encodedArr);
		System.out.println("\n"+xmlPayLoadHTML);

		getHTML(9);

		//===Create Asset===
		if (assetFileName == null) {
			RequestInterface assetInfo;
			//            String base64Data = Base64Utility.encode(Base64Utility.fileToByteArray(assetFileName));
			//            assetInfo = new AssetRequest(assetFileName, base64Data);
			assetInfo = new AssetRequest("Test 4 Gabe", encodedPayload);
			assetInfo.setMethodType(Method.POST);
			//            assetInfo.setRequestUri(baseUrl + "/masters/" + masterId + "/assets");
			assetInfo.setRequestUri(baseUrl);
			client = new Client(protocols);
			statusUri = svc.asynchronousRequest(client, assetInfo);
			status = svc.waitUntilComplete(client, statusUri, 3);
			logger.info(status.getStatusMessage());
		}

	}

	public static String grabHTML() {
		String encodeMe = "";
		URL u = null;
		try {
			u = new URL("https://www.zionsdirect.com/NotPublic/CurrentTable_FromFile.php");
		} catch (MalformedURLException e3) {
			e3.printStackTrace();
		}
		URLConnection c = null;
		try {
			c = u.openConnection();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		InputStream r = null;
		try {
			r = c.getInputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(r));
		try {
			for(String line; (line = reader.readLine()) != null;) encodeMe+=line;
		} catch (IOException e) {
			e.printStackTrace();
		} //grabs all content from site and converts to byte array
		return encodeMe;
	}

	public static void getHTML(int block) throws ClientProtocolException , IOException {
		//getHTML grabs all data contained in the selected block
		int content = block;

		DefaultHttpClient httpclient = new DefaultHttpClient();


		String userName ="zions/ffaruque" ;
		String password ="ZDw3bd3v";
		// Provide credentials
		ChallengeResponse challengeResponse = new ChallengeResponse(ChallengeScheme.HTTP_BASIC, userName , password );

		ArrayList<String> authpref = new ArrayList<String>();
		authpref.add(AuthPolicy.BASIC);
		httpclient.getParams().setParameter(AuthPNames.PROXY_AUTH_PREF, authpref);
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(AuthScope.ANY), 
				new UsernamePasswordCredentials("zions/ffaruque" , "ZDw3bd3v"));
		HttpGet httpget = null;
		try {
			httpget = new HttpGet("https://services.yesmail.com/enterprise/contentblocks/"+content);
		} catch (Exception e) {
			System.out.println("Im broke at line 91");
			e.printStackTrace();
		}
		httpget.addHeader("Content-type", "text/xml; UFT-8");
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
		} catch (Exception e) {
			System.out.println("Im broke at line 99");
			e.printStackTrace();
		}
		System.out.println(response.getStatusLine());
		HttpEntity entity = response.getEntity();
		System.out.println("entity: "+entity);
		System.out.println("response: "+response);

		//		// Prepare a request object
		//		HttpContext localContext = new BasicHttpContext();
		//		HttpGet httpget = new HttpGet("https://services.yesmail.com/enterprise/contentblocks/"+content);
		//		httpget.addHeader("Content-type", "text/xml; UFT-8");
		//		// Create AuthCache instance
		//		AuthCache authCache = new BasicAuthCache();
		//		// Generate BASIC scheme object and add it to the local auth cache
		//		BasicScheme basicAuth = new BasicScheme();
		//		authCache.put(targetHost, basicAuth);
		//
		//		// Add AuthCache to the execution context
		//		BasicHttpContext localcontext = new BasicHttpContext();
		//		localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);        
		//		AuthState proxyAuthState = (AuthState) localContext.getAttribute(
		//			    ClientContext.PROXY_AUTH_STATE);
		//			AuthState targetAuthState = (AuthState) localContext.getAttribute(
		//			    ClientContext.TARGET_AUTH_STATE);
		//		// Execute the request
		//		HttpResponse response = null;
		//		try {
		//			response = httpclient.execute(httpget);
		//			
		//		} catch (ClientProtocolException e2) {
		//			e2.printStackTrace();
		//		} catch (IOException e2) {
		//			e2.printStackTrace();
		//		}
		//		// Examine the response status
		//		System.out.println(response.getStatusLine());
		//		JOptionPane.showMessageDialog(null, response.getStatusLine(), "Result:",  JOptionPane.WARNING_MESSAGE);
		//		// Get hold of the response entity
		//		HttpEntity entity = response.getEntity();
		//		
		//		// If the response does not enclose an entity, there is no need
		//		// to worry about connection release
		//		if (entity != null) {
		//		    InputStream instream = null;
		//			try {
		//				instream = entity.getContent();
		//			} catch (IllegalStateException | IOException e1) {
		//				e1.printStackTrace();
		//			}
		//		    try {
		//		        // do something useful with the response
		//		        //System.out.println(reader.readLine());
		//		    } catch (RuntimeException ex) {
		//		        // In case of an unexpected exception you may want to abort
		//		        // the HTTP request in order to shut down the underlying
		//		        // connection and release it back to the connection manager.
		//		        httpget.abort();
		//		        throw ex;
		//		    } finally {
		//		        // Closing the input stream will trigger connection release
		//		        try {
		//					instream.close();
		//				} catch (IOException e) {
		//					e.printStackTrace();
		//				}
		//		    }
		//		}

		//		//authenticate to URI
		//		HttpHost targetHost = new HttpHost("localhost", 80, "http"); 
		//		DefaultHttpClient httpclient = new DefaultHttpClient();
		//		httpclient.getCredentialsProvider().setCredentials(
		//				new AuthScope(targetHost.getHostName(), targetHost.getPort()), 
		//				new UsernamePasswordCredentials("zions*ffaruque", "ZDw3bd3v"));
		//		// Create AuthCache instance
		//		AuthCache authCache = new BasicAuthCache();
		//		// Generate BASIC scheme object and add it to the local auth cache
		//		BasicScheme basicAuth = new BasicScheme();
		//		authCache.put(targetHost, basicAuth);
		//		// Add AuthCache to the execution context
		//		BasicHttpContext localcontext = new BasicHttpContext();
		//		localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
		//
		//		//start GET from selected block
		//		DefaultHttpClient httpClient = new DefaultHttpClient();
		//		HttpGet getRequest = new HttpGet("https://services.yesmail.com/enterprise/contentblocks/"+content);
		//		getRequest.addHeader("Content-type", "text/xml; UFT-8");
		//		HttpResponse response = null;
		//		try {
		//			response = httpClient.execute(getRequest);
		//		} catch (ClientProtocolException e1) {
		//			e1.printStackTrace();
		//		} catch (IOException e1) {
		//			e1.printStackTrace();
		//		}
		//
		//		if (response.getStatusLine().getStatusCode() != 200 | response.getStatusLine().getStatusCode() != 202) {
		//			throw new RuntimeException("Failed : HTTP response code : "+ response.getStatusLine().getStatusCode());
		//		}
		//		if (response.getStatusLine().getStatusCode() == 200 | response.getStatusLine().getStatusCode() == 202) {
		//			throw new RuntimeException("Success : HTTP response code : "+ response.getStatusLine().getStatusCode());
		//		}
		//		BufferedReader br = null;
		//		try {
		//			br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		//		} catch (IllegalStateException | IOException e) {
		//			e.printStackTrace();
		//		}
		//		String output;
		//		System.out.println("Output from Server .... \n");
		//		try {
		//			while ((output = br.readLine()) != null) {
		//				System.out.println(output);
		//			}
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
		//		httpClient.getConnectionManager().shutdown();
	}

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

		//		if(response.getStatus().getCode() != Status.SUCCESS_ACCEPTED.getCode()) {
		//			throw new RuntimeException("Operation has failed: " + response.getStatus().getDescription());
		//		} else {
		//			logger.info("Your job has been submitted, its status can be checked using this url: " + ref);
		//			return ref.toString();
		//		}
		System.out.println(response.getStatus().getCode());
		//return ref.toString();
		return "Good?";
	}

	public StatusResponse waitUntilComplete(Client client, String statusUri, int pollingRetries) throws TimeoutException {
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
			if(respHttpCode == Status.SUCCESS_OK.getCode()) {
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


	//	public static void postHTML(String a, int block) {
	//		int content = block;
	//		String payload = a;
	//
	//		//authenticate to URI
	//		HttpHost targetHost = new HttpHost("localhost", 80, "http"); 
	//		DefaultHttpClient httpclient = new DefaultHttpClient();
	//		httpclient.getCredentialsProvider().setCredentials(
	//				new AuthScope(targetHost.getHostName(), targetHost.getPort()), 
	//				new UsernamePasswordCredentials("ffaruque", "ZDw3bd3v"));
	//		// Create AuthCache instance
	//		AuthCache authCache = new BasicAuthCache();
	//		// Generate BASIC scheme object and add it to the local auth cache
	//		BasicScheme basicAuth = new BasicScheme();
	//		authCache.put(targetHost, basicAuth);
	//		// Add AuthCache to the execution context
	//		BasicHttpContext localcontext = new BasicHttpContext();
	//		localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);    
	//
	//		//start POST using payload and block
	//		try {
	//			DefaultHttpClient httpClient = new DefaultHttpClient();
	//			HttpPost postRequest = new HttpPost("https://services.yesmail.com/enterprise/contentblocks/"+content);
	//			postRequest.addHeader("Content-type", "text/xml; UFT-8");
	//			StringEntity input = new StringEntity(payload);
	//			input.setContentType("XML");
	//			postRequest.setEntity(input);
	//			HttpResponse response = httpClient.execute(postRequest);
	//			if (response.getStatusLine().getStatusCode() != 200 | response.getStatusLine().getStatusCode() != 202) {
	//				throw new RuntimeException("Failed : HTTP response code : "+ response.getStatusLine().getStatusCode());
	//			}
	//			if (response.getStatusLine().getStatusCode() == 200 | response.getStatusLine().getStatusCode() == 202) {
	//				throw new RuntimeException("Success : HTTP response code : "+ response.getStatusLine().getStatusCode());
	//			}
	//			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
	//			String output;
	//			System.out.println("Output from Server .... \n");
	//			while ((output = br.readLine()) != null) {
	//				System.out.println(output);
	//			}
	//			httpClient.getConnectionManager().shutdown();
	//		} catch (MalformedURLException e) {
	//			e.printStackTrace();
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}

	//	}

	//Http Response Codes   / Description 
	//			200			Request Successful
	//			202			Request Accepted
	//			400			Malformed Request
	//			401			Authentication Failed
	//			404			Resource not Found
	//			500			Internal Server Error
	//			503			Service Temporarily Unavailable

}
