package com.hdfc.capstone.clientwebservice;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	
	/*We need to provide local host as a subject alternative name as we are accessing without a secure valid ssl.
	 *We can do that by provide the following additional parameter: -ext "SAN:c=DNS:localhost,IP:127.0.0.1" while generating the keystore
	
	 *The SAN field will be used to match the hostname, which will be provided in the request. 
	 *So when you are running your application on localhost, lets say https://localhost:8443,
	 *and you also want to make a request to that specific host, 
	 *then that hostname should also be available within the SAN field; otherwise, it will fail during the handshake process.
	*/
	
	
	@Bean
	RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException,
												KeyStoreException, CertificateException, IOException  {
		
		URL trustStoreUrl = new URL("file:src/main/resources/keystore/identity.p12");
		char[] trustStorePass = "halosahil@123456".toCharArray();
		
		SSLContext sslContext = new SSLContextBuilder()
				.loadTrustMaterial(trustStoreUrl, trustStorePass).build();
		SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext);

		HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslConFactory).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		return new RestTemplate(requestFactory);
		}
	
}
