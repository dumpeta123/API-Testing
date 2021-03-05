package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// GET Method
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http GET Request
		CloseableHttpResponse httpResponse = httpClient.execute(httpget); // hit the GET url

		// a. Status Code
		int statuscode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("status code---->" + statuscode);

		// b.JSON String
		String responsestring = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		JSONObject responsejson = new JSONObject(responsestring);
		System.out.println("Response JSON from API--->" + responsejson);

		// c. All Headers

		Header[] headerArray = httpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array" + allHeaders);

	}

}
