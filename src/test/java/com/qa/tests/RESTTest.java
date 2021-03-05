package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class RESTTest extends TestBase {

	TestBase testBase;
	String serviceurl;
	String apiurl;
	String url;
	RestClient restclient;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiurl = prop.getProperty("ServerURL");

		url = serviceurl + apiurl;

	}

	@Test
	public void getapitest() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		restclient.get(url);

	}
}
