package com.manulife.jp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
 
	@RequestMapping("/api/hi")
	public String hi() {
		return "Hello World from Restful API";
	}
	
	public static final String client_id="e71b7758-4da4-4343-a58e-2b8e544b21c0";
	public static final String client_secret=" BzO+Y5+2ImQXvp2wYvGEfh9wI0SYuZmLvDvF/6nZqbY= ";
	public static final String client_credentials="grant_type";
	public static final String Resource="https://graph.microsoft.com";
	
	
	@RequestMapping("/getData")
	public String getAzureData() throws ClientProtocolException, IOException {
	String url_str = "https://graph.microsoft.com/v1.0/users";
	CredentialsProvider provider = new BasicCredentialsProvider();
	UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
	"Tetsuaki_Matsumoto@mljpabeta.onmicrosoft.com", "Jud4105501");
	provider.setCredentials(AuthScope.ANY, credentials);
	HttpClient client = HttpClientBuilder.create()
	.setDefaultCredentialsProvider(provider).build();
	HttpGet request = new HttpGet(url_str);
	String token1 = "Bearer eyJ0eXAiOiJKV1QiLCJub25jZSI6IkFRQUJBQUFBQUFDRWZleFh4amFtUWIzT2VHUTRHdWd2X1NRZmtHYzdoMmt4Zm9GQzRPcjl0SzE1X1oyZGRyZnJEenM4WjdyNGdYRGRxUmVzbktJWlFxXzRYcVBlYlZtUmYtN19uTThsSGoxM2FvdGlIUERua2lBQSIsImFsZyI6IlJTMjU2IiwieDV0IjoiLXN4TUpNTENJRFdNVFB2WnlKNnR4LUNEeHcwIiwia2lkIjoiLXN4TUpNTENJRFdNVFB2WnlKNnR4LUNEeHcwIn0.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84OThmNDVmMy02OTE5LTRjOTgtODJlNi02MjFiYmZmYTFjZjAvIiwiaWF0IjoxNTUwNDY3NTQ1LCJuYmYiOjE1NTA0Njc1NDUsImV4cCI6MTU1MDQ3MTQ0NSwiYWlvIjoiNDJJQWdwWExqZGRkL0xMZ2prVytSby85K1cwQSIsImFwcF9kaXNwbGF5bmFtZSI6InBvc3RtYW5fVGVzdCIsImFwcGlkIjoiZTcxYjc3NTgtNGRhNC00MzQzLWE1OGUtMmI4ZTU0NGIyMWMwIiwiYXBwaWRhY3IiOiIxIiwiaWRwIjoiaHR0cHM6Ly9zdHMud2luZG93cy5uZXQvODk4ZjQ1ZjMtNjkxOS00Yzk4LTgyZTYtNjIxYmJmZmExY2YwLyIsIm9pZCI6IjIwZDM4Y2U4LTZjMjQtNDIxZC04ZjExLTlkMDk0MGFjNTY3NCIsInJvbGVzIjpbIlVzZXIuUmVhZFdyaXRlLkFsbCIsIkRpcmVjdG9yeS5SZWFkV3JpdGUuQWxsIiwiRGlyZWN0b3J5LlJlYWQuQWxsIiwiVXNlci5SZWFkLkFsbCJdLCJzdWIiOiIyMGQzOGNlOC02YzI0LTQyMWQtOGYxMS05ZDA5NDBhYzU2NzQiLCJ0aWQiOiI4OThmNDVmMy02OTE5LTRjOTgtODJlNi02MjFiYmZmYTFjZjAiLCJ1dGkiOiJyOUQ1dE5kUlNFdWtDX3pLQXlBOUFBIiwidmVyIjoiMS4wIiwieG1zX3RjZHQiOjE1MjU4Mzc5NzJ9.Ns4NO1DyAEEza18isOG57va9yXi3WVTd8NcQ-cllq_h8db3Xr1837WZoYd5rDlLKImF-NTIf0BztcrIFW6TTcg2fY--cgtYbsjAsFOzBD6q9roa5aLHYbuUJCP5ig1n-tsRYgbUpB_frWBFNbjBKluVyVCs6n-Pck_vMNobfumTiljwZKE-q0VYSjEiMgAowrT4cQQWeiWBHxlO4j8ltch8DF1e_Vo0t0r3sEIKvPZsM0g1ScmS5QUEjatM3rKvwv02SMklU8_YTlkmt8QgNEJLvEIGecOKYDXFeq1OXCshlMQwztdkrVfSUcYWmpj7blh21-JdSLlMtYRBIkspQhg";
	request.setHeader("Authorization", token1);
	request.setHeader("Content-Type", "application/json");
	HttpResponse response = client.execute(request);
	System.out.println("\nSending 'GET' request to URL : " + url_str);
	System.out.println("Response Code : "
	+ response.getStatusLine().getStatusCode());
	
	BufferedReader rd = new BufferedReader(new InputStreamReader(response
	.getEntity().getContent()));
	
	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
	result.append(line);
}

		System.out.println(result.toString());
