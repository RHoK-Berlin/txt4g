package org.rhok.txt4g;

import org.rhok.txt4g.execution.SmsFeedJob;
import org.rhok.txt4g.execution.ThreadRunner;
import org.rhok.txt4g.service.FeedRepository;
import org.rhok.txt4g.service.NewsItemRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepositoryFactoryBean.MongoRepositoryFactory;

/**
 * Main class for the middleware.
 * 
 * @author ddebray, mwinter
 *
 */
public class Txt4gRunner {
	/**
	 * Main method.
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception{
    	
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring.xml");
    	MongoTemplate template = (MongoTemplate) ctx.getBean("mongoTemplate");
    	
    	SmsFeedJob job = (SmsFeedJob) ctx.getBean("smsfeedjob");
    	MongoRepositoryFactory factory = new MongoRepositoryFactory(template);

    	ThreadRunner<SmsFeedJob> tr = new ThreadRunner<SmsFeedJob>(job);
    	System.out.println("main called");
    	Thread t = new Thread(tr);
    	t.start();
    }
}