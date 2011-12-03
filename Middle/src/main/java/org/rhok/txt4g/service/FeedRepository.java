package org.rhok.txt4g.service;

import org.bson.types.ObjectId;
import org.rhok.txt4g.model.Feed;
import org.springframework.data.repository.CrudRepository;

public interface FeedRepository extends CrudRepository<Feed, ObjectId> {

	Feed findById(String id);
	Feed findByName(String name);
	Feed findBySmsIdentifier(String smsIdentifier);
}
