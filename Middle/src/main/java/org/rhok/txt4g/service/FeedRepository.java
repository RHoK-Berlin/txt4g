package org.rhok.txt4g.service;

import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.rhok.txt4g.model.Feed;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * FeedRepository class.
 * 
 * @author ddebray, mwinter
 * 
 */
@Resource
public interface FeedRepository extends MongoRepository<Feed, ObjectId> {

	Feed findById(String id);
	Feed findByName(String name);
	Feed findBySmsIdentifier(String smsIdentifier);
}
