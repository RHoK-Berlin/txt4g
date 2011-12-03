//package org.rhok.txt4g.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import javax.annotation.Resource;
//
//import org.apache.log4j.Logger;
//import org.rhok.txt4g.exception.EntityNotFoundException;
//import org.rohok.txt4g.model.Feed;
//import org.rohok.txt4g.model.User;
//import org.springframework.data.document.mongodb.MongoTemplate;
//import org.springframework.data.document.mongodb.query.Query;
//import org.springframework.data.document.mongodb.query.Update;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import static org.springframework.data.document.mongodb.query.Criteria.where;
//
//@Service("feedService")
//@Transactional
//public class FeedService {
//	@Resource(name="mongoTemplate")
//	
//	private MongoTemplate db;
//
//	public MongoTemplate getMongoTemplate() {
//		return db;
//	}
//
//	public void setMongoTemplate(MongoTemplate mongoTemplate) {
//		this.db = mongoTemplate;
//	}
//
//	public List<Feed> getAll() {
//        Query query = new Query(where("pid").exists(true));
//        List<Feed> feeds = db.find(query, Feed.class);
//        return feeds == null ? new ArrayList<Feed>(0) : feeds;
//	}
//	
//	public Feed get( String id ) throws EntityNotFoundException {
//		Feed feed = this.find(id);
//        if (feed == null) {
//        	throw new EntityNotFoundException("Cant't find Feed with id:" + id);
//        }
//		return feed;
//	}
//	
//	public Feed find(String id) {
//		Query query = new Query(where("pid").is(id));
//        Feed feed = db.findOne("txt4g", query, Feed.class);
//        return feed;
//	}
//	
//	public Boolean add(Feed feed) {
//		try {
//			feed.setId(UUID.randomUUID().toString());
//			db.insert("txt4g", feed);
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//	
//	public Boolean delete(Feed feed) {
//		try {
//			Query query = new Query(where("id").is(feed.getId()));
//	        db.remove(query);
//	        return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//	
//	public Boolean update(Feed feed) {
//		if (feed.getId() == null || "".equals(feed.getId())) {
//			add(feed);
//		} else {
//			Update update = new Update();
//			Query query = new Query(where("id").is(feed.getId()));
//			
//			update.set("name", feed.getName());
//			update.set("smsIdentifier", feed.getSmsIdentifier());
//			update.set("newsItems", feed.getNewsItems());
//			db.updateMulti(query, update);         			
//		}
//        return true;
//
//	}
//}
