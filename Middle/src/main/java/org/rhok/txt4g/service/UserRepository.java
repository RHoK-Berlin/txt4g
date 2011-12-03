package org.rhok.txt4g.service;

import org.bson.types.ObjectId;
import org.rhok.txt4g.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, ObjectId> {
	User findById(ObjectId id);
}
