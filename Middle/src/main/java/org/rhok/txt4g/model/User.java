package org.rhok.txt4g.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User entity class.
 * 
 * @author ddebray, mwinter
 * 
 */
@Document
public class User {
	@Id
	private ObjectId id;
	private String PhoneNumber;
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
}