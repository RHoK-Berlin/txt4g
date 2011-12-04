package org.rhok.txt4g.execution;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.rhok.txt4g.model.Feed;
import org.rhok.txt4g.model.NewsItem;
import org.springframework.data.mongodb.core.MongoOperations;

public class SmsFeedJob extends MessageJob {
	private MongoOperations mongoOps;
	private String smsServicePath = "/sms/send";
	private String smsServiceAthority = "http";
	private int smsServicePort = 80;
	private String smsServiceHost = "rhoksmsify.herokuapp.com";
	private List<String> sentItemsIds = new LinkedList<String>();
	private Date lastSend = new Date(0L);

	public SmsFeedJob(final MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public void run() {
		List<Feed> feeds = mongoOps.findAll(Feed.class, "feeds");
		List<NewsItem> newsItems = mongoOps.findAll(NewsItem.class, "news_items");


		for (Feed feed : feeds) {
			if (feed != null) {
				for (NewsItem item : newsItems) {
					if (item.getFeed_id().equals(feed.getId().toString()) && feed.getCreated_at().getTime() > lastSend.getTime()) {
						for (String number : feed.getSubscriber_phones()) {
							HttpClient client = new DefaultHttpClient();
							HttpPost method = new HttpPost(smsServiceAthority + "://"
									+ smsServiceHost + ":" + smsServicePort + smsServicePath);
							HttpParams params = new BasicHttpParams();
							params.setParameter(URLEncoder.encode("sms[to]"), URLEncoder.encode("\"" + number + "\""));
							params.setParameter(URLEncoder.encode("sms[body]"), URLEncoder.encode("\"" + item.getText() + "\""));
							
							List<NameValuePair> postParams = new ArrayList<NameValuePair>();
							postParams.add(new BasicNameValuePair("",""));

							postParams.add(new BasicNameValuePair("sms[to]", "\"" + number + "\""));
							postParams.add(new BasicNameValuePair("sms[body]", "\"" + item.getText() + "\""));
							
							UrlEncodedFormEntity entity;
							try {
								entity = new UrlEncodedFormEntity(postParams);
								entity.setContentEncoding(HTTP.UTF_8);
								method.setEntity(entity);
							} catch (UnsupportedEncodingException e1) {
								e1.printStackTrace();
							}


							try {
								//System.out.println(method.getRequestLine());
								HttpResponse response = client.execute(method);
							} catch (IOException e) {
							}
							lastSend = new Date();
						}
					}
				}
			}
		}
	}
}