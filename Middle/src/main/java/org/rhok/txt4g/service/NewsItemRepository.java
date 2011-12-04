package org.rhok.txt4g.service;

import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.rhok.txt4g.model.Feed;
import org.rhok.txt4g.model.NewsItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
@Resource
public interface NewsItemRepository extends MongoRepository<NewsItem, ObjectId>, QueryDslPredicateExecutor<NewsItem> {
	NewsItem findById(String id);
	List<NewsItem> findByFeed(Feed feed);
}