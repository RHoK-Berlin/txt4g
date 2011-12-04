package org.rhok.txt4g.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QFeed is a Querydsl query type for Feed
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFeed extends EntityPathBase<Feed> {

    private static final long serialVersionUID = -1909637280;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QFeed feed = new QFeed("feed");

    public final StringPath created_at = createString("created_at");

    public final org.bson.types.QObjectId id;

    public final StringPath name = createString("name");

    public final SetPath<NewsItem, QNewsItem> newsItems = this.<NewsItem, QNewsItem>createSet("newsItems", NewsItem.class, QNewsItem.class);

    public final SetPath<String, StringPath> phoneNumbers = this.<String, StringPath>createSet("phoneNumbers", String.class, StringPath.class);

    public final StringPath smsIdentifier = createString("smsIdentifier");

    public QFeed(String variable) {
        this(Feed.class, forVariable(variable), INITS);
    }

    public QFeed(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFeed(PathMetadata<?> metadata, PathInits inits) {
        this(Feed.class, metadata, inits);
    }

    public QFeed(Class<? extends Feed> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

