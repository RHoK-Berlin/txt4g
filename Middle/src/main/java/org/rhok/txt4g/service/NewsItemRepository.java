package org.rhok.txt4g.service;

import org.bson.types.ObjectId;
import org.rhok.txt4g.model.Feed;
import org.rhok.txt4g.model.NewsItem;
import org.springframework.data.repository.CrudRepository;

public interface NewsItemRepository extends CrudRepository<NewsItem, ObjectId> {
	NewsItem findById(String id);
	NewsItem findByFeed(Feed feed);
}