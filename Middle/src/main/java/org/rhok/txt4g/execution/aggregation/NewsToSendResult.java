package org.rhok.txt4g.execution.aggregation;

import java.util.Collection;

import com.mongodb.MapReduceOutput;

public class NewsToSendResult {
	private String newsID;
	private Collection<String> phones;

	public Collection<String> getPhones() {
		return phones;
	}

	public void setPhones(Collection<String> phones) {
		this.phones = phones;
	}

	public String getNewsID() {
		return newsID;
	}

	public void setNewsID(String newsID) {
		this.newsID = newsID;
	}
}