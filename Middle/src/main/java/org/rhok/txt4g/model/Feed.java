package org.rhok.txt4g.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feed {
	@Id
	private ObjectId id;
	private String name;
	private String smsIdentifier;
	private List<NewsItem> newsItems;
	private List<String> subscriber_phones;
	private Date created_at;
	
	public List<String> getSubscriber_phones() {
		return subscriber_phones;
	}
	public void setSubscriber_phones(List<String> subscriber_phones) {
		this.subscriber_phones = subscriber_phones;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSmsIdentifier() {
		return smsIdentifier;
	}
	public void setSmsIdentifier(String smsIdentifier) {
		this.smsIdentifier = smsIdentifier;
	}
	public List<NewsItem> getNewsItems() {
		return newsItems;
	}
	public void setNewsItems(List<NewsItem> newsItems) {
		this.newsItems = newsItems;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
}