/*String access_token = "Bearer eyJ0eXAiOiJKV1QiLCJub25jZSI6IkFRQUJBQUFBQUFDNXVuYTBFVUZnVElGOEVsYXh0V2pUd2hKZXdxT1JCeDZzYVNzUWpudmtON3BnZThRbG5ZVzRZLUR2SW5icHpnLW9DMmdnaEc2NjlJcmo2T1FUeTBhUDRDVThsVXZ0WVBYN0hFV3d3LXE5enlBQSIsImFsZyI6IlJTMjU2IiwieDV0Ijoid1VMbVlmc3FkUXVXdFZfLWh4VnRESkpaTTRRIiwia2lkIjoid1VMbVlmc3FkUXVXdFZfLWh4VnRESkpaTTRRIn0.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84OThmNDVmMy02OTE5LTRjOTgtODJlNi02MjFiYmZmYTFjZjAvIiwiaWF0IjoxNTQzOTkwNDg4LCJuYmYiOjE1NDM5OTA0ODgsImV4cCI6MTU0Mzk5NDM4OCwiYWlvIjoiNDJSZ1lGaWt6YTY2VUZwZWlsZTc3a1JnT1ZNOEFBPT0iLCJhcHBfZGlzcGxheW5hbWUiOiJwb3N0bWFuX1Rlc3QiLCJhcHBpZCI6ImU3MWI3NzU4LTRkYTQtNDM0My1hNThlLTJiOGU1NDRiMjFjMCIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0Lzg5OGY0NWYzLTY5MTktNGM5OC04MmU2LTYyMWJiZmZhMWNmMC8iLCJvaWQiOiIyMGQzOGNlOC02YzI0LTQyMWQtOGYxMS05ZDA5NDBhYzU2NzQiLCJyb2xlcyI6WyJVc2VyLlJlYWRXcml0ZS5BbGwiLCJEaXJlY3RvcnkuUmVhZFdyaXRlLkFsbCIsIkRpcmVjdG9yeS5SZWFkLkFsbCIsIlVzZXIuUmVhZC5BbGwiXSwic3ViIjoiMjBkMzhjZTgtNmMyNC00MjFkLThmMTEtOWQwOTQwYWM1Njc0IiwidGlkIjoiODk4ZjQ1ZjMtNjkxOS00Yzk4LTgyZTYtNjIxYmJmZmExY2YwIiwidXRpIjoiOHN5bjBNaFJZVXlram9XVVZuZ1BBQSIsInZlciI6IjEuMCIsInhtc190Y2R0IjoxNTI1ODM3OTcyfQ.MtuC_qucQEbnRpgxZvvRW7VQOsKxt7krA5NMDHnIblUwrXrJ8Ddq7EZ-6CdV68iu7WuK3K-rvo6NWVK0_Yp_iA-lvYAc8OjsBTaZfRj40bXw-fbduEUR8Xmps5ecer7EkvEKKzjvppaXoQNZl5FNxsZ63dBFrxMIxuG_BLvsK6F6b-n7uB5YvS6ov2-CeS7s_5st65-dQyklbwquVfY_uvVKrLRKBl9cKe_ZpugQjlSUqNZ9kWfIPavCpg4H3Qik1YLz89dWIZPKoy6w4PWQ62WSfwQ29b7TapW7oBKm-O6U7O4hfhU_O_3p8vxjMcVH7UPFKWpNN3qSCGOagrtOIg";
URL obj = new URL(url_str);
HttpURLConnection  con = ( HttpURLConnection )obj.openConnection();
    con.setDoInput(true);
    con.setDoOutput(true);
    con.setUseCaches(false);
    con.setRequestMethod("GET");
    con.setRequestProperty("Authorization", access_token);
    con.setRequestProperty("Accept","application/json");
    con.connect();

    BufferedReader br = new BufferedReader(new InputStreamReader( con.getInputStream() ));
    String str = null;
    String line;
    while((line = br.readLine()) != null) {
        str += line;
    }
    System.out.println(str);*/
return result.toString();
    
}
	
	@RequestMapping("/gettoken")
	private String getToken() throws Exception {

		Properties sysProperties = System.getProperties();
		sysProperties.put("proxySet", "true");
		sysProperties.put("http.proxyHost", "proxy-src.research.ge.com");
		sysProperties.put("http.proxyPort", "8080");

		String url = "https://login.microsoftonline.com/898f45f3-6919-4c98-82e6-621bbffa1cf0/oauth2/token";

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		/*HttpHost proxy = new HttpHost("proxy-src.research.ge.com", 8080, "http");
		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		post.setConfig(config);
		post.setConfig(config);*/

		// add header
		// post.setHeader("User-Agent", USER_AGENT);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");

		// add basic authentication
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
				"Tetsuaki_Matsumoto@mljpabeta.onmicrosoft.com", "Jud4105501");
		provider.setCredentials(AuthScope.ANY, credentials);
		HttpClient client1 = HttpClientBuilder.create()
				.setDefaultCredentialsProvider(provider).build();

		String payLoad = "client_secret=BzO+Y5+2ImQXvp2wYvGEfh9wI0SYuZmLvDvF/6nZqbY=&client_id=e71b7758-4da4-4343-a58e-2b8e544b21c0&grant_type=client_credentials&Resource=https://graph.microsoft.com";
	
		StringEntity se = new StringEntity(payLoad);
		post.setEntity(se);
		
		/*List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("client_id", client_id));
		params.add(new BasicNameValuePair("client_secret", client_secret));
		params.add(new BasicNameValuePair("grant_type", client_credentials));
		params.add(new BasicNameValuePair("Resource", Resource));
		post.setEntity(new UrlEncodedFormEntity(params));*/
		
		HttpResponse response = client1.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : "
				+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		//JSONObject obj = new JSONObject();

		String TOKEN = result.toString();
		System.out.println(TOKEN);
		return TOKEN;

	}
}