package org.rhok.txt4g.model;

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
	private Set<NewsItem> newsItems;
	
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
	public Set<NewsItem> getNewsItems() {
		return newsItems;
	}
	public void setNewsItems(Set<NewsItem> newsItems) {
		this.newsItems = newsItems;
	}
	public void setPid(String string) {
		// TODO Auto-generated method stub
		
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
}